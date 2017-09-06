package dao.interfaces;

import domain.GroupSort;
import domain.POJOs.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAll();

    Group getById(Integer groupId);

    List<Group> getByFaculty(Integer facultyId);

    List<Group> getAllSortedByName  (Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit);

    List<Group> getAllSortedByCourse(Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit);

    List<Group> getAllSortedById    (Integer facultyId, String name, Integer min, Integer max, boolean desc, int offset, int limit);

    int getCount(Integer facultyId, String name, Integer min, Integer max);

    Group save (Group group);

    boolean delete (Integer groupId);
}
