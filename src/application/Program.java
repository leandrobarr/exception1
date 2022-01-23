package application;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        System.out.print("Quarto número: ");
        int numero = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        Reservation reservation = null;
            if (!checkout.after(checkin)) {
                System.out.println("Erro: a data de checkout deve ser posterior a data de checkin");
            } else {
                reservation = new Reservation(numero, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.print("Insira a data para atualizar a reserva: ");

            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkout = sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras ");
            }
            else if (!checkout.after(checkin)){
                System.out.println("Erro na reserva: a data de check-out deve ser posterior a data de check-in");
            }
            else {
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }
      }

        sc.close();

    }
}
