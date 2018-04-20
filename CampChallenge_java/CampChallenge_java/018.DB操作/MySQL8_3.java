/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;

/**
 *
 * @author ryo
 */
public class MySQL8_3 implements Serializable{
    
    private int profilesID;
    private String name;
    private String tel;
    private int age;
    private String birthday;

    public MySQL8_3(){}

    public int getProfilesID(){
        return profilesID;
    }
    
    public void setProfilesID(int profilesID){
        this.profilesID = profilesID;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getTel(){
        return tel;
    }
    
    public void setTel(String tel){
        this.tel = tel;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getBirthday(){
        return birthday;
    }
    
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

}
