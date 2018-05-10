package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            //U.D.Beansのインスタンス生成
            UserDataBeans data = new UserDataBeans();
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");

            //U.D.Beansに格納
            data.setName(name);
            data.setYear(year);
            data.setMonth(month);
            data.setDay(day);
            data.setType(type);
            data.setTell(tell);
            data.setComment(comment);
            System.out.println("Session updated!!");
            
            //未入力の項目があればその情報も格納して渡す
            if(data.getName().equals("")){
                data.setError("名前");
            }
            
            if(data.getYear().equals("") || data.getMonth().equals("") || data.getDay().equals("")){
                data.setError("生年月日");
            }
            
            if(data.getType() == null){
                data.setError("種別");
            }

            if(data.getTell().equals("")){
                data.setError("電話番号");
            }
            
            if(data.getComment().equals("")){
                data.setError("自己紹介");
            }
            
            //クラスをまたいで利用するためセッションに保存する
            session.setAttribute("name", data.getName());
            session.setAttribute("year", data.getYear());
            session.setAttribute("month", data.getMonth());
            session.setAttribute("day", data.getDay());
            session.setAttribute("type", data.getType());
            session.setAttribute("tell", data.getTell());
            session.setAttribute("comment", data.getComment());
            session.setAttribute("DATA", data);
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
            
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
