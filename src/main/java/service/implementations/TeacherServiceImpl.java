package service.implementations;

import dao.interfaces.TeacherDao;
import domain.POJOs.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }
}
