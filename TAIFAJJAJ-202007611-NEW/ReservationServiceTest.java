// TAIF ADNAN 202007611 SEC02 (LastEdit ) // test for class[ ReservationService]
import org.junit.Test;
import static org.junit.Assert.*;
public class ReservationServiceTest {
// method for createReservation test  :
 @Test
 public void createReservation() {
 // Arrange
ReservationService reservationService = new ReservationService();
String reservationId = "123";
String flightDetails = "Flight XYZ";
Reservation reservation = reservationService.createReservation(reservationId, flightDetails);
assertNotNull(reservation);
assertEquals(reservationId, reservation.getReservationId());
assertEquals(flightDetails, reservation.getFlightDetails());


 }

// method for modifyReservation test  :
@Test
public void modifyReservation() {
// Arrange
ReservationService reservationService1 = new ReservationService();
String reservationId = "123";
String flightDetails = "Flight XYZ";
String newFlightDetails = "Flight ABC";
reservationService1.createReservation(reservationId, flightDetails);
boolean isModified = reservationService1.modifyReservation(reservationId, newFlightDetails);
assertTrue(isModified);
Reservation modifiedReservation = reservationService1.getReservation(reservationId);
assertNotNull(modifiedReservation);
assertEquals(newFlightDetails, modifiedReservation.getFlightDetails()); }



 }

