package dao.implementations;

import dao.interfaces.GroupDao;
import domain.POJOs.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
}
