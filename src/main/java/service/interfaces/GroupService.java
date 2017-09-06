package service.interfaces;

import domain.GroupSort;
import domain.POJOs.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAll();

    Group getById(Integer groupId);

    List<Group> getByFaculty(Integer facultyId);

    List<Group> getByFaculty(Integer facultyId, String name, Integer min, Integer max, GroupSort sort, int offset, int limit);

    int getCount(Integer facultyId, String name, Integer min, Integer max);

    Group create(Group group);

    void update(Group group);

    void delete(Integer groupId);
}
