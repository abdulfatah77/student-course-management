package com.abdul.studentcoursemanagement.service.impl;

import com.abdul.studentcoursemanagement.config.ResourceNotFoundException;
import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.entities.StudentCourses;
import com.abdul.studentcoursemanagement.repositories.CourseRepository;
import com.abdul.studentcoursemanagement.repositories.StudentCoursesRepository;
import com.abdul.studentcoursemanagement.repositories.StudentRepository;
import com.abdul.studentcoursemanagement.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service.impl

Class Name: AllocationServiceImpl

Date and Time:8/1/2023 1:00 PM

Version:1.0
*/
@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentCourses allocateStudentToCourse( Long studentId, Long courseId ) {

        // Fetch the student and course based on the provided IDs
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

        StudentCourses allocation = new StudentCourses();
        allocation.setStudent(student);
        allocation.setCourse(course);
        return studentCoursesRepository.save(allocation);
    }
}
