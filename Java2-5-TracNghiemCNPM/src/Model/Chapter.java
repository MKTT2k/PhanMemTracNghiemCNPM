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
public class Chapter {
    private int Chapter_Id, Chapter_Num;
    private String Chapter_Content;

    public Chapter(int Chapter_Id, int Chapter_Num, String Chapter_Content) {
        this.Chapter_Id = Chapter_Id;
        this.Chapter_Num = Chapter_Num;
        this.Chapter_Content = Chapter_Content;
    }

    public Chapter() {
    }

    public int getChapter_Id() {
        return Chapter_Id;
    }

    public void setChapter_Id(int Chapter_Id) {
        this.Chapter_Id = Chapter_Id;
    }

    public int getChapter_Num() {
        return Chapter_Num;
    }

    public void setChapter_Num(int Chapter_Num) {
        this.Chapter_Num = Chapter_Num;
    }

    public String getChapter_Content() {
        return Chapter_Content;
    }

    public void setChapter_Content(String Chapter_Content) {
        this.Chapter_Content = Chapter_Content;
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
        final Chapter other = (Chapter) obj;
        if (this.Chapter_Id != other.Chapter_Id) {
            return false;
        }
        return true;
    }
    
    
    
}
