package com.example.demo.controller;

import com.example.demo.service.AccionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by rolando on 31-03-20.
 */
@RestController
@RequestMapping("/accions")
public class AccionsController {

//    @Autowired
//    AccionsService accionsService;

    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity hola(@RequestParam("idCourse") Long idCourse) throws IOException {

        return new ResponseEntity<>(
                "Your idCourse is " + idCourse,
                HttpStatus.OK);

//        String nombre = accionsService.getCourse(idCourse);
//        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
//        return response;
    }
}
