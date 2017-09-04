package controller;

import domain.POJOs.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.interfaces.FacultyService;
import service.interfaces.GroupService;

import java.util.List;

@Controller
public class RootController {

    private FacultyService facultyService;
    private GroupService groupService;

    @Autowired
    public RootController(FacultyService facultyService, GroupService groupService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("faculty-list", facultyService.getAll());
        return "mainPage";
    }

}
