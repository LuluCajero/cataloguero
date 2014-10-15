


<%@ page import ="java.sql.*" %>

<%
String user=request.getParameter("user");
session.putValue("user",user);
String current=request.getParameter("current");
String password=request.getParameter("password");
String confirmation=request.getParameter("confirmation");

Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from users where user='"+user+"'");
if(rs.next())
{
    if(!rs.getString(2).equals(password) )
    {
         out.println("Nombre de usuario o contraseña incorrecta");

    }
 if(password.length()<4 || password.length()>20){
          out.println("la nueva contraseña debe ser de al menos 4 caracteres y máximo 20");
         }
    else if(password!=confirmation){
            out.println("las contraseñas no coniciden");
     }
    else
    {
          out.println("Password actualizado");
          st.executeUpdate("update users set pass='"+password+"' where user='"+user+"'");
    }
}
else{
         out.println("No se encontró en la base de datos");
}
%>