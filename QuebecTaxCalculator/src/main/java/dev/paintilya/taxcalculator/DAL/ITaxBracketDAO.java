package dev.paintilya.taxcalculator.DAL;

import dev.paintilya.taxcalculator.BLL.Model.TaxBracket;

import java.util.List;

public interface ITaxBracketDAO {
    public List<TaxBracket> findAll();
    public TaxBracket findByRate(float rate);
}
