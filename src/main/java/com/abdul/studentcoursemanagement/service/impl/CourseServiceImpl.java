package com.abdul.studentcoursemanagement.service.impl;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service.impl

Class Name: CourseServiceImpl

Date and Time:8/1/2023 10:21 AM

Version:1.0
*/

import com.abdul.studentcoursemanagement.config.ResourceNotFoundException;
import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.repositories.CourseRepository;
import com.abdul.studentcoursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save( Course course ) {
        Course createdCourse = courseRepository.save(course);
        return createdCourse;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course updateCourse(  Course course ) {
        Course existingCourse = courseRepository.findById(course.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + course.getCourseId()));

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setInstructor(course.getInstructor());

        Course updatedCourse = courseRepository.save(existingCourse);
        return updatedCourse;
    }

    @Override
    public void deleteById( Long id ) {
        courseRepository.deleteById(id);
    }

}
