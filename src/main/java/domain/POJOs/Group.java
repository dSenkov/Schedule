package domain.POJOs;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @NotBlank(message = "Обязательное поле")
    private String name;

    @Range(min = 1, max = 6)
    private Integer course;


    public Group() {
        this.faculty = new Faculty();
    }

    public Group(Faculty faculty) {
        this.faculty = faculty;
    }

    public Group(Integer id, String name, Integer course, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.faculty = faculty;
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
    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
