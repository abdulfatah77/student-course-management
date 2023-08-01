package com.abdul.studentcoursemanagement.service;

import com.abdul.studentcoursemanagement.entities.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service

Class Name: CourseService

Date and Time:8/1/2023 10:20 AM

Version:1.0
*/
public interface CourseService {
    Course save( Course course );

    List<Course> getAllCourses();

    Course updateCourse( Course course );

    void deleteById( Long id );
}
