package ticket.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FlightIDFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int flightId = Integer.parseInt(request.getParameter("flightId"));

        if (String.valueOf(flightId).length() == 3) {
            chain.doFilter(request, response);
        } else {
            writer.println("flight number is not valid");
            request.getRequestDispatcher("/customerPanel.html").include(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
