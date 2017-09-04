package service.interfaces;

import domain.POJOs.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAll();
    Lesson getById (Integer lessonId);
    List<Lesson> getByGroup (Integer groupId);
}
