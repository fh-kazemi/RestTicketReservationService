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

public class FindFlightByDateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/customerPanel.html").include(request, response);

        String flightDate = request.getParameter("flightDate");
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightDate(flightDate);

        FlightService flightService = new FlightService();
        List<Flight> flightList = null;
        try {
            flightList = flightService.findFlightBySearch(flightDto);
            writer.println("Flight Date: " + flightDate + "</br>");
            flightList.stream().forEach(f -> writer.println(f.toString() + "</br>"));
        } catch (Exception e) {
            writer.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
