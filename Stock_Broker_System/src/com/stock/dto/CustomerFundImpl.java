package com.stock.dto;

public class CustomerFundImpl implements CustomerFund{

	private int customer_id;
	private double add_funds;
	
	public CustomerFundImpl(int customer_id, double add_funds) {
		super();
		this.customer_id = customer_id;
		this.add_funds = add_funds;
		
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getAdd_funds() {
		return add_funds;
	}
	public void setAdd_funds(double add_funds) {
		this.add_funds = add_funds;
	}
	
	
	@Override
	public String toString() {
		return "Your current account balance is "+add_funds+"";
	}
	
}
