/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Test {
    private String Test_Code;
    private int Time;
    private int Level_Id;
    private boolean Display;
    private boolean Status;

    public Test() {
    }

    public Test(String Test_Code, int Time, int Level_Id, boolean Display, boolean Status) {
        this.Test_Code = Test_Code;
        this.Time = Time;
        this.Level_Id = Level_Id;
        this.Display = Display;
        this.Status = Status;
    }


    public String getTest_Code() {
        return Test_Code;
    }

    public void setTest_Code(String Test_Code) {
        this.Test_Code = Test_Code;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getLevel_Id() {
        return Level_Id;
    }

    public void setLevel_Id(int Level_Id) {
        this.Level_Id = Level_Id;
    }
    
    public boolean isDisplay() {
        return Display;
    }

    public void setDisplay(boolean Display) {
        this.Display = Display;
    }
    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Test other = (Test) obj;
        if (!Objects.equals(this.Test_Code, other.Test_Code)) {
            return false;
        }
        return true;
    }
    
    
}
