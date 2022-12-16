package com.example.jpa.semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semesters/")
public class SemesterController {
    @Autowired
    private SemesterRepository semesterRepository;

    @GetMapping
    public List<Semester> getSemester(){
        return semesterRepository.findAll();
    }

    @PostMapping
    public Semester createSemester(@RequestBody Semester semester){
        return semesterRepository.save(semester);
    }
}
