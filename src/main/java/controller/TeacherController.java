package controller;

import domain.POJOs.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.interfaces.TeacherService;

@Controller
@RequestMapping("scheduleForTeacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public String showChooseTeacherPage(Model model){
        model.addAttribute("teacher-list", teacherService.getAll());
        return "teachersJSP/chooseTeacher";
    }

    @PostMapping
    public String showTeacherSchedulePage(@ModelAttribute("teacher") Teacher teacher)
    {

    }
}
