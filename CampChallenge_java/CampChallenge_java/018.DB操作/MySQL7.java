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
public class MySQL7 {

    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //データ更新
            db_st = db_con.prepareStatement("UPDATE profiles SET name = ?, tel = ?, age = ?, birthday= ?  WHERE profilesID = 1");

            //登録するデータ設定
            db_st.setString(1, "大隈重信");
            db_st.setString(2, "098-765-4321");
            db_st.setInt(3, 38);

            Date sqlDate = Date.valueOf("1838-03-11");
            db_st.setDate(4, sqlDate);
            
            //実行
            db_st.executeUpdate();
            
            //データ取得
            db_st = db_con.prepareStatement("SELECT * FROM profiles");

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
