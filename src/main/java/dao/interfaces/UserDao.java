package dao.interfaces;

import domain.users.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getByLogin(String login);
}
