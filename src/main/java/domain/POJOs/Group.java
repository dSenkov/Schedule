package domain.POJOs;

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

    private String name;
    private Integer course;


    public Group() {
        this.faculty = new Faculty();
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
}
