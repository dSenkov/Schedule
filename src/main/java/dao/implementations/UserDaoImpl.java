package dao.implementations;

import dao.interfaces.UserDao;
import domain.users.User;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> getByLogin(String login) {
        return null;
    }
}
