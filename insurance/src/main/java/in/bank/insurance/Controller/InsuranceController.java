package in.bank.insurance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.insurance.Model.ConfigProps;
import in.bank.insurance.Model.Customer;
import in.bank.insurance.Model.Insurance;
import in.bank.insurance.Repository.InsuranceRepository;
import in.bank.insurance.config.InsuranceConfigService;

@RestController
public class InsuranceController {
	@Autowired
	InsuranceRepository repo;
	
	@Autowired
	InsuranceConfigService  insuranceConfigService;
	
	@PostMapping("/insurance")
	public Insurance insuranceDetails(@RequestBody Customer customer) {
		Insurance insurance = repo.searchByCustomerId(customer.getCustomerId());
		return insurance;
	}
	
	@GetMapping("/config")
    public String getPropertyDetails() throws JsonProcessingException {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    	ConfigProps cp =new ConfigProps(insuranceConfigService.getMsg(),insuranceConfigService.getBuildVersion(),insuranceConfigService.getMailDetails(),insuranceConfigService.getActiveBranches());
    	String string = ow.writeValueAsString(cp);
    	return string;
    }
}