package com.abdul.studentcoursemanagement.service.impl;

import com.abdul.studentcoursemanagement.entities.Student;
import com.abdul.studentcoursemanagement.repositories.StudentRepository;
import com.abdul.studentcoursemanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.service.impl

Class Name: StudentServiceImpl

Date and Time:8/1/2023 12:22 PM

Version:1.0
*/

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save( Student student ) {
        Student createdStudent = studentRepository.save(student);
        return createdStudent;
    }
}
