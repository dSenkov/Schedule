package service.interfaces;

import domain.POJOs.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> getByGroup (Integer groupId);
    List<Exam> getByTeacher (Integer teacherId);
}
