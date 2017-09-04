package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.interfaces.FacultyService;
import service.interfaces.GroupService;
import service.interfaces.UserService;

@Controller
public class RootController {

    private FacultyService facultyService;
    private GroupService groupService;
    private UserService userService;

    @Autowired
    public RootController(FacultyService facultyService, GroupService groupService, UserService userService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("facultyList", facultyService.getAll());
        return "mainPage";
    }



}
