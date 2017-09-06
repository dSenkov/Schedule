package dao.implementations;

import dao.interfaces.GroupDao;
import domain.POJOs.Group;
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
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAll() {
        Query query = entityManager.createQuery("SELECT g FROM Group g ORDER BY g.name", Group.class);
        return query.getResultList();
    }

    @Override
    public Group getById(Integer groupId) {
        return entityManager.find(Group.class, groupId);
    }

    @Override
    public List<Group> getByFaculty(Integer facultyId) {
        Query query = entityManager.createQuery("SELECT g FROM Group g WHERE g.faculty.id = :faculty_id", Group.class);
        query.setParameter("faculty_id", facultyId);
        return query.getResultList();
    }

    @Override
    public List<Group> getAllSortedByName(Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit) {
        TypedQuery<Group> query = this.entityManager.createQuery("SELECT g FROM Group g WHERE g.faculty.id = :faculty_id " +
                "AND g.name LIKE :name " +
                "AND (:min is NULL OR g.course >= :min) " +
                "AND (:max is NULL OR g.course <= :max) " +
                "ORDER BY g.name " + (desc ? "DESC " : "ASC "), Group.class);
        query.setParameter("faculty_id", facultyId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Group> getAllSortedByCourse(Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit) {
        TypedQuery<Group> query = this.entityManager.createQuery("SELECT g FROM Group g WHERE g.faculty.id = :faculty_id " +
                "AND g.name LIKE :name " +
                "AND (:min is NULL OR g.course >= :min) " +
                "AND (:max is NULL OR g.course <= :max) " +
                "ORDER BY g.course " + (desc ? "DESC " : "ASC "), Group.class);
        query.setParameter("faculty_id", facultyId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Group> getAllSortedById(Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit) {
        TypedQuery<Group> query = this.entityManager.createQuery("SELECT g FROM Group g WHERE g.faculty.id = :faculty_id " +
                "AND g.name LIKE :name " +
                "AND (:min is NULL OR g.course >= :min) " +
                "AND (:max is NULL OR g.course <= :max) " +
                "ORDER BY g.id " + (desc ? "DESC " : "ASC "), Group.class);
        query.setParameter("faculty_id", facultyId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public int getCount(Integer facultyId, String name, Integer min, Integer max) {
        TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(g) FROM Group g WHERE g.faculty.id = :faculty_id " +
                "AND g.name LIKE :name " +
                "AND (:min is NULL OR g.course >= :min) " +
                "AND (:max is NULL OR g.course <= :max) ", Long.class);
        query.setParameter("faculty_id", facultyId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getSingleResult().intValue();
    }

    @Override
    @Transactional
    public Group save(Group group) {
        if (group.getId() == null) {
            entityManager.persist(group);
            return group;
        } else {
            return entityManager.merge(group);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer groupId) {
        Query query = entityManager.createQuery("DELETE FROM Group g WHERE g.id = :group_id");
        query.setParameter("group_id", groupId);
        return query.executeUpdate() != 0;
    }
}
