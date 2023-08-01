package com.abdul.studentcoursemanagement.repositories;

/*Author Name: abdul.fatah
Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.repositories

Interface Name: StudentCoursesRepository

Date and Time:7/31/2023 11:11 PM

Version:1.0
*/

import com.abdul.studentcoursemanagement.entities.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Long> {
    List<StudentCourses> findStudentsById( Long studentId );
}
