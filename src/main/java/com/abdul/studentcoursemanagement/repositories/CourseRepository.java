package com.abdul.studentcoursemanagement.repositories;

/*Author Name: abdul.fatah
Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.repositories

Interface Name: CourseRepository

Date and Time:7/31/2023 11:11 PM

Version:1.0
*/
import com.abdul.studentcoursemanagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add custom queries if needed
}
