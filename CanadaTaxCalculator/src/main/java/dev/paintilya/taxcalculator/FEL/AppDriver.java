package dev.paintilya.taxcalculator.FEL;

import dev.paintilya.taxcalculator.BLL.Control.CanadaTaxController;

public class AppDriver {
    public static void main(String[] args) {
        CanadaTaxController taxController = new CanadaTaxController();
        float netIncome = 80000;
        float tax = taxController.calculateTax(netIncome);
        String formattedTax = String.format("%.2f", tax);
        System.out.println("Pour un revenu net de " + netIncome + "$, la taxe à payer est de " + formattedTax + "$.");
    }
}