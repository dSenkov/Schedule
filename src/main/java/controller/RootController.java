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

    @Autowired
    public RootController(FacultyService facultyService, GroupService groupService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("facultys", facultyService.getAll());
        model.addAttribute("groupService", groupService);
        return "mainPage";
    }



}
