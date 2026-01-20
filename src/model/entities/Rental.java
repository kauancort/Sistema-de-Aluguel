package model.entities;

import model.interfaces.Tax;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Rental implements Tax {

    private String carModel;
    private LocalDateTime inicialTime;
    private LocalDateTime finalTime;
    private double pricePerHour;
    private double pricePerDay;

    private int totalHours;
    private int totalDay;
    private double finalValue;


    public Rental(String carModel, LocalDateTime inicialTime, LocalDateTime finalTime, double pricePerDay, double pricePerHour) {
        this.carModel = carModel;
        this.inicialTime = inicialTime;
        this.finalTime = finalTime;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;


            double hours = ((double) ChronoUnit.MINUTES.between(inicialTime, finalTime) / 60);

            if (hours % 1 != 0 ) {
                totalHours = (int) hours + 1;
            } else {
                totalHours = (int) hours;
            }

            if (totalHours >= 12 && totalHours < 24 ) {
                totalDay = 1;
            } else if (totalHours >= 24) {

               totalDay = totalHours / 24;

            }

    }

    @Override
    public double value() {
        if ( totalHours >= 12  ) {
            finalValue = totalDay * pricePerDay;
        } else {
           finalValue = totalHours * pricePerHour;
        }

        if (finalValue <= 100) {
           return finalValue *= 1.2;

        } else {
           return finalValue *= 1.15;
        }
    }

    @Override
    public String verifyTax() {

        if ( totalHours >= 12  ) {
            return "a taxa é diaria pois passou de 12h: " + totalHours;
        } else {
            return  "a taxa é por hora "+ totalHours;
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Modelo do veículo: ").append(carModel).append("\n");
        sb.append(verifyTax()).append("\n");
        sb.append("Valor TOTAL:").append(value()).append("\n");
        sb.append("Valor por dia: ").append(pricePerDay).append("\n");
        sb.append("Valor por hora: ").append(pricePerHour).append("\n");
        sb.append("Sistema cobra imposto de 20% até 100 reais e 15% se for acima de 100.");

        return sb.toString();
    }
}
