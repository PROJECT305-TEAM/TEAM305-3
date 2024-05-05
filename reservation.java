// taif adnan 202007611 sec02
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reservation {
    private String reservationId;
    private String username;
    private String reservationDetails;

    public Reservation(String reservationId, String username, String reservationDetails) {
        this.reservationId = reservationId;
        this.username = username;
        this.reservationDetails = reservationDetails;
    }

    public String getReservationId() {
        return reservationId;


    }

    public String getUsername() {return username;  }

    public String getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(String reservationDetails) {
        this.reservationDetails = reservationDetails;
    }
}

class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    public void createReservation(String reservationId, String username, String reservationDetails) {
        Reservation reservation = new Reservation(reservationId, username, reservationDetails);
        reservations.add(reservation);
        System.out.println("Reservation created successfully!");
    }

    public void modifyReservation(String reservationId, String newReservationDetails) {
        Reservation reservation = findReservationById(reservationId);
        if (reservation != null) {
            reservation.setReservationDetails(newReservationDetails);
            System.out.println("Reservation modified successfully!");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = findReservationById(reservationId);
        if (reservation != null) {
            reservations.remove(reservation);
            System.out.println("Reservation canceled successfully!");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private Reservation findReservationById(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        return null;
    }
}

public class ReservationSystem {
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Reservation");
            System.out.println("2. Modify Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createReservation(scanner, reservationService);
                    break;
                case 2:
                    modifyReservation(scanner, reservationService);
                    break;
                case 3:
                    cancelReservation(scanner, reservationService);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createReservation(Scanner scanner, ReservationService reservationService) {
        System.out.println("Enter Reservation ID:");
        String reservationId = scanner.nextLine();

        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        System.out.println("Enter Reservation Details:");
        String reservationDetails = scanner.nextLine();

        reservationService.createReservation(reservationId, username, reservationDetails);
    }

    private static void modifyReservation(Scanner scanner, ReservationService reservationService) {
        System.out.println("Enter Reservation ID:");
        String reservationId = scanner.nextLine();

        System.out.println("Enter New Reservation Details:");
        String newReservationDetails = scanner.nextLine();

        reservationService.modifyReservation(reservationId, newReservationDetails);
    }

    private static void cancelReservation(Scanner scanner, ReservationService reservationService) {
        System.out.println("Enter Reservation ID:");
        String reservationId = scanner.nextLine();

        reservationService.cancelReservation(reservationId);
    }
}