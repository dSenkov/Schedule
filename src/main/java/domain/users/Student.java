package domain.users;

import domain.enums.UserRole;

public class Student extends User {

    private Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setRole() {
        super.setRole(UserRole.STUDENT);
    }

    public Student()
    {
        super();
        this.setRole();
    }

    public Student(Integer id, String login, String password, String name, Integer groupId) {
        super(id, login, password, name, UserRole.STUDENT);
        this.groupId = groupId;
    }
}
