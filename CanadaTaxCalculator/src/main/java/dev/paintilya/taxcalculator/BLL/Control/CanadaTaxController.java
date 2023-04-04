package dev.paintilya.taxcalculator.BLL.Control;

import dev.paintilya.taxcalculator.BLL.Model.TaxBracket;

import java.util.ArrayList;
import java.util.List;

public class CanadaTaxController {

    private List<TaxBracket> taxBrackets;

    public CanadaTaxController() {
        taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 49020, 0.15f));
        taxBrackets.add(new TaxBracket(49020, 98040, 0.205f));
        taxBrackets.add(new TaxBracket(98040, 151978, 0.26f));
        taxBrackets.add(new TaxBracket(151978, 216511, 0.29f));
        taxBrackets.add(new TaxBracket(216511, Float.MAX_VALUE, 0.33f));
    }

    public float calculateTax(float netIncome) {
        float tax = 0;
        for (TaxBracket bracket : taxBrackets) {
            if (netIncome <= bracket.getMax()) {
                tax += (netIncome - bracket.getMin()) * bracket.getRate();
                break;
            } else {
                tax += (bracket.getMax() - bracket.getMin()) * bracket.getRate();
            }
        }
        return tax;
    }
}
