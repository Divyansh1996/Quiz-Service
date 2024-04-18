package com.question.Quiz.Service.service;

import com.question.Quiz.Service.models.Quiz;

import java.util.List;

public interface Service {

    public Quiz postData(Quiz quiz);
    public Quiz getData(int quizId);
    public List<Quiz> getAllData();
}
