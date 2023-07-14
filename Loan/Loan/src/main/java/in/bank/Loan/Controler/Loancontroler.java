package in.bank.Loan.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.Loan.Config.LoanConfigService;
import in.bank.Loan.Model.ConfigProps;
import in.bank.Loan.Model.Customer;
import in.bank.Loan.Model.Loan;
import in.bank.Loan.Repository.LoansReposirory;

@RestController
public class Loancontroler {
	@Autowired
	private LoansReposirory loansrepository;

	@Autowired
	LoanConfigService LoansConfigService;

	@PostMapping("/loans")
	public List<Loan> Getloandetails(@RequestBody Customer customer) {
		List<Loan> loan = loansrepository.findBycustomerId(customer.getCustomerId());
		return loan;
	}

	@GetMapping("/config")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ConfigProps cp = new ConfigProps(LoansConfigService.getMsg(), LoansConfigService.getBuildVersion(),
				LoansConfigService.getMailDetails(), LoansConfigService.getActiveBranches());
		String string = ow.writeValueAsString(cp);
		return string;
	}

}
