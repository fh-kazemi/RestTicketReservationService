package ticket.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String flightDate = request.getParameter("flightDate");

        if (isValidDate(flightDate)) {
            chain.doFilter(request, response);
        } else {
            writer.println("Date format is not valid");
            request.getRequestDispatcher("/customerPanel.html").include(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public boolean isValidDate(String date) {
        String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
