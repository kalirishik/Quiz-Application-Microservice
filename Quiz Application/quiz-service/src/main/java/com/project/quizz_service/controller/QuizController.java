package com.project.quizz_service.controller;

import com.project.quizz_service.model.QuestionWrapper;
import com.project.quizz_service.model.Quiz;
import com.project.quizz_service.model.QuizDTO;
import com.project.quizz_service.model.Response;
import com.project.quizz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategoryName(),quizDTO.getNumOfQuestions(),quizDTO.getTitle());
    }
    @PostMapping("/submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
    @GetMapping("/getQuizById/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(@PathVariable int id){
        return quizService.getQuizQuestionsById(id);
    }
    @GetMapping("/getAllQuizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
    @DeleteMapping("/deleteQuiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable int id) {
        return quizService.deleteQuiz(id);
    }



}
