package domain.POJOs;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private Integer id;
    private String name;
    private List<Group> groups;

    public Faculty() {
        this.groups = new ArrayList<>();
    }

    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public Faculty(Integer id, String name, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


    public void addGroup (Group group){
        this.groups.add(group);
    }
}
