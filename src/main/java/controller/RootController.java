package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.interfaces.FacultyService;

@Controller
public class RootController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("faculty-list", facultyService.getAll());
        return "mainPage";
    }

}
