package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarRental {

    private LocalDateTime inicialTime;
    private LocalDateTime finalTime;

    private Vehicle vehicle;
    private Invoice invoice;



    public CarRental(LocalDateTime inicialTime, LocalDateTime finalTime, Vehicle vehicle) {
        this.inicialTime = inicialTime;
        this.finalTime = finalTime;
        this.vehicle = vehicle;
    }

    public LocalDateTime getInicialTime() {
        return inicialTime;
    }

    public LocalDateTime getFinalTime() {
        return finalTime;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public double totalHours() {

        return Math.ceil((double) Duration.between(inicialTime, finalTime).toMinutes() /60);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("modelo: ").append(vehicle.getModel()).append("\n");
        sb.append("total de horas utilizadas: ").append(totalHours()).append("\n");
        sb.append("valor bruto: ").append(invoice.getBasicPayment()).append("\n");
        sb.append("valor do imposto: ").append(invoice.getTax()).append("\n");
        sb.append("valor do total: ").append(invoice.totalPayment()).append("\n");
        return sb.toString();
    }
}
