package com.project.question_service.repository;

import com.project.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    @Query(value="SELECT id FROM question where category=:category order by RAND() Limit :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
    @Query(value="SELECT * FROM question where category=:category order by RAND() Limit :numQ",nativeQuery = true)
    List<Question> getRandomQuestionsByCategory(String category, int numQ);
}
