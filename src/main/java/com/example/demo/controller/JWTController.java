package com.example.demo.controller;

import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by rolando on 31-03-20.
 */
@RestController
@RequestMapping("/token")
public class JWTController {

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity course() throws IOException {
        String token = jwtUtil.createToken("test");
        return new ResponseEntity<>("Bearer " + token, HttpStatus.OK);
    }

}
