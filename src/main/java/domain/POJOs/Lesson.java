package domain.POJOs;

import domain.LessonType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @Enumerated(EnumType.ORDINAL)
    private DayOfWeek   day;
    @Range(min = 1, max = 5)
    private Integer     number;
    @NotBlank(message = "Укажите название предмета.")
    private String      subject;
    @Enumerated(EnumType.STRING)
    private LessonType  type;
    @NotBlank(message = "Укажите имя преподователя.")
    private String      teacher;
    @NotNull(message = "Пожалуйста, укажите номер корпуса.")
    @Min(value = 1, message = "Номер корпуса должен быть целым числом больше нуля.")
    private Integer     building;
    @NotNull(message = "Пожалуйста, укажите номер аудитории.")
    @Min(value = 1, message = "Номер аудитории должен быть целым числом больше нуля.")
    private Integer     classroom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    public Lesson() {
        this.group = new Group();
    }

    public Lesson(Group group, boolean firstWeek, Integer day, Integer number) {
        this.group = group;
        this.firstWeek = firstWeek;
        this.day = DayOfWeek.of(day);
        this.number = number;
    }

    public Lesson(Integer id, boolean firstWeek, DayOfWeek day, Integer number, String subject, LessonType type, Integer building, Integer classroom, String teacher, Group group) {
        this.id = id;
        this.firstWeek = firstWeek;
        this.day = day;
        this.number = number;
        this.subject = subject;
        this.type = type;
        this.building = building;
        this.classroom = classroom;
        this.teacher = teacher;
        this.group = group;
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
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", firstWeek=" + firstWeek +
                ", day=" + day +
                ", number=" + number +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                ", teacher='" + teacher + '\'' +
                ", building=" + building +
                ", classroom=" + classroom +
                ", group=" + group +
                '}';
    }
}
