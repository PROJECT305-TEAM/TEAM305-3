// taif Adnan 202007611 sec02


import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReservationTest12 {
    private Reservation reservation;
    private final String reservationId = "RES123";
    private final String flightDetails = "Flight A123, Seat 12C";


    @Before
    public void setUp() { reservation = new Reservation(reservationId, flightDetails); }

    @Test
    public void getReservationId() {
        Assert.assertEquals("Failed to get correct reservation ID", reservationId, reservation.getReservationId());
    }

    @Test
    public void setReservationId() {
        String newReservationId = "RES456";
        reservation.setReservationId(newReservationId);
        Assert.assertEquals("Failed to set new reservation ID", newReservationId, reservation.getReservationId());



    }

    @Test
    public void getFlightDetails() {

        Assert.assertEquals("Failed to get correct flight details", flightDetails, reservation.getFlightDetails());


    }

    @Test
    public void setFlightDetails() {
        String newFlightDetails = "Flight B456, Seat 34F";
        reservation.setFlightDetails(newFlightDetails);
        Assert.assertEquals("Failed to set new flight details", newFlightDetails, reservation.getFlightDetails());
    }
}
