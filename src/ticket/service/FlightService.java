package ticket.service;

import ticket.model.dto.FlightDto;
import ticket.model.entity.Flight;
import ticket.repository.FlightDao;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FlightService {
    FlightDao flightDao = new FlightDao();

    public Integer addNewFlight(FlightDto flightDto) throws Exception {
        Flight flight = null;
        if (Objects.nonNull(flightDto)) {
            flight = new Flight();
            flight.setFlightId(flightDto.getFlightId());
            flight.setFlightDate(flightDto.getFlightDate());
            flight.setSourceCity(flightDto.getSourceCity());
            flight.setDestinationCity(flightDto.getDestinationCity());
        }
        if (Objects.nonNull(flight)) {
            flightDao.create(flight);
            return flight.getFlightId();
        }
        throw new Exception(BizException.flightException);
    }

    @Transactional
    public void deleteFlightById(Integer flightId) throws Exception {
        Flight flight = findFlightById(flightId);
        if (Objects.nonNull(flight)) {
            flightDao.delete(flight);
        } else {
            throw new Exception(BizException.flightIdException);
        }
    }

    public void showFlightById(Integer flightId) throws Exception {
        Flight flight = flightDao.findFlightById(flightId);
        if (Objects.nonNull(flight)) {
            System.out.println(flight.toString());
        } else {
            throw new Exception(BizException.flightException);
        }
    }

    public void updateFlight(FlightDto flightDto) throws Exception {
        if (Objects.nonNull(flightDto)) {
            Flight flight = flightDao.findFlightById(flightDto.getFlightId());
            if (Objects.nonNull(flight)) {
                if (Objects.nonNull(flightDto.getSourceCity())) {
                    flight.setSourceCity(flightDto.getSourceCity());
                }
                if (Objects.nonNull(flightDto.getDestinationCity())) {
                    flight.setDestinationCity(flightDto.getDestinationCity());
                }
                if (Objects.nonNull(flightDto.getFlightDate())) {
                    flight.setFlightDate(flightDto.getFlightDate());
                }
                flightDao.update(flight);
            } else {
                throw new Exception(BizException.flightException);
            }
        }
    }

    public List<Flight> findAllFlights() throws Exception {
        if (Objects.nonNull(flightDao.selectAll()))
            return flightDao.selectAll();
        throw new Exception(BizException.flightListException);
    }

    public Flight findFlightById(Integer flightId) throws IOException {
        return flightDao.findFlightById(flightId);
    }

    public List<Flight> findFlightBySearch(FlightDto flightDto) throws Exception {
        return flightDao.findFlightBySearch(flightDto);
    }

    public int preparedFlightId() {
        return PreparedIdService.prepareId(100,1000);
    }
}
