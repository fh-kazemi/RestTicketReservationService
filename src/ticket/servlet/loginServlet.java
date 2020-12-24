package ticket.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ServletConfig servletConfig = getServletConfig();
        String validUsername = servletConfig.getInitParameter("username");
        String validPassword = servletConfig.getInitParameter("password");


        if (password.equals(validPassword)  && username.equals(validUsername) ) {
            request.getRequestDispatcher("adminPanel.html").include(request, response);
        } else {
            request.getRequestDispatcher("login.html").include(request, response);
            writer.println("Invalid username or password!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
