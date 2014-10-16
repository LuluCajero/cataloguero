package com.iteso.sweng;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloWorldMessageServletTest {


    @Test
    public void shouldSendMessageToHelloPage() throws ServletException, IOException {
        HelloWorldMessageServlet servlet = new HelloWorldMessageServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);


        when(request.getRequestDispatcher("/hello.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("message", " Edit Perfil");

        verify(requestDispatcher).forward(request, response);


        String Usname= request.getParameter ("User_Name");
        String name= request.getParameter("Name");
        String PasW= request.getParameter("PassWord");
        String lastName= request.getParameter("LastName");
        String tel= request.getParameter("Phone");
        String email = request.getParameter("Email");
        String Addresss = request.getParameter("Address");

        when(request.getParameter ("User_Name")).thenReturn(Usname);
        when(request.getParameter ("Name")).thenReturn(name);
        when(request.getParameter ("PassWord")).thenReturn(PasW);
        when(request.getParameter ("LastName")).thenReturn(lastName);
        when(request.getParameter ("Phone")).thenReturn(tel);
        when(request.getParameter ("Email")).thenReturn(email);
        when(request.getParameter ("Address")).thenReturn(Addresss);




       verify(response).setContentType("text/html");
        PrintWriter out = response.getWriter();
        when (response.getWriter()).thenReturn(out);













    }
}
