package in.bank.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// it is working
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScans({@ComponentScan("in.bank.cards.controller")})
@EnableJpaRepositories("in.bank.cards.repository")
@EntityScan("in.bank.cards.model")
public class CardsApplication{
	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
		
	}

}
