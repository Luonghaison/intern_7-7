package com.example.baitap_ngay7_thang7.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/welcome")
@RestController
public class WelcomeController {


        @GetMapping("/index")
        public ResponseEntity<?> welcome(@RequestParam("name") String name){
    return new ResponseEntity<>(name, HttpStatus.OK);
        }
    }

