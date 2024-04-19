// taif adnan202007611  ||ReservationsMangement(cancel/modify/cancel)|| itse305-02
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {
// Business Layer
static class ReservationManager {  private ReservationRepository reservationRepository;
public ReservationManager(ReservationRepository reservationRepository) {
 this.reservationRepository = reservationRepository;}

public Reservation createReservation(String guestName, Date startDate, int duration) {
Reservation reservation = new Reservation(guestName, startDate, duration);
reservationRepository.saveReservation(reservation);
return reservation;
}
public void modifyReservation(Reservation reservation, Date newStartDate, int newDuration) {
reservation.setStartDate(newStartDate);
reservation.setDuration(newDuration);
reservationRepository.updateReservation(reservation);}

public void cancelReservation(int reservationId) {
    Reservation reservation = reservationRepository.findReservation(reservationId);
if (reservation != null) {reservationRepository.deleteReservation(reservation); }}
}

//////////////////////////////////////////////////////////////////////////////    

    // Data Layer
static class ReservationRepository {private List<Reservation> reservations;
public ReservationRepository() {this.reservations = new ArrayList<>();}
public void saveReservation(Reservation reservation) {reservations.add(reservation);}
public void updateReservation(Reservation reservation) {  
    // Code to update the reservation in the database or storage
}
public Reservation findReservation(int reservationId) {for (Reservation reservation : reservations) {
if (reservation.getId() == reservationId) {return reservation;}}
return null; }
public void deleteReservation(Reservation reservation) { reservations.remove(reservation);}
}

//////////////////////////////////////////////////////////////////////////////
    // Presentation Layer
static class ReservationUI {
private ReservationManager reservationManager;
private ReservationRepository reservationRepository;
public ReservationUI() {
this.reservationRepository = new ReservationRepository();
this.reservationManager = new ReservationManager(reservationRepository);}

public void displayUI() { // Code to display the reservation system user interface
}

public Reservation createReservation(String guestName, Date startDate, int duration) {
return reservationManager.createReservation(guestName, startDate, duration);}
public int readReservationId() {// Code to read the reservation ID from the user
 @SuppressWarnings("resource")
 Scanner scanner = new Scanner(System.in);
System.out.println("Enter the reservation ID: ");
 int reservationId = scanner.nextInt();
return reservationId; }
public void modifyReservation(Reservation reservation, Date newStartDate, int newDuration) {
 reservationManager.modifyReservation(reservation, newStartDate, newDuration);}
public void cancelReservation(int reservationId) { reservationManager.cancelReservation(reservationId);}
public void showReservationDetails(Reservation reservation) { // Code to display the reservation details to the user
}
}
///////////////////////////////////////////////////////////
    // Model Class
static class Reservation {
private static int nextId = 1;
private int id;
private String guestName;
private Date startDate;
private int duration;

public Reservation(String guestName, Date startDate, int duration) {
this.id = nextId++;
this.guestName = guestName;
this.startDate = startDate;
this.duration = duration; }

//set&get method:
public int getId() { return id; }
public String getGuestName() { return guestName;}
public void setGuestName(String guestName) { this.guestName = guestName;}
public Date getStartDate() {  return startDate;  }
public void setStartDate(Date startDate) { this.startDate = startDate;}
public int getDuration() { return duration;}
public void setDuration(int duration) {   this.duration = duration; }
}

// Main method
 public static void main(String[] args) {
ReservationUI reservationUI = new ReservationUI();
reservationUI.displayUI();
}
}