/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ryo
 */
public class Date3 {

    public static void main(String[] args) {
        //Dateクラスのインスタンス生成（2016年11月4日　10時0分0秒）
        Date d = new Date(1478221200000L);
        System.out.println(d);

        //指定された形式にフォーマット
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
    }

}
