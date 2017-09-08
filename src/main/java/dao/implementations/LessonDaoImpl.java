package dao.implementations;

import dao.interfaces.LessonDao;
import domain.POJOs.Lesson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.DayOfWeek;
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
        Query query = entityManager.createQuery("SELECT l FROM Lesson l WHERE l.group.id = :group_id", Lesson.class);
        query.setParameter("group_id", groupId);
        return query.getResultList();
    }

    @Override
    public List<Lesson> getLessonsOfTheDay(Integer groupId, boolean firstWeek, DayOfWeek dayOfWeek) {
        Query query = entityManager.createQuery("SELECT l FROM Lesson l WHERE l.group.id = :group_id " +
        "AND l.firstWeek = :firstweek AND l.day = :day ORDER BY l.number", Lesson.class);
        query.setParameter("group_id", groupId);
        query.setParameter("firstweek", firstWeek);
        query.setParameter("day", dayOfWeek);
        return query.getResultList();
    }
}
