/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.ArrayList;

/**
 *
 * @author ryo
 */
public class MySQL13_beans {
    
//    private String userName;
//    private String password;
    private boolean log = false;
//    private int pID;
//    private String pName;
//    private int pPrice;
//    private String pCategory;
    private ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();
    
    public MySQL13_beans(){}
    
//    public String getUserName(){
//        return userName;
//    }
//    
//    public void setUserName(String userName){
//        this.userName = userName;
//    }
//    
//    public String getPassword(){
//        return password;
//    }
//    
//    public void setPassword(String password){
//        this.password = password;
//    }
    
    public boolean getLog(){
        return log;
    }
    
    public void setLog(boolean log){
        this.log = log;
    }
    
//    public int getPID(){
//        return pID;
//    }
//    
//    public void setPID(int pID){
//        this.pID = pID;
//    }
//    
//    public String getPName(){
//        return pName;
//    }
//    
//    public void setPName(String pName){
//        this.pName = pName;
//    }
//    
//    public int getPPrice(){
//        return pPrice;
//    }
//    
//    public void setLog(int pPrice){
//        this.pPrice = pPrice;
//    }
//    
//    public String getPCategory(){
//        return pCategory;
//    }
//    
//    public void setPCategory(String pCategory){
//        this.pCategory = pCategory;
//    }
    public ArrayList<ArrayList<String>> getProducts(){
        return products;
    }
    
    public void setProducts(ArrayList<String> list){
        this.products.add(list);
    }

}
