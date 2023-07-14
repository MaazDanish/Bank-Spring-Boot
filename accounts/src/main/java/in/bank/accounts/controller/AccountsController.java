package in.bank.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.accounts.config.AccountsConfigService;
import in.bank.accounts.model.Accounts;
import in.bank.accounts.model.ConfigProps;
import in.bank.accounts.model.Customers;
import in.bank.accounts.repository.AccountRepository;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountRepository accountsRepository;
	
	@Autowired
	AccountsConfigService accountsConfigService;
	
	@PostMapping("/accounts")
	public Accounts getAccountDetails(@RequestBody Customers customer) {
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		return accounts;
	}
	
    @GetMapping("/config")
    public String getPropertyDetails() throws JsonProcessingException {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    	ConfigProps cp =new ConfigProps(accountsConfigService.getMsg(),accountsConfigService.getBuildVersion(),accountsConfigService.getMailDetails(),accountsConfigService.getActiveBranches());
    	String string = ow.writeValueAsString(cp);
    	return string;
    }
    
}
