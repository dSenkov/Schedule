package service.implementations;

import dao.interfaces.FacultyDao;
import domain.FacultySort;
import domain.POJOs.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.FacultyService;

import java.util.ArrayList;
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
    public List<Faculty> getAll(String name, FacultySort sort, int offset, int limit) {
        List<Faculty> result = new ArrayList<>();
        switch (sort) {
            case NAME_ASC:
            case NAME_DESC:
                result = this.facultyDao.getAllSortedByName(name, sort == FacultySort.NAME_DESC, offset, limit);
                break;
            case BY_ID:
                result = this.facultyDao.getAllSortedById(name, offset, limit);
                break;
        }
        return result;
    }

    @Override
    public Faculty getById(Integer facultyId) {
        return facultyDao.getById(facultyId);
    }

    @Override
    public int getCount(String name) {
        return facultyDao.getCount(name);
    }

    @Override
    public Faculty create(Faculty faculty) {
        return facultyDao.save(faculty);
    }

    @Override
    public void update(Faculty faculty) {
        facultyDao.save(faculty);
    }

    @Override
    public void delete(Integer facultyId) {
        facultyDao.delete(facultyId);
    }
}
