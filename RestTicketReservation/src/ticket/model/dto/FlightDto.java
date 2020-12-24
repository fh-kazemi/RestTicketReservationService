package ticket.model.dto;

public class FlightDto {
    private Integer flightId;
    private String sourceCity;
    private String destinationCity;
    private String flightDate;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "flightId=" + flightId +
                ", sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", flightDate='" + flightDate + '\'' +
                '}';
    }
}
