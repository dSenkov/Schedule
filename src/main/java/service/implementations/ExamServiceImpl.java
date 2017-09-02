package service.implementations;

import dao.interfaces.ExamDao;
import domain.POJOs.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.ExamService;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Override
    public List<Exam> getByGroup(Integer groupId) {
        return examDao.getByGroup(groupId);
    }

    @Override
    public List<Exam> getByTeacher(Integer teacherId) {
        return examDao.getByTeacher(teacherId);
    }
}
