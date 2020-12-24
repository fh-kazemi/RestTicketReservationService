package ticket.rest;

import ticket.model.dto.TicketDto;
import ticket.model.entity.Ticket;
import ticket.service.TicketService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/tickets")
public class TicketRest {
    TicketService ticketService = new TicketService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket showTicket(@PathParam("id") int ticketId) throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticketId);
        return ticketService.findByTicketId(ticketDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> showAllTickets() {
        return ticketService.showAllTickets();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewTicket(TicketDto ticketDto) throws Exception {
        try {
            ticketService.addNewTicket(ticketDto);
            return Response.status(200).entity("Ticket add successfully").build();
        }catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{ticketId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("ticketId") int ticketId, TicketDto ticketDto) throws Exception {
        ticketDto.setTicketId(ticketId);
        try {
            ticketService.ticketUpdate(ticketDto);
            return Response.status(200).entity("ticket with code " + ticketId + "updated").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteTicket(@PathParam("id") int ticketId) throws Exception {
        try {
            ticketService.deleteTicketById(ticketId);
            return Response.status(200).entity("ticket deleted").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAllTickets() throws Exception {
        try {
            ticketService.deleteAllTickets();
            return Response.status(200).entity("all the tickets deleted").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
