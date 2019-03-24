package vcu.cmsc355.codeyourway.Model;

public class Question {
    private String Question, CorrectAnswer, AnswerA, AnswerB, AnswerC, AnswerD, CategoryID, IsFillAnswer;

    public Question() {
    }


    public Question(String question, String correctAnswer, String answerA, String answerB, String answerC, String answerD, String categoryID, String isFillAnswer) {
        Question = question;
        CorrectAnswer = correctAnswer;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        CategoryID = categoryID;
        IsFillAnswer = isFillAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
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
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getIsFillAnswer() {
        return IsFillAnswer;
    }

    public void setIsFillAnswer(String isFillAnswer) {
        IsFillAnswer = isFillAnswer;
    }
}