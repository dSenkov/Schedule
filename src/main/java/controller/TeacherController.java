package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("scheduleForTeacher")
public class TeacherController {

    @GetMapping
    public String showChooseTeacherPage(){
        return "teachersJSP/chooseTeacher";
    }
}
