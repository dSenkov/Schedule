package dao.implementations;

import dao.interfaces.LessonDao;
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
    public List<Lesson> getAll() {
        Query query = entityManager.createQuery("SELECT l FROM Lesson l", Lesson.class);
        return query.getResultList();
    }

    @Override
    public Lesson getById(Integer lessonId) {
        return entityManager.find(Lesson.class, lessonId);
    }

    @Override
    public List<Lesson> getByGroup(Integer groupId) {
      return entityManager.createQuery("SELECT l FROM Lesson l JOIN l.groups g WHERE g.id = :group_id")
              .setParameter("group_id", groupId)
              .getResultList();
    }


}
