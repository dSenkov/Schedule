package dao.implementations;

import dao.interfaces.ExamDao;
import domain.POJOs.Exam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ExamDaoImpl implements ExamDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Exam> getByGroup(Integer groupId) {
        Query query = entityManager.createQuery("SELECT ")
    }

    @Override
    public List<Exam> getByTeacher(Integer teacherId) {
        return null;
    }
}
