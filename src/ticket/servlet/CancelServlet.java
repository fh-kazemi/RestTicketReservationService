package ticket.servlet;

import ticket.service.TicketService;
import ticket.service.BizException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class CancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/customerPanel.html").include(request, response);

        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        if (Objects.nonNull(ticketId)) {
            TicketService ticketService = new TicketService();
            try {
                ticketService.deleteTicketById(ticketId);
                writer.println("You are canceled successfully a ticket. Ticket ID: "
                        + ticketId);
            } catch (Exception e) {
                writer.println(e.getMessage());
            }
        }else
            writer.println(BizException.ticketIdEmptyException);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
