package service.interfaces;

import domain.POJOs.Faculty;
import java.util.List;

public interface FacultyService {

    List<Faculty> getAll();
    Faculty getById(Integer facultyId);
}
