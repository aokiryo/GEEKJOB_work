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
public class ArgumentReturn3 extends HttpServlet {

    //リストを生成し、指定されたIDを返すメソッド
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
        adress = null;

        data2.add(id);
        data2.add(birth);
        data2.add(adress);

        ArrayList<String> data3 = new ArrayList<String>();
        id = "BB-61";
        birth = "1942/8/27";
        adress = "NewTork";

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

    //要素を表示させるメソッド
    void display(ArrayList data, PrintWriter pw) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == null) {
                continue;
            }
            pw.print(data.get(i) + "<br>");
        }
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

            //表示制限回数の変数
            int limit = 2;

            //ID一覧
            String[] getdata = {"CV-3", "CV-11", "BB-61"};

            //要素の表示（表示制限回数まで）
            for (int i = 0; i < getdata.length; i++) {
                if (i < limit) {
                    display(setinfo(getdata[i]), out);
                    out.print("<br>");
                }
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
