package domain.POJOs;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer         id;
    private String          subject;
    private LocalDateTime   dateTime;
    private Integer         building;
    private Integer         classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Exam() {
    }

    public Exam(Integer id, String subject, LocalDateTime dateTime, Integer building, Integer classroom, Group group, Teacher teacher) {
        this.id = id;
        this.subject = subject;
        this.dateTime = dateTime;
        this.building = building;
        this.classroom = classroom;
        this.group = group;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
}
