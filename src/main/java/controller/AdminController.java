package controller;

import domain.POJOs.Lesson;
import service.implementations.ViewServiceImpl;
import domain.FacultySort;
import domain.GroupSort;
import domain.POJOs.Faculty;
import domain.POJOs.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.interfaces.FacultyService;
import service.interfaces.GroupService;
import service.interfaces.LessonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.DayOfWeek;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private FacultyService facultyService;
    private GroupService groupService;
    private LessonService lessonService;
    private ViewServiceImpl viewService;

    private final int PAGE_SIZE = 5;

    @Autowired
    public AdminController(FacultyService facultyService, GroupService groupService, LessonService lessonService, ViewServiceImpl viewService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
        this.lessonService = lessonService;
        this.viewService = viewService;
    }
////////////////////////////////////////// F A C U L T Y S ////////////////////////////////////////////////////////////

    @GetMapping("/facultys")
    public String showAdminPage(Model model,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "sort", required = false) FacultySort sort,
                                @RequestParam(value = "page", defaultValue = "1") int page) {
        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;
        if (sort == null) sort = FacultySort.NAME_ASC;
        model.addAttribute("facultyList", facultyService.getAll(name, sort, offset, limit));
        model.addAttribute("facultyCount", facultyService.getCount(name));
        model.addAttribute("pageSize", PAGE_SIZE);
        return "admin/facultys";
    }

    @GetMapping("/newFaculty")
    public String showNewFacultyPage(Model model) {
        model.addAttribute("faculty", new Faculty());
        model.addAttribute("isNew", true);
        return "admin/faculty-edit";
    }

    @PostMapping("/newFaculty")
    public String saveNewFaculty(@Valid @ModelAttribute Faculty faculty,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("isNew", true);
            return "admin/faculty-edit";
        }
        Faculty createdFaculty = facultyService.create(faculty);
        return "redirect:/admin/facultys/" + createdFaculty.getId();
    }

    @GetMapping("/facultys/{facultyId}")
    public String showEditFacultyPage(@PathVariable("facultyId") Integer facultyId, Model model) {
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("isNew", false);
        return "admin/faculty-edit";
    }

    @PostMapping("facultys/{facultyId}")
    public String editFaculty(@Valid @ModelAttribute Faculty faculty,
                              BindingResult bindingResult,
                              @PathVariable("facultyId") Integer facultyId,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/faculty-edit";
        }
        faculty.setId(facultyId);
        facultyService.update(faculty);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/admin/facultys/" + facultyId;
    }

    @PostMapping("/facultys/{facultyId}/delete")
    public String deleteFaculty(@PathVariable("facultyId") Integer facultyId) {
        facultyService.delete(facultyId);
        return "redirect:/admin/facultys/";
    }
////////////////////////////////////////// G R O U P S ////////////////////////////////////////////////////////////////

    @GetMapping("facultys/{facultyId}/groups")
    public String showGroupsOfThisFaculty(@PathVariable("facultyId") Integer facultyId, Model model,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "min", required = false) Integer min,
                                          @RequestParam(value = "max", required = false) Integer max,
                                          @RequestParam(value = "sort", required = false) GroupSort sort,
                                          @RequestParam(value = "page", defaultValue = "1") int page) {
        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;
        if (sort == null) sort = GroupSort.NAME_ASC;
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("groupList", groupService.getByFaculty(facultyId, name, min, max, sort, offset, limit));
        model.addAttribute("groupCount", groupService.getCount(facultyId, name, min, max));
        model.addAttribute("pageSize", PAGE_SIZE);
        return "admin/groups";
    }

    @GetMapping("facultys/{facultyId}/newGroup")
    public String showNewGroupPage(@PathVariable("facultyId") Integer facultyId, Model model) {
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("group", new Group(facultyService.getById(facultyId)));
        model.addAttribute("isNew", true);
        return "admin/group-edit";
    }

    @PostMapping("facultys/{facultyId}/newGroup")
    public String saveNewGroup(@Valid @ModelAttribute Group group,
                               BindingResult bindingResult,
                               @PathVariable("facultyId") Integer facultyId,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculty", facultyService.getById(facultyId));
            model.addAttribute("isNew", true);
            return "admin/group-edit";
        }
        Group createdGroup = groupService.create(group);
        return "redirect:/admin/facultys/" + facultyId + "/groups/" + createdGroup.getId();
    }

    @GetMapping("facultys/{facultyId}/groups/{groupId}")
    public String showEditGroupPage(@PathVariable("facultyId") Integer facultyId,
                                    @PathVariable("groupId") Integer groupId,
                                    Model model) {
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("group", groupService.getById(groupId));
        model.addAttribute("isNew", false);
        return "admin/group-edit";
    }

    @PostMapping("facultys/{facultyId}/groups/{groupId}")
    public String editGroup(@Valid @ModelAttribute Group group,
                            BindingResult bindingResult,
                            @PathVariable("facultyId") Integer facultyId,
                            @PathVariable("groupId")   Integer groupId,
                            RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculty", facultyService.getById(facultyId));
            model.addAttribute("isNew", false);
            return "admin/group-edit";
        }
        group.setId(groupId);
        group.setFaculty(facultyService.getById(facultyId));
        groupService.update(group);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/admin/facultys/" + facultyId + "/groups/" + groupId;

    }

    @PostMapping("/facultys/{facultyId}/groups/{groupId}/delete")
    public String deleteGroup(@PathVariable("facultyId") Integer facultyId,
                              @PathVariable("groupId")   Integer groupId) {
        groupService.delete(groupId);
        return "redirect:/admin/facultys/" + facultyId + "/groups";
    }
////////////////////////////////////// L E S S O N S //////////////////////////////////////////////////////////////////

    @GetMapping("/facultys/{facultyId}/groups/{groupId}/lessons")
    public String showGroupSchedule(@PathVariable("facultyId") Integer facultyId,
                                    @PathVariable("groupId") Integer groupId, Model model){
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("group", groupService.getById(groupId));

        model.addAttribute("wholeLessonList", lessonService.getByGroup(groupId));
        model.addAttribute("lessonsOfTheFirstWeek", lessonService.getLessonsOfTheWeek(groupId, true));
        model.addAttribute("lessonsOfTheSecondWeek", lessonService.getLessonsOfTheWeek(groupId, false));
        model.addAttribute("viewService", viewService);
        return "admin/lessons";
    }

    @GetMapping("/facultys/{facultyId}/groups/{groupId}/lessons/newLesson")
    public String showNewLessonpage(@PathVariable("facultyId") Integer facultyId,
                                    @PathVariable("groupId") Integer groupId,
                                   HttpServletRequest request, Model model)
    {
        model.addAttribute("faculty", facultyService.getById(facultyId));
        model.addAttribute("group", groupService.getById(groupId));
        model.addAttribute("lesson", new Lesson(groupService.getById(groupId), Boolean.parseBoolean(request.getParameter("firstWeek")),
                DayOfWeek.valueOf(request.getParameter ("day")), Integer.parseInt(request.getParameter("lessonNumber"))));
        return "admin/lesson-edit";
    }

    @PostMapping("/facultys/{facultyId}/groups/{groupId}/lessons/newLesson")
    public String saveNewLesson(@PathVariable("facultyId") Integer facultyId,
                                @PathVariable("groupId") Integer groupId,
                                @Valid @ModelAttribute("lesson") Lesson lesson,
                                BindingResult bindingResult, Model model,
                                HttpServletRequest request)
    {
        if (bindingResult.hasErrors()){
            model.addAttribute("faculty", facultyService.getById(facultyId));
            model.addAttribute("group", groupService.getById(groupId));
            return "admin/lesson-edit";
        }
        lessonService.create(lesson);
        return "redirect:/admin/facultys/" + facultyId + "/groups/" + groupId + "/lessons";
    }

    @GetMapping("/facultys/{facultyId}/groups/{groupId}/lessons/{lessonId}/delete")
    public String deleteLesson(@PathVariable("facultyId") Integer facultyId,
                               @PathVariable("groupId") Integer groupId,
                               @PathVariable("lessonId") Integer lessonId){
        lessonService.delete(lessonId);
        return "redirect:/admin/facultys/" + facultyId + "/groups/" + groupId + "/lessons";
    }


}
