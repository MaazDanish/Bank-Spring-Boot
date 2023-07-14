package in.bank.insurance.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.bank.insurance.Model.Insurance;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
	Insurance searchByCustomerId(int customerId);

}
