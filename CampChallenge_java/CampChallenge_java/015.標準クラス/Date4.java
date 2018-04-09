/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author ryo
 */
public class Date4 {

    public static void main(String[] args) {
        //Calendarクラスのインスタンス生成
        Calendar c1 = Calendar.getInstance();
        c1.set(2015, 00, 01, 00, 00, 00);

        Calendar c2 = Calendar.getInstance();
        c2.set(2015, 11, 31, 23, 59, 59);

        //Dateクラスのインスタンス生成
        Date d1 = new Date();
        Date d2 = new Date();

        //指定されたCalendarの日時を格納する
        d1 = c1.getTime();
        d2 = c2.getTime();

        //差を表示
        System.out.print(d2.getTime() - d1.getTime());
    }

}
