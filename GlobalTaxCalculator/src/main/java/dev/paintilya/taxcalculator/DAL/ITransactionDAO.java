package dev.paintilya.taxcalculator.DAL;

import dev.paintilya.taxcalculator.BLL.Model.Transaction;

public interface ITransactionDAO {
    public void saveTransaction(Transaction transaction);
}
