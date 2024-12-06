package validators;

import data.entities.Transaction;
import data.entities.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TransactionValidator {

    public static boolean isValid(Transaction transaction) {
        if (transaction == null) {
            return false;
        }
        return isDescriptionValid(transaction.getDescription()) &&
                isTypeValid(transaction.getType()) &&
                isAmountValid(transaction.getAmount()) &&
                isDateValid(transaction.getDate());
    }

    private static boolean isDescriptionValid(String description) {
        return description != null && !description.trim().isEmpty() && description.matches("^[a-zA-Z\\s]+$");
    }

    private static boolean isTypeValid(TransactionType type) {
        return type != null;
    }

    private static boolean isAmountValid(Double amount) {
        return amount != null && amount > 0;
    }

    private static boolean isDateValid(@NotNull(message = "La date est obligatoire") LocalDate date) {
        return date != null;
    }
}