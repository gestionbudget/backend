package data.services;

import data.Interface.ITransactionService;
import data.entities.Transaction;
import data.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.TransactionServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    private ITransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionServiceImpl(transactionRepository);
    }

    @Test
    void testAddTransaction() {
        Transaction transaction = new Transaction();
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Transaction result = transactionService.addTransaction(transaction);
        assertNotNull(result);
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testGetTransactionById_NotFound() {
        when(transactionRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Transaction> result = transactionService.getTransactionById(1L);
        assertFalse(result.isPresent());
        verify(transactionRepository, times(1)).findById(1L);
    }
}