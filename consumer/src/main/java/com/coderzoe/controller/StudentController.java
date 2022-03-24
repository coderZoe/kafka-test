package com.coderzoe.controller;

import com.coderzoe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderZoe
 * @date 2022/3/21 20:59
 */
@RestController
public class StudentController {
    private StudentService studentService;

    @GetMapping("/student")
    public int getByName(String name){
        return studentService.getByNameLike(name).size();
    }

    @GetMapping("/student2")
    public int getByName2(String name){
        return studentService.getByNameContains(name).size();
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
