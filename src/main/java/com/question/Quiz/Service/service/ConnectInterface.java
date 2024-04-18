package com.question.Quiz.Service.service;

import com.question.Quiz.Service.models.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface ConnectInterface {

    @GetMapping("/question/getAllData")
    public List<Question> getAllQuestions();
}
