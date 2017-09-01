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
    private Integer         groupId;
    private Integer         teacherId;

    public Exam() {
    }

    public Exam(Integer id, String subject, LocalDateTime dateTime, Integer building, Integer classroom, Integer groupId, Integer teacherId) {
        this.id = id;
        this.subject = subject;
        this.dateTime = dateTime;
        this.building = building;
        this.classroom = classroom;
        this.groupId = groupId;
        this.teacherId = teacherId;
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
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
