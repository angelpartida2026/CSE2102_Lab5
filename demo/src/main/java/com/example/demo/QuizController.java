package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {
    private final List<QuizQuestion> questions = List.of(
        new QuizQuestion("Is this lab 5?", true),
        new QuizQuestion("Is our professor named Adam?", false),
        new QuizQuestion("Is this for CSE1010", false)
    );
    private int currentQuestion = 0;
    private int score = 0;

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        if (currentQuestion < questions.size()) {
            QuizQuestion question = questions.get(currentQuestion);
            model.addAttribute("question", question.getQuestion());
            model.addAttribute("score", score);
            return "quiz";
        } else {
            model.addAttribute("finalScore", score);
            model.addAttribute("totalQuestions", questions.size());
            return "quiz-result";
        }
    }

    @PostMapping("/quiz-answer")
    public String checkAnswer(@RequestParam boolean answer) {
        if (questions.get(currentQuestion).getCorrectAnswer() == answer) {
            score++;
        }
        currentQuestion++;
        return "redirect:/quiz";
    }
}
