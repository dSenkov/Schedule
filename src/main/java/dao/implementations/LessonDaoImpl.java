package dao.implementations;

import dao.interfaces.LessonDao;
import domain.POJOs.Exam;
import domain.POJOs.Lesson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class LessonDaoImpl implements LessonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getByGroup(Integer groupId) {
      return  null;
    }

    @Override
    public List<Lesson> getByTeacher(Integer teacherId) {
        Query query = entityManager.createQuery("SELECT l FROM Lesson l WHERE l.teacher.id = :teacher_id", Lesson.class);
        query.setParameter("teacher_id", teacherId);
        return query.getResultList();
    }
}
