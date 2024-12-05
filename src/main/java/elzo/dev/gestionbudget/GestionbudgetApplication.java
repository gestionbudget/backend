package elzo.dev.gestionbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("data.entities")
@EnableJpaRepositories("data.repositories")
@ComponentScan(basePackages = {
		"elzo.dev.gestionbudget",
		"data.TransactionController",
		"data.services",
		"data.entities",
		"data.repositories",
		"config"
})
public class GestionbudgetApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionbudgetApplication.class, args);
	}
}