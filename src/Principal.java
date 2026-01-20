import model.entities.Rental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");

        System.out.println("nome do carro: ");
            String carName = sc.nextLine();

        System.out.println("horario inicio: ");
            LocalDateTime inicialHour = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.println("horario final ");
        LocalDateTime finalHour = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.println("Valor por dia: ");
            double valueDay = sc.nextDouble();
                sc.nextLine();

        System.out.println("Valor por hora: ");
            double valueHour = sc.nextDouble();
                sc.nextLine();

        Rental rent = new Rental(carName, inicialHour, finalHour, valueDay, valueHour);

        System.out.println(rent);





        sc.close();




    }
}
