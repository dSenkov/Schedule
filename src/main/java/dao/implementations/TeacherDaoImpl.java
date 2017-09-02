package dao.implementations;

import dao.interfaces.TeacherDao;
import domain.POJOs.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAll() {
        Query query = entityManager.createQuery("SELECT t FROM Teacher t ORDER BY t.name", Teacher.class);
        return query.getResultList();
    }
}
