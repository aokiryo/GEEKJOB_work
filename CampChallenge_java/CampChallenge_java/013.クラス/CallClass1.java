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
public class CallClass1 {

    public static void main(String[] args) {

        //MakeClassのインスタンス生成
        MakeClass1 test = new MakeClass1();

        //挿入したいメッセージ
        String x = "課題全部終わるまで帰れま";
        int y = 10;

        //メッセージを入れるメソッドと表示するメソッド実行
        test.insertion(x, y);
        test.display();
    }
}
