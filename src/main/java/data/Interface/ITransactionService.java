package data.Interface;

import data.entities.Transaction;
import java.util.List;
import java.util.Optional;

public interface ITransactionService {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
    Transaction updateTransaction(Long id, Transaction transaction);
    void deleteTransaction(Long id);
    Double getTotalBalance();
}