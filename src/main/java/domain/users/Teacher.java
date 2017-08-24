package domain.users;

import domain.POJOs.Lesson;
import domain.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

    private List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setRole() {
        super.setRole(UserRole.TEACHER);
    }

    public Teacher() {
        super();
        this.setRole();
        this.lessons = new ArrayList<>();
    }

    public Teacher(Integer id, String login, String password, String name, List<Lesson> lessons) {
        super(id, login, password, name, UserRole.TEACHER);
        this.lessons = lessons;
    }
}
