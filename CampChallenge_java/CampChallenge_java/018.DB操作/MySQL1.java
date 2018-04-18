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
public class MySQL1 {

    static Connection db_con = null;
    static PreparedStatement db_st = null;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db");

            Statement db_st = db_con.createStatement();

            db_st.close();
            db_con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
