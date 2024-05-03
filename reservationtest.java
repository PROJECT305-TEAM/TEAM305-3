//taif adnan 202007611

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Reservationtest {

    @Test
    void testCreateReservation() {
        // Arrange
        ReservationService reservationService = new ReservationService();

        // Act
        reservationService.createReservation("1", "John", "Reservation details");

        // Assert
        assertEquals(1, reservationService.getReservations().size());
        assertEquals("1", reservationService.getReservations().get(0).getReservationId());
        assertEquals("John", reservationService.getReservations().get(0).getUsername());
        assertEquals("Reservation details", reservationService.getReservations().get(0).getReservationDetails());
    }

    @Test
    void testModifyReservation() {
        // Arrange
        ReservationService reservationService = new ReservationService();
        reservationService.createReservation("1", "John", "Reservation details");

        // Act
        reservationService.modifyReservation("1", "New reservation details");

        // Assert
        assertEquals("New reservation details", reservationService.getReservations().get(0).getReservationDetails());
    }

    @Test
    void testCancelReservation() {
        // Arrange
        ReservationService reservationService = new ReservationService();
        reservationService.createReservation("1", "John", "Reservation details");

        // Act
        reservationService.cancelReservation("1");

        // Assert
        assertEquals(0, reservationService.getReservations().size());
    }
}

