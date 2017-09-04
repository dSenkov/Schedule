package service.implementations;

import dao.interfaces.FacultyDao;
import domain.POJOs.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;


    @Override
    public List<Faculty> getAll() {
        return facultyDao.getAll();
    }

    @Override
    public Faculty getById(Integer facultyId) {
        return facultyDao.getById(facultyId);
    }
}
