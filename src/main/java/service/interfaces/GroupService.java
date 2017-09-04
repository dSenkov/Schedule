package service.interfaces;

import domain.POJOs.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAll();
    Group getById(Integer groupId);
    List<Group> getByFaculty (Integer facultyId);
}
