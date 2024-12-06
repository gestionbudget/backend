package data.TransactionController;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.entities.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Remove @Autowired and create manually
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAddTransactionValidationFail() throws Exception {
        Transaction invalidTransaction = new Transaction();
        // Setup invalid data

        mockMvc.perform(post("/transactions")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(invalidTransaction)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetTransaction_NotFound() throws Exception {
        mockMvc.perform(get("/transactions/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Transaction not found with id 999"));
    }
}