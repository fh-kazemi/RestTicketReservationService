package ticket.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ticket.model.dto.TicketDto;
import ticket.model.entity.Ticket;
import ticket.service.BizException;

import java.util.List;
import java.util.Objects;

public class TicketDao extends GenericDao<Ticket, Integer> {
    private SessionFactory sessionFactory = DBConnection.getSessionFactory();

    public void addTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketDto.getTicketId());
        ticket.setCustomer(ticketDto.getCustomer());
        ticket.setFlight(ticketDto.getFlight());
        create(ticket);
    }

    public void deleteById(Ticket ticket) throws Exception {
        if (Objects.nonNull(ticket))
            delete(ticket);
        else
            throw new Exception(BizException.ticketException);

    }

    public Ticket findByTicketId(TicketDto ticketDto) throws Exception {
        Session session = sessionFactory.openSession();
        String queryString = null;
        Query query = null;
        if (Objects.nonNull(ticketDto.getTicketId())) {
            queryString = "from Ticket where ticketId=:tId";
            query = session.createQuery(queryString);
            query.setParameter("tId", ticketDto.getTicketId());
        }
        if (Objects.nonNull(ticketDto.getId())) {
            queryString = "from Ticket where id=:tId";
            query = session.createQuery(queryString);
            query.setParameter("tId", ticketDto.getId());
        }
        Ticket ticket = (Ticket) query.uniqueResult();
        session.close();
        if (Objects.nonNull(ticket))
            return ticket;
        else
            throw new Exception(BizException.ticketIdException);
    }

    public void deleteAll() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "delete from Ticket";
        Query query = session.createQuery(queryString);
        List<Ticket> tickets = query.list();
        session.getTransaction().commit();
        session.close();
        if (Objects.nonNull(tickets))
            throw new Exception(BizException.ticketListException);
    }
}
