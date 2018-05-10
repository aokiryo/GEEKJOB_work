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
public class MySQL4 {

    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //データ取得
            db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = 1");

            //実行
            db_data = db_st.executeQuery();

            //取得したデータを表示
            while(db_data.next()){
                System.out.println(db_data.getString("profilesID") + " " + db_data.getString("name") + " "
                    + db_data.getString("tel") + " " + db_data.getString("age") + " " + db_data.getString("birthday"));
            }
            

            db_st.close();
            db_con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
