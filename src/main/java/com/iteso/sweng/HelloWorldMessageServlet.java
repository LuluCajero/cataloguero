package com.iteso.sweng;
import com.intellij.execution.testframework.Printer;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;




@WebServlet(urlPatterns = {"/hello.html"})
public class HelloWorldMessageServlet extends HttpServlet {

    public String url = "jdbc:microsoft:sqlserver://";
    public String DBname = "Catalaguero";
    public String Driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    public String serverName= "localhost";
    public String portNumber= "7108";
    public String selectMethod = "cursor";

    java.sql.Connection  con = null;

    String getConnectionUrl(){
        return url+serverName+":"+portNumber+";databaseName="+DBname+";selectMethod="+selectMethod+";";
    }
       public  java.sql.Connection getConnection(){
            try{
                Class.forName(Driver);
                con = java.sql.DriverManager.getConnection(getConnectionUrl());
                if(con!=null) System.out.println("Connection Successful!");
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("Error Trace in getConnection() : " + e.getMessage());
            }
            return con;
        }


    public void Modificar (String UN,String Na,String pa,String ln,String tel, String Em, String Addr){

        try {
            String StrQuery = "update ADMINISTRADOR set Name= '"+ Na +"', set Lastname = '" +ln +"', set Password = '" +pa+"', set phone = '"+tel+ "', set Email = '" +Em+ "', set Address = '" + Addr+ "' where User_Name = '"+ UN + "'" ;
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery(StrQuery);


            String StrQuery2 = "delete from ADMINISTRADOR where Name= '"+ Na  + "'" ;
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(StrQuery2);
        }catch (SQLException sE){
            System.out.println(sE.getLocalizedMessage());
        }



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello.jsp");

        request.setAttribute("message", "Hello World");
        requestDispatcher.forward(request, response);/**/
		int i= 5;

        request.setAttribute("message", " Edit Perfil");
        requestDispatcher.forward(request, response);/**/

        String Usname= request.getParameter ("User_Name");
        String name= request.getParameter("Name");
        String PasW= request.getParameter("PassWord");
        String lastName= request.getParameter("LastName");
        String tel= request.getParameter("Phone");
        String email = request.getParameter("Email");
        String Addresss = request.getParameter("Address");

        getConnection();
        Modificar(Usname,name,PasW,lastName,tel,email,Addresss);

        try {
            String StrQuery = "SELECT * FROM ADMINISTRADOR WHERE User_Name = "+ Usname;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(StrQuery);


        }catch (SQLException sE){
            System.out.println("Fail");
        }


        String Msg= "Guardados exitosamente";


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<font size= '6' color = black>" + Msg + " </font>");


    }
}
