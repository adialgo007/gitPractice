package com.example.csvReaderQuestions.pojo;

import com.opencsv.bean.CsvBindByName;

public class Question {

    @CsvBindByName
    private String questionId;
    @CsvBindByName
    private String categoryId;
    @CsvBindByName
    private String difficulty;
    @CsvBindByName
    private String questionType;
    @CsvBindByName
    private String questionText;
    @CsvBindByName
    private String questionUrl;
    @CsvBindByName
    private String optionOne;
    @CsvBindByName
    private String optionTwo;
    @CsvBindByName
    private String optionThree;
    @CsvBindByName
    private String optionFour;
    @CsvBindByName
    private String answer;
    @CsvBindByName
    private String answerType;
    @CsvBindByName
    private String status;

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionText='" + questionText + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
                ", optionOne='" + optionOne + '\'' +
                ", optionTwo='" + optionTwo + '\'' +
                ", optionThree='" + optionThree + '\'' +
                ", optionFour='" + optionFour + '\'' +
                ", answer='" + answer + '\'' +
                ", answerType='" + answerType + '\'' +
                ", status=" + status +
                '}';
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
