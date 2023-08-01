package com.abdul.studentcoursemanagement.controller;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.controller

Class Name: StudentController

Date and Time:8/1/2023 12:23 PM

Version:1.0
*/


import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.service.StudentService;
import com.abdul.studentcoursemanagement.utils.Constants;
import com.abdul.studentcoursemanagement.utils.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @Autowired
    JWTSecurity jwtSecurity;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Object> createStudent( @RequestBody Student student, HttpServletRequest request ) {
        Student createdStudent = new Student();
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);

        if (test) {
            createdStudent = StudentService.save(student);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
}
