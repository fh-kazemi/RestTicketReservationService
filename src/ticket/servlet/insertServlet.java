package ticket.servlet;

import ticket.model.dto.FlightDto;
import ticket.service.BizException;
import ticket.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "insertServlet")
public class insertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/adminPanel.html").include(request, response);

        String sourceCity = request.getParameter("sourceCity");
        String destinationCity = request.getParameter("destinationCity");
        String flightDate = request.getParameter("flightDate");

        if(Objects.nonNull(sourceCity) &&
                Objects.nonNull(destinationCity) &&
                Objects.nonNull(flightDate)) {
            FlightService flightService = new FlightService();
            FlightDto flightDto = new FlightDto();
            flightDto.setFlightId(flightService.preparedFlightId());
            flightDto.setSourceCity(sourceCity);
            flightDto.setDestinationCity(destinationCity);
            flightDto.setFlightDate(flightDate);
            Integer flightId;
            try {
                flightId = flightService.addNewFlight(flightDto);
                writer.println("You are inserted successfully a flight. Flight ID: " +
                        flightId);
            } catch (Exception e) {
                writer.println(e.getMessage());
            }
        }else
            writer.println(BizException.flightException);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
