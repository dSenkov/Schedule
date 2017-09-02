package controller;

import domain.POJOs.Exam;
import domain.POJOs.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.interfaces.ExamService;
import service.interfaces.LessonService;
import service.interfaces.TeacherService;

@Controller
@RequestMapping("scheduleForTeacher")
public class TeacherController {

    private TeacherService teacherService;
    private LessonService lessonService;
    private ExamService examService;

    @Autowired
    public TeacherController(TeacherService teacherService, LessonService lessonService, ExamService examService) {
        this.teacherService = teacherService;
        this.lessonService = lessonService;
        this.examService = examService;
    }

    @GetMapping
    public String showChooseTeacherPage(Model model){
        model.addAttribute("teacher-list", teacherService.getAll());
        return "teachersJSP/chooseTeacher";
    }

    @PostMapping("/TeacherLessons/{teacherId}")
    public String showTeacherLessonsSchedulePage(Model model, @PathVariable("teacherId") Integer teacherId)
    {
        model.addAttribute("teacher", teacherService.getById(teacherId));
        model.addAttribute("teacher-lessons", lessonService.getByTeacher(teacherId));
        return "teachersJSP/teacherLessonSchedule";
    }

    @PostMapping("/TeacherSession/{teacherId}")
    public String showTeacherSessionSchedulePage(Model model, @PathVariable("teacherId") Integer teacherId)
    {
        model.addAttribute("teacher", teacherService.getById(teacherId));
        model.addAttribute("teacher-exams", examService.getByTeacher(teacherId));
        return "teachersJSP/teacherExamSchedule";
    }
}
