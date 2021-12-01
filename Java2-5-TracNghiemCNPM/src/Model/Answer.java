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
public class Answer {
    private int Answer_Id;
    private String Answer_Content;
    private boolean Is_Correct;
    private int Question_Id;

    public Answer() {
    }

    public Answer(int Answer_Id, String Answer_Content, boolean Is_Correct, int Question_Id) {
        this.Answer_Id = Answer_Id;
        this.Answer_Content = Answer_Content;
        this.Is_Correct = Is_Correct;
        this.Question_Id = Question_Id;
    }

    public Answer(int Answer_Id) {
        this.Answer_Id = Answer_Id;
    }

    public int getAnswer_Id() {
        return Answer_Id;
    }

    public void setAnswer_Id(int Answer_Id) {
        this.Answer_Id = Answer_Id;
    }

    public String getAnswer_Content() {
        return Answer_Content;
    }

    public void setAnswer_Content(String Answer_Content) {
        this.Answer_Content = Answer_Content;
    }

    public boolean isIs_Correct() {
        return Is_Correct;
    }

    public void setIs_Correct(boolean Is_Correct) {
        this.Is_Correct = Is_Correct;
    }

    public int getQuestion_Id() {
        return Question_Id;
    }

    public void setQuestion_Id(int Question_Id) {
        this.Question_Id = Question_Id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Answer other = (Answer) obj;
        if (this.Answer_Id != other.Answer_Id) {
            return false;
        }
        return true;
    }
    
    
}
