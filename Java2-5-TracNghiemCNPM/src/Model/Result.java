/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Result {
    private int Result_ID;
    private String Username;
    private String Test_Code;
    private int WorkTime;
    private int NumOfCorrect_Test;
    private Date date;

    public Result() {
    }

    public Result(int Result_ID, String Username, String Test_Code, int WorkTime, int NumOfCorrect_Test, Date date) {
        this.Result_ID = Result_ID;
        this.Username = Username;
        this.Test_Code = Test_Code;
        this.WorkTime = WorkTime;
        this.NumOfCorrect_Test = NumOfCorrect_Test;
        this.date = date;
    }

    public Result(String Username, String Test_Code, int WorkTime, int NumOfCorrect_Test) {
        this.Username = Username;
        this.Test_Code = Test_Code;
        this.WorkTime = WorkTime;
        this.NumOfCorrect_Test = NumOfCorrect_Test;
    }

    

    public Result(String Test_Code) {
        this.Test_Code = Test_Code;
    }
    

    public int getResult_ID() {
        return Result_ID;
    }

    public void setResult_ID(int Result_ID) {
        this.Result_ID = Result_ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getTest_Code() {
        return Test_Code;
    }

    public void setTest_Code(String Test_Code) {
        this.Test_Code = Test_Code;
    }

    public int getWorkTime() {
        return WorkTime;
    }

    public void setWorkTime(int WorkTime) {
        this.WorkTime = WorkTime;
    }

    public int getNumOfCorrect_Test() {
        return NumOfCorrect_Test;
    }

    public void setNumOfCorrect_Test(int NumOfCorrect_Test) {
        this.NumOfCorrect_Test = NumOfCorrect_Test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
