package service.implementations;

import dao.interfaces.LessonDao;
import domain.POJOs.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.LessonService;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Lesson> getAll() {
        return lessonDao.getAll();
    }

    @Override
    public Lesson getById(Integer lessonId) {
        return lessonDao.getById(lessonId);
    }

    @Override
    public List<Lesson> getByGroup(Integer groupId) {
        return lessonDao.getByGroup(groupId);
    }

    @Override
    public Map<Integer, Lesson> getMapForLessonsOfTheDay(Integer groupId, boolean firstWeek, DayOfWeek dayOfWeek) {
        List<Lesson> lessonsOfTheDay = lessonDao.getLessonsOfTheDay(groupId, firstWeek, dayOfWeek);
        Map<Integer, Lesson> resultMap = new TreeMap<>();
        for (Lesson lesson : lessonsOfTheDay) {
            resultMap.put(lesson.getNumber(), lesson);
        }
        return resultMap;
    }

    @Override
    public List<Map<Integer, Lesson>> getLessonsOfTheWeek(Integer groupId, boolean firstWeek) {
        List<Map<Integer, Lesson>> resultList = new ArrayList<>(6);
        for (int i = 0; i < 6; i++){
            resultList.add(getMapForLessonsOfTheDay(groupId, firstWeek, DayOfWeek.of(i+1)));
        }
        return resultList;
    }
}
