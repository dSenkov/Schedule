package dao.interfaces;

import domain.POJOs.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAll();
    Lesson getById (Integer lessonId);
    List<Lesson> getByGroup (Integer groupId);
}
