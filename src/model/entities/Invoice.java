package model.entities;

public class Invoice {

    private double basicPayment;
    private double tax;

    public Invoice () {}
    public Invoice(double basicPayment, double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;

    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public double getTax() {
        return tax;
    }

    public double totalPayment() {
        return basicPayment + tax;
    }


}
