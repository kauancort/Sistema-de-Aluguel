package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {


    private double pricePerHour;
    private double pricePerDay;

     private TaxService taxService;



    public RentalService(double pricePerDay, double pricePerHour, TaxService taxService) {

        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;

    }

    public void processInvoice(CarRental cr) {

        double value;
        double totalHour = ((double) ChronoUnit.MINUTES.between(cr.getInicialTime(), cr.getFinalTime()) / 60);

        if (totalHour <= 12) {
            value =  Math.ceil(totalHour) * pricePerHour;
        }
        else {

            value = Math.ceil(totalHour / 24) * pricePerDay;

        }


       cr.setInvoice(new Invoice(value, taxService.tax(value)));

    }
}
