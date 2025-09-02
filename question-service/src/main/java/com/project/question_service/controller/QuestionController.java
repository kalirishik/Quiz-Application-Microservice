package com.project.question_service.controller;

import com.project.question_service.model.Question;
import com.project.question_service.model.QuestionWrapper;
import com.project.question_service.service.QuestionService;
import com.project.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/getQuestionsByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }
    @GetMapping("/countByCategory/{category}")
    public ResponseEntity<Long> countQuestionsByCategory(@PathVariable String category) {
        return questionService.countQuestionsByCategory(category);
    }

    @GetMapping("/getQuestionsByDifficulty/{level}")
    public ResponseEntity<List<Question>> getQuestionsByDifficulty(@PathVariable String level) {
        return questionService.getQuestionsByDifficulty(level);
    }
    // View all questions with pagination
    @GetMapping("/getQuestionsByPage")
    public ResponseEntity<Page<Question>> viewQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return questionService.viewQuestions(page, size);
    }
    @GetMapping("/getQuestionsByRandom/{category}/{numQ}")
    public ResponseEntity<List<Question>> getRandomQuestionsByCategory(
            @PathVariable String category,
            @PathVariable int numQ) {
        return questionService.getRandomQuestionsByCategory(category, numQ);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PostMapping("/addQuestions")
    public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions){
        return questionService.addQuestions(questions);
    }
    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }
    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }
    @GetMapping("/generateQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName,@RequestParam Integer numOfQuestions){
        return questionService.getQuestionsForQuiz(categoryName,numOfQuestions);
    }
    @PostMapping("/getQuestionsByIds")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromIds(questionIds);
    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
