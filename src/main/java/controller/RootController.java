package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String showMainPage() {
        return "mainPage";
    }



    @GetMapping("login")
    public String showLoginPage()
    {
        return "login";
    }
}
