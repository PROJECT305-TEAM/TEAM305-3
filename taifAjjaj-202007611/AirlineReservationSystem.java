package taifAjjaj-202007611;

// taif adnan 202007611 sec02 // LastEdit FOR(RESERVATION SERVICE)
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Data Layer
class Reservation {
private String reservationId;
private String flightDetails;
public Reservation(String reservationId, String flightDetails) {
this.reservationId = reservationId;
this.flightDetails = flightDetails; }
// Getters and setters
public String getReservationId() {
        return reservationId;
    }
public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
public String getFlightDetails() {
        return flightDetails;
    }
public void setFlightDetails(String flightDetails) {
        this.flightDetails = flightDetails;
    }}
// Business Layer
class ReservationService {
private List<Reservation> reservations;
public ReservationService() {
        this.reservations = new ArrayList<>();
    }
 // Create a new reservation
public Reservation createReservation(String reservationId, String flightDetails) {
Reservation reservation = new Reservation(reservationId, flightDetails);
reservations.add(reservation);
return reservation; }
// Modify an existing reservation
public boolean modifyReservation(String reservationId, String newFlightDetails) {
for (Reservation reservation : reservations) {
if (reservation.getReservationId().equals(reservationId)) {
reservation.setFlightDetails(newFlightDetails);
 return true;
 } }
return false; // Reservation not found
}
// Cancel a reservation
public boolean cancelReservation(String reservationId) {
 return reservations.removeIf(reservation -> reservation.getReservationId().equals(reservationId)); }
//get
public Reservation getReservation(String reservationId ){
for (Reservation reservation : reservations) {
 if (reservation.getReservationId().equals(reservationId)) {
return reservation; } }
return null; // Reservation not found
}
}


// Presentation Layer
public class AirlineReservationSystem {
public static void main(String[] args) {
ReservationService reservationService = new ReservationService();
 Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("1. Create reservation");
System.out.println("2. Modify reservation");
System.out.println("3. Cancel reservation");
System.out.println("4. Exit");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (choice) {
case 1:
// Create reservation
System.out.println("Enter reservation ID:");
String reservationId = scanner.nextLine();
System.out.println("Enter flight details:");
String flightDetails = scanner.nextLine();
Reservation reservation = reservationService.createReservation(reservationId, flightDetails);
System.out.println("Reservation created: " + reservation.getReservationId());
 break;

 case 2:
// Modify reservation
System.out.println("Enter reservation ID:");
reservationId = scanner.nextLine();
System.out.println("Enter new flight details:");
String newFlightDetails = scanner.nextLine(); // Declare the variable here
boolean isModified = reservationService.modifyReservation(reservationId, newFlightDetails);
if (isModified) {
 System.out.println("Reservation modified."); } else {
System.out.println("Reservation not found."); }
break;

case 3:
// Cancel reservation
 System.out.println("Enter reservation ID to cancel:");
 reservationId = scanner.nextLine();
boolean isCancelled = reservationService.cancelReservation(reservationId);
 if (isCancelled) { System.out.println("Reservation cancelled."); } else {
 System.out.println("Reservation not found."); }
break;

case 4:
// Exit
System.out.println("Exiting...");
System.exit(0);
break;
default:
System.out.println("Invalid choice. Please try again."); }
}
}
}


