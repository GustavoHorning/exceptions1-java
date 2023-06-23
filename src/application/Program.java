package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(),ft);
        System.out.print("Check-out date (dd/mm/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(),ft);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        }
        else {
            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println(reservation);

            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = LocalDate.parse(sc.next(),ft);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = LocalDate.parse(sc.next(),ft);


            if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates:");
            }
            else if (!checkOut.isAfter(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date!");
            }
            else {
                reservation.updateDates(checkIn,checkOut);
                System.out.println(reservation);
            }

        }






        sc.close();



    }
}
