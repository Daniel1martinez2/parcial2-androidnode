package com.example.parcial2_androidnode;

public class Answer {
    String id, idQuestion;
    int response;

    public Answer() {
    }

    public Answer(String id, String idQuestion, int response) {
        this.id = id;
        this.idQuestion = idQuestion;
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
