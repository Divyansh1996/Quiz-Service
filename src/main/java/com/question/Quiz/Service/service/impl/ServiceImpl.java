package com.question.Quiz.Service.service.impl;


import com.question.Quiz.Service.models.Quiz;
import com.question.Quiz.Service.repository.DatabaseConnectivity;
import com.question.Quiz.Service.service.ConnectInterface;
import com.question.Quiz.Service.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private DatabaseConnectivity repository;

    private ConnectInterface connectInterface;

    public ServiceImpl(DatabaseConnectivity repository, ConnectInterface connectInterface) {
        this.repository = repository;
        this.connectInterface = connectInterface;
    }

    @Override
    public Quiz postData(Quiz quiz) {
        repository.save(quiz);
        return quiz;
    }

    @Override
    public Quiz getData(int quizId) {
        List<String> questionText = connectInterface.getAllQuestions().stream().filter(question -> question.getQuizId() == quizId).map(question -> question.getQuestion()).collect(Collectors.toList());
        Quiz quiz = repository.findById(quizId).get();
        quiz.setQuestionText(questionText);
        return quiz;

    }

    @Override
    public List<Quiz> getAllData() {
        List<Quiz> quizzes = repository.findAll();
        List<Quiz> ans = new ArrayList<>();
        for(Quiz quiz: quizzes){
            ans.add(getData(quiz.getQuizId()));
        }
        return ans;
    }
}
