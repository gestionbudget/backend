
package elzo.dev.gestionbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("data.repositories")
@EntityScan("data.entities")
@ComponentScan(basePackages = {
		"data.TransactionController",
		"services",
		"data.repositories",
		"data.Interface",
		"data.entities",
		"data.exceptions",
		"config"
})
public class GestionbudgetApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionbudgetApplication.class, args);
	}
}