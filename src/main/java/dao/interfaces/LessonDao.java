package dao.interfaces;

import domain.POJOs.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonDao {

    List<Lesson> getAll();

    Lesson getById(Integer lessonId);

    List<Lesson> getByGroup(Integer groupId);

    List<Lesson> getLessonsOfTheDay(Integer groupId, boolean firstWeek, DayOfWeek dayOfWeek);

    Lesson save(Lesson lesson);

    boolean delete (Integer lessonId);
}
