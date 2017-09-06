package dao.implementations;

import dao.interfaces.FacultyDao;
import domain.POJOs.Faculty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FacultyDaoImpl implements FacultyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Faculty> getAll() {
        Query query = entityManager.createQuery("SELECT f FROM Faculty f ORDER BY f.name", Faculty.class);
        return query.getResultList();
    }

    @Override
    public List<Faculty> getAllSortedByName(String name, boolean desc, int offset, int limit) {
        TypedQuery<Faculty> query = this.entityManager.createQuery("SELECT f FROM Faculty f " +
                "WHERE f.name LIKE :name " +
                "ORDER BY f.name " + (desc ? "DESC " : "ASC "), Faculty.class);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Faculty> getAllSortedById(String name, int offset, int limit) {
        TypedQuery<Faculty> query = this.entityManager.createQuery("SELECT f FROM Faculty f " +
                "WHERE f.name LIKE :name " +
                "ORDER BY f.id ", Faculty.class);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public Faculty getById(Integer facultyId) {
        return entityManager.find(Faculty.class, facultyId);
    }

    @Override
    public int getCount(String name) {
        TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(f) FROM Faculty f " +
                "WHERE f.name LIKE :name ", Long.class);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        return query.getSingleResult().intValue();
    }

    @Override
    @Transactional
    public Faculty save(Faculty faculty) {
        if (faculty.getId() == null) {
            entityManager.persist(faculty);
            return faculty;
        } else {
            return entityManager.merge(faculty);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer facultyId) {
        Query query = entityManager.createQuery("DELETE FROM Faculty f WHERE f.id = :faculty_id");
        query.setParameter("faculty_id", facultyId);
        return query.executeUpdate() != 0;
    }
}
