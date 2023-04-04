package dev.paintilya.taxcalculator.FEL;

import dev.paintilya.taxcalculator.BLL.Control.QuebecTaxController;

public class AppDriver {
    public static void main(String[] args) {
        QuebecTaxController taxController = new QuebecTaxController();
        double netIncome = 50000;
        double tax = taxController.calculateTax(netIncome);
        String formattedTax = String.format("%.2f", tax);
        System.out.println("Pour un revenu net de " + netIncome + "$, la taxe à payer est de " + formattedTax + "$.");
    }
}