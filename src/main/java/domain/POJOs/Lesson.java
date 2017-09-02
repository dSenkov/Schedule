package domain.POJOs;

import domain.enums.LessonType;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer     id;
    private boolean     firstWeek;
    private DayOfWeek   day;
    private Integer     number;
    private String      subject;
    private LessonType  type;
    private Integer     building;
    private Integer     classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lessons_groups",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    public Lesson() {
        this.teacher = new Teacher();
        this.groups = new ArrayList<>();
    }

    public Lesson(boolean firstWeek, DayOfWeek day, Integer number, String subject, LessonType type, Integer building, Integer classroom, Teacher teacher, List<Group> groups) {
        this.firstWeek = firstWeek;
        this.day = day;
        this.number = number;
        this.subject = subject;
        this.type = type;
        this.building = building;
        this.classroom = classroom;
        this.teacher = teacher;
        this.groups = groups;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public boolean isFirstWeek() {
        return firstWeek;
    }
    public void setFirstWeek(boolean firstWeek) {
        this.firstWeek = firstWeek;
    }
    public DayOfWeek getDay() {
        return day;
    }
    public void setDay(DayOfWeek day) {
        this.day = day;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public LessonType getType() {
        return type;
    }
    public void setType(LessonType type) {
        this.type = type;
    }
    public Integer getBuilding() {
        return building;
    }
    public void setBuilding(Integer building) {
        this.building = building;
    }
    public Integer getClassroom() {
        return classroom;
    }
    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


}
