/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author ryo
 */
public class UserDataBeans {
//    private int userID;
    private String name;
    private String year;
    private String month;
    private String day;
//    private Date birthday;
    private String tell;
    private String type;
    private String comment;
//    private Timestamp newDate;
    private ArrayList<String> error = new ArrayList<String>();
    
//    public int getUserID() {
//        return userID;
//    }
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    
//    public Date getBirthday(){
//        return birthday;
//    }
//    public void setBirthday(Date birthday){
//        this.birthday = birthday;
//    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
//    public Timestamp getNewDate() {
//        return newDate;
//    }
//    public void setNewDate(Timestamp newDate) {
//        this.newDate = newDate;
//    }
    public ArrayList<String> getError(){
        return error;
    }
    public void setError(String blank){
        this.error.add(blank);
    }

}
