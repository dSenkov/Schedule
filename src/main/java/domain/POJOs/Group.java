package domain.POJOs;

import domain.enums.LessonType;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer course;
    private Integer facultyId;
    private List<Lesson> lessons;
    private List<Exam> exams;

    public Group() {
        this.lessons = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    public Group(String name, Integer course, Integer facultyId) {
        this.name = name;
        this.course = course;
        this.facultyId = facultyId;
        this.lessons = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    public Group(Integer id, String name, Integer course, Integer facultyId, List<Lesson> lessons, List<Exam> exams) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.facultyId = facultyId;
        this.lessons = lessons;
        this.exams = exams;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }
    public Integer getFacultyId() {
        return facultyId;
    }
    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public List<Exam> getExams() {
        return exams;
    }
    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
    }
}
