package dev.paintilya.taxcalculator.FEL;

import dev.paintilya.taxcalculator.BLL.Control.CanadaTaxController;
import dev.paintilya.taxcalculator.BLL.Control.GlobalTaxController;
import dev.paintilya.taxcalculator.BLL.Control.QuebecTaxController;
import dev.paintilya.taxcalculator.BLL.Model.Transaction;
import dev.paintilya.taxcalculator.DAL.CsvTransactionDAO;

import java.util.ArrayList;
import java.util.List;

public class AppDriver {
    public static void main(String[] args) {
        CanadaTaxController canadaTaxController = new CanadaTaxController();
        QuebecTaxController quebecTaxController = new QuebecTaxController();
        GlobalTaxController globalTaxController = new GlobalTaxController(canadaTaxController, quebecTaxController);

        // Exemple de transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("2022-01-01", 100000, 0));
        transactions.add(new Transaction("2022-02-01", 200000, 0));
        transactions.add(new Transaction("2022-03-01", 300000, 0));

        for (Transaction transaction : transactions) {
            double globalTax = globalTaxController.calculateGlobalTax(transaction.getGrossRevenue());
            double formattedTax = Double.parseDouble(String.format("%.2f", globalTax));
            transaction.setTax(formattedTax);

            // Enregistrement de la transaction dans un fichier CSV
            CsvTransactionDAO dao = new CsvTransactionDAO("/home/kiyranya/IdeaProjects/TaxCalculator/GlobalTaxCalculator/src/main/resources/transactions.csv");
            dao.saveTransaction(transaction);
        }
    }
}