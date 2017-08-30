package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("scheduleForStudents")
public class GroupController {

    @GetMapping
    public String showChooseGroupPage(Model model){
        return "chooseGroup";
    }
}
