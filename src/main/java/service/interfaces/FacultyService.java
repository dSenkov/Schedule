package service.interfaces;

import domain.FacultySort;
import domain.POJOs.Faculty;
import java.util.List;

public interface FacultyService {

    List<Faculty> getAll();

    List<Faculty> getAll(String name, FacultySort sort, int offset, int limit);

    Faculty getById(Integer facultyId);

    int getCount(String name);

    Faculty create (Faculty faculty);

    void update (Faculty faculty);

    void delete (Integer facultyId);
}
