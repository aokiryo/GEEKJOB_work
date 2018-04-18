/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.sql.*;

/**
 *
 * @author ryo
 */
public class MySQL2 {

    static Connection db_con = null;
    static PreparedStatement db_st = null;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //コネクタ作成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","ryo","bluerose");
            
            //仕様するSQL文設定
            db_st = db_con.prepareStatement("INSERT INTO profiles VALUES (?, ?, ?, ?, ?)");
            
            //登録するデータ設定
            db_st.setInt(1, 6);
            db_st.setString(2, "伊藤博文");
            db_st.setString(3, "123-456-7890");
            db_st.setInt(4, 40);
            
            Date sqlDate = Date.valueOf("1841-10-16");
            db_st.setDate(5, sqlDate);
            
            //登録
            db_st.executeUpdate();
            
            //ファイルクローズ
            db_st.close();
            db_con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
