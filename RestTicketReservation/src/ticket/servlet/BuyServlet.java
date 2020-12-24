package ticket.servlet;

import ticket.model.dto.TicketDto;
import ticket.model.entity.Customer;
import ticket.model.entity.Flight;
import ticket.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/customerPanel.html").include(request, response);

        int flightId = Integer.parseInt(request.getParameter("flightId"));
        String customerName = request.getParameter("customerName");

        if (Objects.nonNull(flightId)) {
            FlightService flightService = new FlightService();
            Flight flight = flightService.findFlightById(flightId);
            if(Objects.nonNull(flight)) {
                System.out.println(flight.toString());
                if (Objects.nonNull(customerName)) {
                    CustomerService customerService = new CustomerService();
                    Customer customer = new Customer();
                    customer.setCustomerName(customerName);
                    customer.setCustomerId(customerService.preparedCustomerId());

                    TicketService ticketService = new TicketService();
                    TicketDto ticketDto = new TicketDto();
                    ticketDto.setTicketId(ticketService.preparedTicketId());
                    ticketDto.setCustomer(customer);
                    ticketDto.setFlight(flight);
                    try {
                        ticketService.addNewTicket(ticketDto);
                        writer.println(ticketService.findByTicketId(ticketDto).toString() + "</br></br>");
                        writer.println("You are bought successfully a ticket. Ticket ID: " +
                                ticketDto.getTicketId());
                    } catch (Exception e) {
                        writer.println(e.getMessage());
                    }
                } else {
                    writer.println(BizException.customerException);
                }
            }else {
                writer.println(BizException.flightException);
            }
        }else{
            writer.println(BizException.flightIdEmptyException);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
