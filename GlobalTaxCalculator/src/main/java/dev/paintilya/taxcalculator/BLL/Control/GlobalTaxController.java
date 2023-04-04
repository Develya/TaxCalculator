package dev.paintilya.taxcalculator.BLL.Control;

public class GlobalTaxController {
    private CanadaTaxController canadaTaxController;
    private QuebecTaxController quebecTaxController;

    public GlobalTaxController(CanadaTaxController canadaTaxController, QuebecTaxController quebecTaxController) {
        this.canadaTaxController = canadaTaxController;
        this.quebecTaxController = quebecTaxController;
    }

    public double calculateGlobalTax(double grossRevenue) {
        double federalTax = canadaTaxController.calculateTax(grossRevenue);
        double provincialTax = quebecTaxController.calculateTax(grossRevenue);
        return federalTax + provincialTax;

        // TODO Not quite doing what its supposed to yet: check EPIC
    }
}