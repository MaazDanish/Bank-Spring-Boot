package in.bank.insurance.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="insurance")
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insurance_id")
	private int insuranceId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="insurance_type")
	private String insuranceType;
	
	@Column(name="insured_amount")
	private long insuredAmount;
	
	@Column(name="insured_end_date")
	private LocalDate insuredEndDate;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public long getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(long insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public LocalDate getInsuredEndDate() {
		return insuredEndDate;
	}

	public void setInsuredEndDate(LocalDate insuredEndDate) {
		this.insuredEndDate = insuredEndDate;
	}

	@Override
	public String toString() {
		return "Insurance [customerId=" + customerId + ", insuranceId=" + insuranceId + ", insuranceType="
				+ insuranceType + ", insuredAmount=" + insuredAmount + ", insuredEndDate=" + insuredEndDate + "]";
	}
}
