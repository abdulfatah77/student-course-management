package com.abdul.studentcoursemanagement.service;

import com.abdul.studentcoursemanagement.entities.StudentCourses;
import java.util.List;
import java.util.Set;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service

Class Name: StudentCourseService

Date and Time:8/1/2023 1:15 PM

Version:1.0
*/
public interface StudentCourseService {
    List<StudentCourses> getAllStudentsWithCourses();
    List<StudentCourses>  updateStudentCourses( Long studentId, Set<Long> courseIds );
    void deleteStudentFromCourse( Long studentId, Long courseId );
}
