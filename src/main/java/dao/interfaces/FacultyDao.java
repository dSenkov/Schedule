package dao.interfaces;

import domain.POJOs.Faculty;

import java.util.List;

public interface FacultyDao {

    List<Faculty> getAll();

    List<Faculty> getAllSortedByName(String name, boolean desc, int offset, int limit);

    List<Faculty> getAllSortedById(String name, int offset, int limit);

    Faculty getById(Integer facultyId);

    int getCount (String name);

    Faculty save (Faculty faculty);

    boolean delete (Integer facultyId);
}
