package dao.interfaces;

import domain.POJOs.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getByGroup (Integer groupId);
    List<Lesson> getByTeacher (Integer teacherId);
}
