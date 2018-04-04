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
public class Inheritance1 extends MakeClass1{
    
    //フィールドをクリアするメソッド（追加）
    void clea(){
        this.a = null;
        this.b = 0;
    }
    
}
