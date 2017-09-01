package dao.implementations;

import dao.interfaces.FacultyDao;
import domain.POJOs.Faculty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FacultyDaoImpl implements FacultyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Faculty> getAll() {
        Query query = this.entityManager.createQuery("SELECT f FROM Faculty f ORDER BY f.name", Faculty.class);
                return query.getResultList();
    }
}
