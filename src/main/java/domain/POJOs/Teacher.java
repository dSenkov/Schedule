package domain.POJOs;

import domain.enums.LessonType;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Teacher {

    private Integer id;
    private String name;
    private List<Lesson> lessons;
    private List<Lesson> exams;

    public Teacher() {
        this.lessons = lessons;
        this.exams = exams;
    }

    public Teacher(String name) {
        this.name = name;
        this.lessons = lessons;
        this.exams = exams;
    }

    public Teacher(Integer id, String name, List<Lesson> lessons, List<Lesson> exams) {
        this.id = id;
        this.name = name;
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
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public List<Lesson> getExams() {
        return exams;
    }
    public void setExams(List<Lesson> exams) {
        this.exams = exams;
    }


    public void addLesson(Lesson lesson)
    {
        if(lesson.getType() != LessonType.EXAM)
            this.lessons.add(lesson);
    }

    public void addExam(Lesson lesson)
    {
        if (lesson.getType() == LessonType.EXAM)
            this.exams.add(lesson);
    }
}
