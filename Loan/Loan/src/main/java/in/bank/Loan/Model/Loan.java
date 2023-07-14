package in.bank.Loan.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity @Table(name="loans")
public class Loan {
	@Id      // making  primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_number")
	private int loanNumber; 
	
	@Column(name="customer_id") 	 
	private int customerId;
	
	@Column(name="loan_type")
	private String LoanType;
	
	@Column(name="loan_Amount")
	private int loanAmount;
	
	@Column(name="loan_end_date")
	private Date loanEndDate;

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLoanType() {
		return LoanType;
	}

	public void setLoanType(String loanType) {
		LoanType = loanType;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	@Override
	public String toString() {
		return "Loan [loanNumber=" + loanNumber + ", customerId=" + customerId + ", LoanType=" + LoanType
				+ ", loanAmmount=" + loanAmount + ", loanEndDate=" + loanEndDate + "]";
	}
	
	
}
