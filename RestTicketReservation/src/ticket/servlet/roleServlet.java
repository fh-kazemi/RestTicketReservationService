package ticket.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "roleServlet")
public class roleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String role = request.getParameter("rol");
        switch (role) {
            case "admin":
                request.getRequestDispatcher("/login.html").forward(request, response);
                break;
            case "customer":
                request.getRequestDispatcher("/customerPanel.html").forward(request, response);
                break;
            default:
                writer.println("Select a role \n");
                request.getRequestDispatcher("/index.jsp").include(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
