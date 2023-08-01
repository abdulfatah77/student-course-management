package com.abdul.studentcoursemanagement.service.impl;

import com.abdul.studentcoursemanagement.config.ResourceNotFoundException;
import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.entities.StudentCourses;
import com.abdul.studentcoursemanagement.repositories.CourseRepository;
import com.abdul.studentcoursemanagement.repositories.StudentCoursesRepository;
import com.abdul.studentcoursemanagement.repositories.StudentRepository;
import com.abdul.studentcoursemanagement.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service.impl

Class Name: StudentCoursesServiceImpl

Date and Time:8/1/2023 1:17 PM

Version:1.0
*/
@Service("StudentCoursesServiceImpl")
public class StudentCoursesServiceImpl implements StudentCourseService {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<StudentCourses> getAllStudentsWithCourses() {
        List<StudentCourses> studentCourses = studentCoursesRepository.findAll();
        return studentCourses;
    }

    @Override
    public List<StudentCourses> updateStudentCourses( Long studentId, Set<Long> courseIds ) {
        List<StudentCourses> student = studentCoursesRepository.findStudentsById(studentId);

        List<StudentCourses> studentCoursesList = new ArrayList<>();
        for (Long courseId : courseIds) {
            StudentCourses studentCourses = new StudentCourses();
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

            student.forEach(studentCourses1 -> {
                studentCourses.setCourse(course);
                studentCourses.setStudent(studentCourses1.getStudent());
                studentCourses.setId(studentCourses1.getId());
                studentCoursesList.add(studentCourses);
                studentCoursesRepository.save(studentCourses);
            });
        }

        return studentCoursesList;
    }

    @Override
    public void deleteStudentFromCourse( Long studentId, Long courseId ) {
        List<StudentCourses> student = studentCoursesRepository.findStudentsById(studentId);

        StudentCourses studentCourses = new StudentCourses();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

        student.forEach(studentCourses1 -> {
            studentCourses.setCourse(course);
            studentCourses.setStudent(studentCourses1.getStudent());
            studentCourses.setId(studentCourses1.getId());
            studentCoursesRepository.delete(studentCourses);
        });
    }
}
