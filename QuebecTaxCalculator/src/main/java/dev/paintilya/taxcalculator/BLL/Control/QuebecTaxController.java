package dev.paintilya.taxcalculator.BLL.Control;

import dev.paintilya.taxcalculator.BLL.Model.TaxBracket;

import java.util.ArrayList;
import java.util.List;

public class QuebecTaxController {
    private List<TaxBracket> taxBrackets;

    public QuebecTaxController() {
        taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 46295, 0.15f));
        taxBrackets.add(new TaxBracket(46295, 92580, 0.20f));
        taxBrackets.add(new TaxBracket(92580, 112655, 0.24f));
        taxBrackets.add(new TaxBracket(112655, Float.MAX_VALUE, 0.2575f));
    }

    public float calculateTax(float netIncome) {
        float tax = 0;
        for (TaxBracket bracket : taxBrackets) {
            if (netIncome > bracket.getMax()) {
                tax += (bracket.getMax() - bracket.getMin()) * bracket.getRate();
            } else {
                tax += (netIncome - bracket.getMin()) * bracket.getRate();
                break;
            }
        }
        return tax;
    }
}