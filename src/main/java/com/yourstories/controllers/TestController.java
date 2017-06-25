package com.yourstories.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by varun on २५-०६-२०१७.
 */
@RestController
public class TestController {
    @RequestMapping(value={"/api/v1/test"},method = {RequestMethod.GET})
    public ResponseEntity<?> returnMe(){
        return new ResponseEntity<Object>("hey it is working fine", HttpStatus.OK);
    }
}