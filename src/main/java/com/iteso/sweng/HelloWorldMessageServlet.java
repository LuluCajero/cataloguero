package com.iteso.sweng;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerResource_de;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;




@WebServlet(urlPatterns = {"/hello.html"})
public class HelloWorldMessageServlet extends HttpServlet {


    public String url = "jdbc:odbc:DSF_Cataloguero";
    public String DBname = "Catalaguero";
    public String Driver = "sun.jdbc.obcd.JdbcOdbcDriver";


    public void ConexionBD (){
        public connection conn = null;

        try {
            Class.forName(Driver).newInstance();
            conn = DriverManager.getConnection(url.toString() + DBname);

        }
        catch (SQLServerException qE){

            response.getWriter().prinln(qE.getMessage + " fail");
        }
    }

    public void Modificar (String UN,String Na,String pa,String ln,int tel, String Em, String Addr){

        String StrQuery = "update ADMINISTRADOR set Name= '"+ Na +"', set Lastname = '" +ln +"', set Password = '" +pa+"', set phone = '"+tel+ "', set Email = '" +Em+ "', set Address = '" + Adrr+ "' where User_Name = '"+ Usname + "'" ;
        statement st1 = conn.createStatement();
        resultSet rs = st1.executeQuery(StrQuery);

        String StrQuery2 = "delete from ADMINISTRADOR where Name= '"+ Na  + "'" ;
        statement st2 = conn.createStatement();
        resultSet rs = st2.executeQuery(StrQuery);


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello.jsp");
        request.setAttribute("message", " Edit Perfil");
        requestDispatcher.forward(request, response);/**/

        String Usname= requestDispatcher.getParameter ("User_Name");
        String name= requestDispatcher.getParameter("Name");
        String PasW= requestDispatcher.getParameter("PassWord");
        String lastName= requestDispatcher.getParameter("LastName");
        int tel= requestDispatcher.getParameter("Phone");
        String email = requestDispatcher.getParameter("Email");
        String Addresss = requestDispatcher.getParameter("Address");

        ConexionBD();
        Modificar(Usname,name,PasW,lastName,tel,email,Addresss);

        String StrQuery = "SELECT * FROM ADMINISTRADOR WHERE User_Name = "+ Usname;
        statement st = conn.createStatement();
        resultSet rs = st.executeQuery(StrQuery);

        String Msg= "Guardados exitosamente";



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<font size= '6' color = black>"+ Msg+" </font>" );





















    }
}
