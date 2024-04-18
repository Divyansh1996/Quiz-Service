package com.question.Quiz.Service.repository;

import com.question.Quiz.Service.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseConnectivity extends JpaRepository<Quiz, Integer> {
}
