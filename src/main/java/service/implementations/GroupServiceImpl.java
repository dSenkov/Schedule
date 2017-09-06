package service.implementations;

import dao.interfaces.GroupDao;
import domain.GroupSort;
import domain.POJOs.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.GroupService;

import java.util.ArrayList;
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

    @Override
    public List<Group> getByFaculty(Integer facultyId, String name, Integer min, Integer max, GroupSort sort, int offset, int limit) {
        List<Group> result = new ArrayList<>();
        switch (sort){
            case NAME_ASC:
            case NAME_DESC:
                result = this.groupDao.getAllSortedByName(facultyId, name, min, max, sort == GroupSort.NAME_DESC, offset, limit);
                break;
            case COURSE_ASC:
            case COURSE_DESC:
                result = this.groupDao.getAllSortedByCourse(facultyId, name, min, max, sort == GroupSort.COURSE_DESC, offset, limit);
                break;
            case ID_ASC:
            case ID_DESC:
                result = this.groupDao.getAllSortedById(facultyId, name, min, max, sort == GroupSort.ID_DESC, offset, limit);
                break;
        }
        return result;
    }

    @Override
    public int getCount(Integer facultyId, String name, Integer min, Integer max) {
        return groupDao.getCount(facultyId, name, min, max);
    }

    @Override
    public Group create(Group group) {
        return groupDao.save(group);
    }

    @Override
    public void update(Group group) {
        groupDao.save(group);
    }

    @Override
    public void delete(Integer groupId) {
        groupDao.delete(groupId);
    }
}
