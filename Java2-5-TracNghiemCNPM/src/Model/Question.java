/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Question {
    private int Question_Id;
    private String Question_Content;
    private int Chapter_Id, Level_Id;

    public Question() {
    }

    public Question(int Question_Id) {
        this.Question_Id = Question_Id;
    }

    public Question(int Question_Id, String Question_Content, int Chapter_Id, int Level_Id) {
        this.Question_Id = Question_Id;
        this.Question_Content = Question_Content;
        this.Chapter_Id = Chapter_Id;
        this.Level_Id = Level_Id;
    }

    public int getQuestion_Id() {
        return Question_Id;
    }

    public void setQuestion_Id(int Question_Id) {
        this.Question_Id = Question_Id;
    }

    public String getQuestion_Content() {
        return Question_Content;
    }

    public void setQuestion_Content(String Question_Content) {
        this.Question_Content = Question_Content;
    }

    public int getChapter_Id() {
        return Chapter_Id;
    }

    public void setChapter_Id(int Chapter_Id) {
        this.Chapter_Id = Chapter_Id;
    }

    public int getLevel_Id() {
        return Level_Id;
    }

    public void setLevel_Id(int Level_Id) {
        this.Level_Id = Level_Id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.Question_Id != other.Question_Id) {
            return false;
        }
        return true;
    }
    
    
}
