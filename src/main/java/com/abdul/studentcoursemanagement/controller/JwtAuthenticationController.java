package com.abdul.studentcoursemanagement.controller;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.controller

Class Name: JwtAuthenticationController

Date and Time:8/1/2023 2:36 PM

Version:1.0
*/

import com.abdul.studentcoursemanagement.dtos.Login;
import com.abdul.studentcoursemanagement.dtos.TokenResponse;
import com.abdul.studentcoursemanagement.utils.Constants;
import com.abdul.studentcoursemanagement.utils.JWTSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class JwtAuthenticationController {

    @Autowired
    JWTSecurity generateJwtToken;

    @PostMapping
    public TokenResponse createStudent( @RequestBody Login login ) {
        TokenResponse tokenResponse = new TokenResponse();
        String jwtToken = generateJwtToken.generateJwtToken(Constants.exipreTime, Constants.jwtKey + Constants.setDEV);
        tokenResponse.setToken(jwtToken);
        return tokenResponse;
    }

}
