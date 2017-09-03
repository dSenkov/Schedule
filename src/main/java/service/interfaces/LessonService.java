package service.interfaces;

import domain.POJOs.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getByGroup (Integer groupId);
}
