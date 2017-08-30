package domain.POJOs;

import domain.enums.LessonType;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {

    private Integer id;
    private String name;
    private String rank;
    private List<Lesson> lessons;
    private List<Exam> exams;

    public Teacher() {
        this.lessons = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    public Teacher(String name, String rank) {
        this.name = name;
        this.rank = rank;
        this.lessons = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    public Teacher(Integer id, String name, String rank, List<Lesson> lessons, List<Exam> exams) {
        this.id = id;
        this.name = name;
        this.rank = rank;
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
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
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
