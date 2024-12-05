package data.services;

import data.entities.Transaction;
import data.entities.TransactionType;
import data.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }


    public double getTotalBalance() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .mapToDouble(t -> t.getType() == TransactionType.REVENUE ? t.getAmount() : -t.getAmount())
                .sum();
    }

}