/**
 * @author elizabethbarrord, barrorem
 * CSE274 A
 * This is a class to represent a line at
 * a movie theater over the course of an hour.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MovieTheaterLine {

	// Time interval in which the line was monitored (minutes)
	final int TIME_INTERVAL = 60;
	Customer customer;
	Queue<Customer> queue;
	int numberOfCustomersArrived;
	int customersServed;
	int timeWaited;
	int totalWaitTime;
	double timeGotTicket;

	// Constructor
	public MovieTheaterLine() {

		this.queue = new LinkedList<Customer>();
		this.customersServed = 0;
		this.timeWaited = 0;
		this.totalWaitTime = 0;
	}
	
	// Determining the number of people in line at a given time
	private int arrivals() {
		Random random = new Random();
		int ranNumOfArrivals = random.nextInt(21);
		return ranNumOfArrivals;
	}
	
	// Simulating the line over the desired time interval
	public void run() {
		for (int time = 0; time < TIME_INTERVAL; time++) {
			numberOfCustomersArrived = arrivals();
			for (int i = 1; i <= numberOfCustomersArrived; i++) {
				queue.add(new Customer(time));
				if (!queue.isEmpty() && timeGotTicket <= time) {
					customer = queue.remove();
					timeGotTicket = time + customer.getTransactionTime();
					timeWaited = time - customer.getcustomerTimeArrived();
					totalWaitTime += timeWaited;
					customersServed++;
				}
			}
		}
		result();
	}

	private void result() {

		int avgWait = totalWaitTime / customersServed;
		System.out.println("\n\"Movie Theater Scenario\"");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("The following data is based on monitoring a movie theater line for one hour.\n");
		System.out.println("It is assumed the average time to "
				+ "tell the cashier what movie you'd like to see,\npay, and receive for your ticket "
				+ "is between thirty seconds to a minute and a half.");
		System.out.println("\nThe number of people in line did not exceed twenty at a given time.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("The total number of customers served in the hour interval was " + customersServed + ".");
		System.out.println("The average wait time for each customer was " + avgWait + " minutes.");

	}

}
