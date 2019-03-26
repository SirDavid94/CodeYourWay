package vcu.cmsc355.codeyourway.Model;

public class Question {
    private String module1, CorrectAnswer, AnswerA, AnswerB, AnswerC, AnswerD, CategoryID, IsFillAnswer;

    public Question(String question, String correctAnswer, String answerA, String answerB, String answerC, String answerD, String categoryID, String isFillAnswer) {
        this.module1 = question;
        this.CorrectAnswer = correctAnswer;
        this.AnswerA = answerA;
        this.AnswerB = answerB;
        this.AnswerC = answerC;
        this.AnswerD = answerD;
        this.CategoryID = categoryID;
        this.IsFillAnswer = isFillAnswer;
    }

    public Question() {
    }

    public String getQuestion() {
        return module1;
    }

    public void setQuestion(String question) {
        this.module1 = question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.CorrectAnswer = correctAnswer;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        this.AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        this.AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        this.AnswerD = answerD;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        this.CategoryID = categoryID;
    }

    public String getIsFillAnswer() {
        return IsFillAnswer;
    }

    public void setIsFillAnswer(String isFillAnswer) {
        this.IsFillAnswer = isFillAnswer;
    }
}