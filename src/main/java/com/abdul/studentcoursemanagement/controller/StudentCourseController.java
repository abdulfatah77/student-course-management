package com.abdul.studentcoursemanagement.controller;

import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.entities.StudentCourses;
import com.abdul.studentcoursemanagement.service.AllocationService;
import com.abdul.studentcoursemanagement.service.CourseService;
import com.abdul.studentcoursemanagement.service.StudentCourseService;
import com.abdul.studentcoursemanagement.utils.Constants;
import com.abdul.studentcoursemanagement.utils.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.controller

Class Name: StudentCourseController

Date and Time:8/1/2023 12:37 PM

Version:1.0
*/

@RestController
@RequestMapping("/api/studentscourse")
public class StudentCourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    StudentCourseService studentCourseService;

    @Autowired
    AllocationService allocationService;

    @Autowired
    JWTSecurity jwtSecurity;


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> viewCourses( HttpServletRequest request ) {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @RequestMapping(value = "/allocations", method = RequestMethod.POST)
    public ResponseEntity<Object> allocateStudentToCourse(
            @RequestParam("studentId") Long studentId,
            @RequestParam("courseId") Long courseId, HttpServletRequest request
    ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);

        // Allocate the student to the course
        StudentCourses allocation = new StudentCourses();
        if (test) {
            allocation = allocationService.allocateStudentToCourse(studentId, courseId);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(allocation, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudentsWithCourses( HttpServletRequest request ) {
        List<StudentCourses> students = new ArrayList<>();
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);

        if (test) {
            students = studentCourseService.getAllStudentsWithCourses();
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/{studentId}/courses", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudentCourses(
            @PathVariable Long studentId,
            @RequestBody Set<Long> courseIds, HttpServletRequest request
    ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);
        List<StudentCourses> updatedStudentCourses = new ArrayList<>();
        if (test) {
            updatedStudentCourses = studentCourseService.updateStudentCourses(studentId, courseIds);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updatedStudentCourses, HttpStatus.OK);
    }


    @DeleteMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<Object> deleteStudentFromCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId, HttpServletRequest request
    ) {
        String key = Constants.jwtKey + Constants.setDEV;
        Boolean test = jwtSecurity.isJwtTokenValid(request.getHeader("Authorization"), key);
        List<StudentCourses> updatedStudentCourses = new ArrayList<>();
        if (test) {
            studentCourseService.deleteStudentFromCourse(studentId, courseId);
        } else {
            Map<String, String> res = new HashMap<>();
            res.put("message", "Full Authentication!");
            res.put("status", "400");
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
