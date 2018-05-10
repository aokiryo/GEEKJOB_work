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
public class MakeClass1 {

    //フィールド
    String a = "";
    int b = 0;

    //メッセージを入れるメソッド
    void insertion(String a, int b) {
        this.a = a;
        this.b = b;
    }

    //メッセージを表示するメソッド
    void display() {
        System.out.print(a);
        System.out.print(b);
    }
}
