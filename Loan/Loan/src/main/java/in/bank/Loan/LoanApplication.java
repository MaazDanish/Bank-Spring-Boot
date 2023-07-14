package in.bank.Loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// it is working
@SpringBootApplication

@ComponentScans({@ComponentScan("in.bank.Loan.Controller")})
@EnableJpaRepositories("in.bank.Loan.Repository")
@EntityScan("in.bank.Loan.Model")
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
