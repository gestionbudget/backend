

package data.TransactionController;

import data.Interface.ITransactionService;
import data.entities.Transaction;
import data.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        return transactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new DataNotFoundException("Transaction not found with id " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
        // validate existence first, can throw DataNotFoundException
        transactionService.getTransactionById(id).orElseThrow(() -> new DataNotFoundException("Transaction not found with id " + id));
        return ResponseEntity.ok(transactionService.updateTransaction(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        // validate existence first, can throw DataNotFoundException
        transactionService.getTransactionById(id).orElseThrow(() -> new DataNotFoundException("Transaction not found with id " + id));
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getTotalBalance() {
        return ResponseEntity.ok(transactionService.getTotalBalance());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}