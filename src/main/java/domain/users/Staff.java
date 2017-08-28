package domain.users;

import domain.enums.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Entity
public class Staff {

    private Integer id;
    private String login;
    private String password;
    private String name;
    private UserRole role;

    public Staff() { }

    public Staff(String login, String password, String name, UserRole role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public Staff(Integer id, String login, String password, String name, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
}
