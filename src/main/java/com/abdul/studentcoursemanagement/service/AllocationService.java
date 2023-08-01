package com.abdul.studentcoursemanagement.service;

import com.abdul.studentcoursemanagement.entities.Course;
import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.entities.StudentCourses;

/*Author Name: abdul.fatah
Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service

Interface Name: AllocationService

Date and Time:8/1/2023 1:00 PM

Version:1.0
*/
public interface AllocationService {
    StudentCourses allocateStudentToCourse( Long studentId, Long courseId );
}
