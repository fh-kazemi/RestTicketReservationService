package ticket.model.dto;

import ticket.model.entity.Customer;
import ticket.model.entity.Flight;

public class TicketDto {
    private Integer id;
    private int ticketId;
    private Customer customer;
    private Flight flight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", customer=" + customer +
                ", flight=" + flight +
                '}';
    }
}
