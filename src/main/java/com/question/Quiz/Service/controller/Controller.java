package com.question.Quiz.Service.controller;


import com.question.Quiz.Service.models.Quiz;
import com.question.Quiz.Service.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public Quiz postData(@RequestBody Quiz quiz){
        service.postData(quiz);
        return quiz;
    }

    @GetMapping("/{quizId}")
    public Quiz getDataById(@PathVariable int quizId){
        return service.getData(quizId);
    }

    @GetMapping("/getAllData")
    public List<Quiz> getAllData(){
        return service.getAllData();
    }

}
