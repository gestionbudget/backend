
package data.repositories;

import data.entities.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}