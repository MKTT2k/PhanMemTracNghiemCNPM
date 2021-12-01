/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Test_Question {

    private int T_QT_ID;
    private String Test_Code;
    private int Question_ID;

    public Test_Question() {
    }

    public Test_Question(int T_QT_ID, String Test_Code, int Question_ID) {
        this.T_QT_ID = T_QT_ID;
        this.Test_Code = Test_Code;
        this.Question_ID = Question_ID;
    }

    public Test_Question(String Test_Code, int Question_ID) {
        this.Test_Code = Test_Code;
        this.Question_ID = Question_ID;
    }
    
    

    public int getT_QT_ID() {
        return T_QT_ID;
    }

    public void setT_QT_ID(int T_QT_ID) {
        this.T_QT_ID = T_QT_ID;
    }

    public String getTest_Code() {
        return Test_Code;
    }

    public void setTest_Code(String Test_Code) {
        this.Test_Code = Test_Code;
    }

    public int getQuestion_ID() {
        return Question_ID;
    }

    public void setQuestion_ID(int Question_ID) {
        this.Question_ID = Question_ID;
    }

    
}
