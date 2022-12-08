package com.init.initspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class GradeController {
    List<Grade> studentGrades = Arrays.asList(
            new Grade("Harry", "Arts", "A++"),
            new Grade("Mike", "Science", "B++")
    );
    @GetMapping("/grades")
    public String getGrades(Model model){

        model.addAttribute("grades", studentGrades);
        return "grades.html";
    }

    @GetMapping("/grades/create")
    public String gradeForm(Model model){
        model.addAttribute("grade", new Grade());
        return "form.html";
    }
}
