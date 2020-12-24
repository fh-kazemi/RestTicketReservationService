package ticket.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ticket.model.dto.FlightDto;
import ticket.model.entity.Flight;
import ticket.service.BizException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FlightDao extends GenericDao<Flight, Integer> {
    private SessionFactory sessionFactory = DBConnection.getSessionFactory();

    public Flight findFlightById(Integer flightId) throws IOException {
        if (Objects.nonNull(flightId)) {
            Session session = sessionFactory.openSession();
            String queryString = "from Flight where flightId=:fId";
            Query query = session.createQuery(queryString);
            query.setParameter("fId", flightId);
            Flight flight = (Flight) query.uniqueResult();
            session.close();
            return flight;
        } else {
            throw new IOException(BizException.flightIdEmptyException);
        }

    }

    public List<Flight> findFlightBySearch(FlightDto flightDto) throws Exception {
        if (Objects.nonNull(flightDto)) {
            Session session = sessionFactory.openSession();
            String queryString;
            Query query = null;
            if (Objects.nonNull(flightDto.getFlightDate())) {
                queryString = "from Flight where flightDate=:fDate";
                query = session.createQuery(queryString);
                query.setParameter("fDate", flightDto.getFlightDate());
            }
            if (Objects.nonNull(flightDto.getSourceCity()) && Objects.nonNull(flightDto.getDestinationCity())) {
                queryString = "from Flight where sourceCity=:sCity and destinationCity=:dCity";
                query = session.createQuery(queryString);
                query.setParameter("sCity", flightDto.getSourceCity());
                query.setParameter("dCity", flightDto.getDestinationCity());
            }
            List<Flight> flightList = query.list();
            session.close();
            if (flightList.isEmpty())
                throw new Exception(BizException.flightListException);
            else
                return flightList;
        } else {
            throw new Exception(BizException.flightException);
        }
    }

    public void deleteById(Integer flightId) throws Exception {
        delete(findFlightById(flightId));
    }
}
