package in.bank.Loan.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.bank.Loan.Model.Loan;

@Repository
public interface LoansReposirory extends CrudRepository<Loan, Long> {
      List <Loan> findBycustomerId(int customerId);
	
}
