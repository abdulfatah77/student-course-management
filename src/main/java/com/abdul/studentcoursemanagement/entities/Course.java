package com.abdul.studentcoursemanagement.entities;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.entities

Class Name: Course

Date and Time:7/31/2023 10:33 PM

Version:1.0
*/


import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor", nullable = false)
    private String instructor;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId( Long courseId ) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor( String instructor ) {
        this.instructor = instructor;
    }
}