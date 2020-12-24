package ticket;

import ticket.model.dto.FlightDto;
import ticket.model.entity.Customer;
import ticket.model.entity.Flight;
import ticket.model.entity.Ticket;
import ticket.repository.TicketDao;
import ticket.service.CustomerService;
import ticket.service.FlightService;
import ticket.service.TicketService;

public class Main {
    public static void main(String[] args) {
        //Flight flight = new Flight();

        //flight.setFlightId(222);
        /*flight.setSourceCity("yazd");
        flight.setDestinationCity("zanjan");
        flight.setFlightDate("1399/10/09");*/


       /* FlightService flightService = new FlightService();
        System.out.println(flightService.addNewFlight(flight));*/
        //System.out.println(flightService.deleteFlightById(216));
        //System.out.println(flightService.showFlightById(579));
        //System.out.println(flightService.updateFlight(flight));
        //System.out.println(flightService.findFlightById(222));
        //System.out.println(flightService.findFlightByDate("1399/09/20"));

        /*FlightDto flightDto = new FlightDto();
        flightDto.setSourceCity("yazd");
        flightDto.setDestinationCity("semnan");
        System.out.println(flightService.findFlightBySourceAndDestination(flightDto));*/
        //////////////////////////////////////

        /*Customer customer = new Customer();
        customer.setCustomerName("sima");

        CustomerService customerService = new CustomerService();
        System.out.println(customerService.addNewCustomer(customer));
        //System.out.println(customerService.findCustomerById(43178));


        Ticket ticket = new Ticket();
        ticket.setTicketId(4123);
        ticket.setCustomer(customer);
        ticket.setFlight(flight);

        TicketService ticketService = new TicketService();*/
        //System.out.println(ticketService.addNewTicket(ticket));
        //System.out.println(ticketService.showTicketById(35190));
        //System.out.println(ticketService.deleteTicketById(35190));
        //System.out.println(ticketService.ticketUpdate(15,ticket));

        /*TicketDao ticketDao = new TicketDao();
        System.out.println(ticketDao.findById(8).toString());*/


    }
}
