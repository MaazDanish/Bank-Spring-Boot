package in.bank.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.cards.config.CardsConfigService;
import in.bank.cards.model.Cards;
import in.bank.cards.model.ConfigProps;
import in.bank.cards.model.Customer;
import in.bank.cards.repository.CardsRepository;

@RestController
public class CardsController {

	@Autowired
	private CardsRepository cardsrepository;
	
	@Autowired
	private CardsConfigService CardsConfigService;
	
	
	@PostMapping("/cards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsrepository.findByCustomerId(customer.getCustomerId());
		return cards;
	}
	
	@GetMapping("/config")
    public String getPropertyDetails() throws JsonProcessingException {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    	ConfigProps cp =new ConfigProps(CardsConfigService.getMsg(),CardsConfigService.getBuildVersion(),CardsConfigService.getMailDetails(),CardsConfigService.getActiveBranches());
    	String string = ow.writeValueAsString(cp);
    	return string;
    }

}
