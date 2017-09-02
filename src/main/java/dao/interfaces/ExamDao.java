package dao.interfaces;

import domain.POJOs.Exam;

import java.util.List;

public interface ExamDao {

    List<Exam> getByGroup (Integer groupId);
    List<Exam> getByTeacher (Integer teacherId);
}
