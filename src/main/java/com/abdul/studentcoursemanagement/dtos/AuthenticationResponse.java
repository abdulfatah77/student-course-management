package com.abdul.studentcoursemanagement.dtos;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.dtos

Class Name: UserResponse

Date and Time:7/31/2023 11:45 PM

Version:1.0
*/
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
