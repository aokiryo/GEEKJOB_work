/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ryo
 */
public class MySQL11_2 extends HttpServlet {
    
    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //パス
            final String result = "WEB-INF/jsp/MySQL11_4.jsp";

            //名前エンコード用
            request.setCharacterEncoding("UTF-8");

            //登録内容
            int updateID = Integer.parseInt(request.getParameter("updateID"));
            String updateN = request.getParameter("updateN");
            String updateT = request.getParameter("updateT");
            int updateA = Integer.parseInt(request.getParameter("updateA"));
            Date updateB = Date.valueOf(request.getParameter("updateB"));
            
            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //更新対象はHTMLのフォームから取得
            String updateText = "UPDATE profiles SET name ='" + updateN + "', tel ='" + updateT + "', age =" 
                    + updateA + ", birthday ='"+updateB+ "' WHERE profilesID =" + updateID;
            
            //挿入内容設定
            db_st = db_con.prepareStatement(updateText);

            //挿入
            db_st.executeUpdate();

            //全レコード取得
            db_st = db_con.prepareStatement("SELECT * FROM profiles");

            db_data = db_st.executeQuery();

            //beansのインスタンス生成(前課題の再利用)
            MySQL8_3 data = new MySQL8_3();

            db_data.next();
            for (int i = 1; i < db_data.getRow() + 1; i++) {
                
                ArrayList<String> record = new ArrayList<String>();
                
                record.add(String.valueOf(db_data.getInt("profilesID")));
                record.add(db_data.getString("name"));
                record.add(db_data.getString("tel"));
                record.add(String.valueOf(db_data.getInt("age")));
                record.add(String.valueOf(db_data.getString("birthday")));
                
                data.setDatas(record);
                
                    if(i < db_data.getRow() + 1){
                        db_data.next();
                    }
            }

            request.setAttribute("DATA", data);

            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("コネクタが見つかりません");
        } catch (InstantiationException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("コネクタを生成できませんでした");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("不正な接続です");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("データベースとの交信に失敗しました");
        } finally {
            try {
                //ファイルクローズ
                db_st.close();
                db_con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ファイルをクローズできませんでした");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
