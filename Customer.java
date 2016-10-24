
import java.util.Random;
/**
 * @author elizabethbarrord, barrorem
 * CSE274 A
 * This is a class to represent a movie theater customer
 * that is waiting in line.
 *
 */

public class Customer {
	

	private int customerTimeArrived;
	private double transactionTime;
	private int customerTimeWaited;

	public Customer() {
		this.customerTimeArrived = 0;
		this.transactionTime = 0;
		this.customerTimeWaited = 0;
	}

	public Customer(int customerTimeArrived1) {
		this.customerTimeArrived = customerTimeArrived1;
		Random randomTime = new Random();
		//serviced between 0.5 min - 1.5 min
		this.transactionTime =0.5 + (1.5 - .5) * randomTime.nextDouble();
	}
	
	
	public int getcustomerTimeArrived() {
		return customerTimeArrived;
	}

	public void setcustomerTimeArrived(int customerTimeArrived) {
		this.customerTimeArrived = customerTimeArrived;
	}

	public double getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(int timeServiced) {
		this.transactionTime = timeServiced;
	}

	public int getCustomerTimeWaited() {
		return customerTimeWaited;
	}

	public void setCustomerTimeWaited(int timeWaited) {
		this.customerTimeWaited = timeWaited;
	}

	public int totalTime() {
		
		return customerTimeArrived - customerTimeWaited;
	}
	
	
	
	
}
