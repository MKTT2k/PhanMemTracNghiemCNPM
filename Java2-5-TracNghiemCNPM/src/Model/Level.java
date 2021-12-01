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
public class Level {
    private int Level_Id;
    private String Level_Name;

    public Level() {
    }

    public Level(int Level_Id, String Level_Name) {
        this.Level_Id = Level_Id;
        this.Level_Name = Level_Name;
    }

    public int getLevel_Id() {
        return Level_Id;
    }

    public void setLevel_Id(int Level_Id) {
        this.Level_Id = Level_Id;
    }

    public String getLevel_Name() {
        return Level_Name;
    }

    public void setLevel_Name(String Level_Name) {
        this.Level_Name = Level_Name;
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
        final Level other = (Level) obj;
        if (this.Level_Id != other.Level_Id) {
            return false;
        }
        return true;
    }
    
    
}
