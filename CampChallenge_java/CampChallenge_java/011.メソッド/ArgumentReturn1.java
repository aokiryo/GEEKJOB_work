/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryo
 */
public class ArgumentReturn1 extends HttpServlet {

    //ユーザー定義メソッド作成
    ArrayList setinfo(String set) {

        //返す用のデータ
        ArrayList<String> setdata = new ArrayList<String>();

        ArrayList<String> data1 = new ArrayList<String>();
        String id = "CV-3";
        String birth = "1925/4/7";
        String adress = "NewJersey";

        data1.add(id);
        data1.add(birth);
        data1.add(adress);

        ArrayList<String> data2 = new ArrayList<String>();
        id = "CV-11";
        birth = "1943/4/26";
        adress = "Virginia";

        data2.add(id);
        data2.add(birth);
        data2.add(adress);

        ArrayList<String> data3 = new ArrayList<String>();
        id = "BB-61";
        birth = "1942/8/27";
        adress = "NewYork";

        data3.add(id);
        data3.add(birth);
        data3.add(adress);

        //for文で回すためのリスト
        ArrayList[] alldata = {data1, data2, data3};

        //IDが一致するリストを探す
        for (int i = 0; i < alldata.length; i++) {
            if (alldata[i].contains(set)) {
                setdata = alldata[i];
            }
        }

        return setdata;
    }

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

            //取得するID
            String getdata = "BB-61";

            //ID以外の要素の表示
            for (int i = 1; i < setinfo(getdata).size(); i++) {
                out.print(setinfo(getdata).get(i) + "<br>");
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
