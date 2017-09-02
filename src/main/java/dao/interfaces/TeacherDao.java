package dao.interfaces;

import domain.POJOs.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAll();
    Teacher getById (Integer teacherId);
}
