/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author ryo
 */
public class CallClass2 {
    public static void main(String[] args){
        
        //Inheritance1クラスのインスタンス生成
        Inheritance1 test1 = new Inheritance1();
        
        //挿入したいメッセージ
        String x = "課題全部終わるまで帰れま";
        int y = 10;
        
        //メソッドの実行
        test1.insertion(x, y);
        test1.clea();
        test1.display();

    }
    
}
