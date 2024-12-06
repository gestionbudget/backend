package services;

import data.Interface.ITransactionService;
import data.entities.Transaction;
import data.entities.TransactionType;
import data.repositories.TransactionRepository;
import validators.TransactionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        if (!TransactionValidator.isValid(transaction)) {
            throw new IllegalArgumentException("Invalid transaction data");
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }


    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        if (!TransactionValidator.isValid(transaction)) {
            throw new IllegalArgumentException("Invalid transaction data");
        }
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }



    @Override
    public Double getTotalBalance() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .mapToDouble(t -> t.getType() == TransactionType.REVENUE ? t.getAmount() : -t.getAmount())
                .sum();
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}