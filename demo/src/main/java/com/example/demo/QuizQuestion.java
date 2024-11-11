package com.example.demo;

public class QuizQuestion {
    private String question;
    private boolean correctAnswer;

    public QuizQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }
}
