package com.example.demo.controller;

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

    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity hola(@RequestParam("idTest") Long idtest) throws IOException {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        return response;
    }
}
