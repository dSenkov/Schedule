package controller;

import domain.POJOs.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.FacultyService;
import service.interfaces.GroupService;
import service.interfaces.LessonService;
import service.interfaces.ViewService;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class RootController {

    private FacultyService facultyService;
    private GroupService groupService;
    private LessonService lessonService;
    private ViewService viewService;

    @Autowired
    public RootController(FacultyService facultyService, GroupService groupService, LessonService lessonService, ViewService viewService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
        this.lessonService = lessonService;
        this.viewService = viewService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("facultyList", facultyService.getAll());
        return "chooseFaculty";
    }

    @PostMapping("/")
    public String showGroupList(@RequestParam("selectedFaculty") Integer facultyId, Model model)
    {
        model.addAttribute("groupList", groupService.getByFaculty(facultyId));
        return "chooseGroup";
    }

    @GetMapping("/schedule")
    public String showGroupSchedule(@RequestParam("selectedGroup") Integer groupId, Model model)
    {
        model.addAttribute("group", groupService.getById(groupId));
        model.addAttribute("lessonsOfTheFirstWeek", lessonService.getLessonsOfTheWeek(groupId, true));
        model.addAttribute("lessonsOfTheSecondWeek", lessonService.getLessonsOfTheWeek(groupId, false));
        model.addAttribute("viewService", viewService);
        return "groupLessonSchedule";
    }



}
