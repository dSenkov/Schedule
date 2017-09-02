package service.implementations;

import dao.interfaces.LessonDao;
import domain.POJOs.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Lesson> getByGroup(Integer groupId) {
        return lessonDao.getByGroup(groupId);
    }

    @Override
    public List<Lesson> getByTeacher(Integer teacherId) {
        return lessonDao.getByTeacher(teacherId);
    }
}
