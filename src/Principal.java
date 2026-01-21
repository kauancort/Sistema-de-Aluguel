import model.entities.CarRental;
import model.services.RentalService;
import model.entities.Vehicle;
import model.services.BrazilianTax;

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

        

        CarRental cr = new CarRental(inicialHour, finalHour, new Vehicle(carName));
        
        RentalService rentalService = new RentalService(valueDay, valueHour, new BrazilianTax());
        
        rentalService.processInvoice(cr);


        System.out.println(cr);



        sc.close();




    }
}
