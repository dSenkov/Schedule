package controller;

import domain.FacultySort;
import domain.POJOs.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.interfaces.FacultyService;
import service.interfaces.GroupService;
import service.interfaces.LessonService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private FacultyService facultyService;
    private GroupService groupService;
    private LessonService lessonService;
    private final int PAGE_SIZE = 5;

    @Autowired
    public AdminController(FacultyService facultyService, GroupService groupService, LessonService lessonService) {
        this.facultyService = facultyService;
        this.groupService = groupService;
        this.lessonService = lessonService;
    }

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
        if  (bindingResult.hasErrors()) {
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
        if  (bindingResult.hasErrors()) {
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

    @GetMapping("facultys/{facultyId}/groups")
    public String showGroupsOfThisFaculty(@PathVariable("facultyId") Integer facultyId, Model model) {
        model.addAttribute("groupList", groupService.getByFaculty(facultyId));
        return "admin/groups";
    }


}
