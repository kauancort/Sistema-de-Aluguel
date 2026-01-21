package model.services;

public class BrazilianTax {

    public double tax( double value) {

        if (value <= 100 ) {
            return value * 0.2;
        }
        else {

            return value * 0.15;
        }

    }


}
