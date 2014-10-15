package com.iteso.sweng;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

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

        when(requestDispatcher.getParameter ("User_Name")).thenReturn(Usname);
        when(requestDispatcher.getParameter ("Name")).thenReturn(name);
        when(requestDispatcher.getParameter ("PassWord")).thenReturn(PasW);
        when(requestDispatcher.getParameter ("LastName")).thenReturn(lastname);
        when(requestDispatcher.getParameter ("Phone")).thenReturn(tel);
        when(requestDispatcher.getParameter ("Email")).thenReturn(email);
        when(requestDispatcher.getParameter ("Address")).thenReturn(Addresss);

        verify(ConexionBD).contains(conn);
        verify(Modificar).contains(StrQuery2);


       verify(response).setContentType("text/html");

        when (response.getWriter()).thenReturn(out);
        assertEquals("<font size= '6' color = black>"+ Msg+" </font>" , out.println);













    }
}
