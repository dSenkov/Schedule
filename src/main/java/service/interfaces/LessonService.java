package service.interfaces;

import domain.POJOs.Lesson;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public interface LessonService {

    List<Lesson> getAll();
    Lesson getById (Integer lessonId);
    List<Lesson> getByGroup (Integer groupId);

    Map<Integer, Lesson> getMapForLessonsOfTheDay(Integer groupId, boolean firstWeek, DayOfWeek dayOfWeek);
    List<Map<Integer, Lesson>> getLessonsOfTheWeek(Integer groupId, boolean firstWeek);
}
