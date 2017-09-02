package dao.implementations;

import dao.interfaces.LessonDao;
import domain.POJOs.Lesson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class LessonDaoImpl implements LessonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getByGroup(Integer groupId) {
        return null;
    }

    @Override
    public List<Lesson> getByTeacher(Integer teacherId) {
        return null;
    }
}
