package controller;

import domain.POJOs.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.interfaces.FacultyService;

@Controller
@RequestMapping("scheduleForStudents")
public class GroupController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public String showChooseGroupPage(Model model){
        model.addAttribute("faculty-list", facultyService.getAll());
        return "groupsJSP/chooseGroup";
    }

  /*  @PostMapping
    public String showSchedulePage(@ModelAttribute Group group)
    {

    }*/
}
