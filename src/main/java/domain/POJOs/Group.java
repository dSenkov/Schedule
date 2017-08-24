package domain.POJOs;

import domain.users.Student;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private Integer id;
    private String name;
    private Integer facultyId;
    private Integer course;
    private List<Student> students;
    private List<Lesson> lessons;

    public Group() {
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public Group(String name, Integer facultyId, Integer course) {
        this.name = name;
        this.facultyId = facultyId;
        this.course = course;
    }

    public Group(Integer id, String name, Integer facultyId, Integer course, List<Student> students, List<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
        this.course = course;
        this.students = students;
        this.lessons = lessons;
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

    public Integer getFaculty() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }


    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
