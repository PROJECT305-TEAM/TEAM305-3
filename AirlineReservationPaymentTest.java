import org.junit.Test;

import static org.junit.Assert.*;

public class AirlineReservationPaymentTest {

    @Test
    public void processPayment() {


        AirlineReservationPayment pay= new AirlineReservationPayment(54654568,354.3);
        assertEquals(true,pay.processPayment(450));

    }

    @Test
    public void calculatePaymentAmount() {


        AirlineReservationPayment pay2= new AirlineReservationPayment(54654568,350);
        assertEquals(210,350,pay2.calculatePaymentAmount(50,10));

    }
}


