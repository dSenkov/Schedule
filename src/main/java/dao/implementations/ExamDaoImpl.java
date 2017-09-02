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
        Query query = entityManager.createQuery("SELECT e FROM Exam e WHERE e.group.id = :group_id", Exam.class);
        query.setParameter("group_id", groupId);
        return query.getResultList();
    }

    @Override
    public List<Exam> getByTeacher(Integer teacherId) {
        Query query = entityManager.createQuery("SELECT e FROM Exam e WHERE e.teacher.id = :teacher_id", Exam.class);
        query.setParameter("teacher_id", teacherId);
        return query.getResultList();
    }
}
