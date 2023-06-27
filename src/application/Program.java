package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            //Reservation data:
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), ft);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), ft);
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            //Reservation data update:
            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), ft);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), ft);

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date format!");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }



    }
}
