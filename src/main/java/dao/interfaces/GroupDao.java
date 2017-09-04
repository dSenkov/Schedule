package dao.interfaces;

import domain.POJOs.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAll();
    Group getById(Integer groupId);
    List<Group> getByFaculty (Integer facultyId);
}
