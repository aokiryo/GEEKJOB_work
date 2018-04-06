/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.util.*;

/**
 *
 * @author ryo
 */
public abstract class Human {
    
    //手札
    protected ArrayList<Integer> myCards =new ArrayList<Integer>();
    
    //myCardsの要素の合計を返す
    public abstract int open();
    
    //myCardsに要素を加える
    public abstract void setCard(ArrayList<Integer> x);
    
    //open()の結果によってカードを引くか否か判断する
    public abstract boolean checkSum();
    
}
