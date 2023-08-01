package com.abdul.studentcoursemanagement.entities;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.entities

Class Name: StudentCourse

Date and Time:7/31/2023 10:33 PM

Version:1.0
*/

import javax.persistence.*;

@Entity
@Table(name = "student_courses")
public class StudentCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent( Student student ) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse( Course course ) {
        this.course = course;
    }
}
