package com.abdul.studentcoursemanagement.controller;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.controller

Class Name: CourseController

Date and Time:8/1/2023 10:20 AM

Version:1.0
*/

import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.service.CourseService;
import com.abdul.studentcoursemanagement.utils.Constants;
import com.abdul.studentcoursemanagement.utils.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    JWTSecurity jwtSecurity;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Object> createCourse( @RequestBody Course course, HttpServletRequest request ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);
        Course createdCourse = new Course();
        if (test) {
            createdCourse = courseService.save(course);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCourses( HttpServletRequest request ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);
        List<Course> courses = new ArrayList<>();
        if (test) {
            courses = courseService.getAllCourses();
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCourse( @RequestBody Course course, HttpServletRequest request ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);
        Course updatedCourse = new Course();
        if (test) {
            updatedCourse = courseService.updateCourse(course);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteCourse( @PathVariable Long id, HttpServletRequest request ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);

        if (test) {
            courseService.deleteById(id);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

