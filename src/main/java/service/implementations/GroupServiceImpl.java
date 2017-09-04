package service.implementations;

import dao.interfaces.GroupDao;
import domain.POJOs.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Override
    public Group getById(Integer groupId) {
        return groupDao.getById(groupId);
    }

    @Override
    public List<Group> getByFaculty(Integer facultyId) {
        return groupDao.getByFaculty(facultyId);
    }
}
