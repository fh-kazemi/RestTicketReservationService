package ticket.service;

import ticket.model.dto.TicketDto;
import ticket.model.entity.Ticket;
import ticket.repository.TicketDao;

import java.util.List;
import java.util.Objects;

public class TicketService {
    private TicketDao ticketDao = new TicketDao();

    public void addNewTicket(TicketDto ticketDto) throws Exception {
        if (Objects.nonNull(ticketDto)) {
            ticketDao.addTicket(ticketDto);
        }
        else
            throw new Exception(BizException.ticketException);
    }

    public void deleteTicketById(int ticketId) throws Exception {
        if (Objects.nonNull(ticketId)) {
            TicketDto ticketDto = new TicketDto();
            ticketDto.setTicketId(ticketId);
            Ticket ticket = ticketDao.findByTicketId(ticketDto);
            if (Objects.nonNull(ticket))
                ticketDao.deleteById(ticket);
            else
                throw new Exception(BizException.ticketException);
        } else
            throw new Exception(BizException.ticketIdException);
    }

    public Ticket findByTicketId(TicketDto ticketDto) throws Exception {
        if (Objects.nonNull(ticketDto))
            return ticketDao.findByTicketId(ticketDto);
        else
            throw new Exception(BizException.ticketIdException);
    }

    public List<Ticket> showAllTickets() {
        return ticketDao.selectAll();
    }

    public void ticketUpdate(TicketDto ticketDto) throws Exception {
        if (Objects.nonNull(ticketDto.getTicketId())) {
            Ticket ticket = ticketDao.findByTicketId(ticketDto);
            if (Objects.nonNull(ticket)) {
                if (Objects.nonNull(ticketDto.getFlight()))
                    ticket.setFlight(ticketDto.getFlight());
                if (Objects.nonNull(ticketDto.getCustomer()))
                    ticket.setCustomer(ticketDto.getCustomer());
                ticketDao.update(ticket);
            } else
                throw new Exception(BizException.ticketUpdateException);
        } else
            throw new Exception(BizException.ticketIdException);
    }

    public void deleteAllTickets() throws Exception {
        ticketDao.deleteAll();
    }

    public int preparedTicketId() {
        return PreparedIdService.prepareId(0, 10000);
    }
}
