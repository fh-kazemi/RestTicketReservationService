package ticket.servlet;

import ticket.model.dto.FlightDto;
import ticket.model.entity.Flight;
import ticket.service.BizException;
import ticket.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class FindFlightBySrDsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/customerPanel.html").include(request, response);

        String sourceCity = request.getParameter("sourceCity");
        String destinationCity = request.getParameter("destinationCity");

        FlightDto flightDto = new FlightDto();
        flightDto.setSourceCity(sourceCity);
        flightDto.setDestinationCity(destinationCity);

        FlightService flightService = new FlightService();
        List<Flight> flightList = null;
        try {
            flightList = flightService.findFlightBySearch(flightDto);
            writer.println("Source City: " + sourceCity +
                    "</br>Destination City: " + destinationCity+"</br></br>");
            flightList.stream().forEach(f -> writer.println(f.toString()+"</br>"));
        } catch (Exception e) {
            writer.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
