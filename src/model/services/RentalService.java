package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {


    private double pricePerHour;
    private double pricePerDay;

    BrazilianTax brTax;
    private double totalHour;


    public RentalService(double pricePerDay, double pricePerHour, BrazilianTax brTax) {

        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.brTax = brTax;

    }


    public double getTotalHour() {
        return Math.ceil(totalHour);
    }

    public void processInvoice(CarRental cr) {

        double value;
         totalHour = ((double) ChronoUnit.MINUTES.between(cr.getInicialTime(), cr.getFinalTime()) / 60);

        if (totalHour <= 12) {
            value =  Math.ceil(totalHour) * pricePerHour;
        }
        else {

            value = Math.ceil(totalHour / 24) * pricePerDay;

        }


       cr.setInvoice(new Invoice(value, brTax.tax(value)));

    }
}
