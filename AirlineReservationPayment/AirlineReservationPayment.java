
public class AirlineReservationPayment {
    private double amount;
    private boolean paymentStatus;
    private long passengerID;

    public AirlineReservationPayment(long passengerID,double amount) {
        this.passengerID=passengerID;
        this.amount = amount;
        this.paymentStatus = false;
    }


    //calculate payment amount with discounts and tax
    public double calculatePaymentAmount(double discountPercentage, double taxPercentage) {
        double discount = amount * (discountPercentage / 100);
        double tax = amount * (taxPercentage / 100);

        return amount - discount + tax;
    }


        //make payment
    public boolean processPayment(double amountPaid) {
        if (amountPaid >= amount) {
            amount -= amountPaid;
            paymentStatus = true;
            System.out.println("Payment has been completed successfully.");
            return true;
        } else {
            System.out.println("Insufficient amount. Please pay the full amount of: "+getAmount());
            return false;
        }

    }
    public long getPassengerID(){

        return passengerID;
    }
    public boolean isPaymentCompleted() {
        return paymentStatus;
    }

    public double getAmount() {
        return amount;
    }


    public static void main(String[] args) {
        // set the passengerID and amount the reservation
        AirlineReservationPayment payment = new AirlineReservationPayment(476848681,300.00);
        // Customer pays the amount of reservation
        payment.processPayment(10);


        // check and display payment status
        if (payment.isPaymentCompleted()) {
            System.out.println("thank you!! Your reservation has been confirmed . ");
        } else {
            System.out.println("Unfortunately Payment failed. Please try again.");
        }
    }
}

