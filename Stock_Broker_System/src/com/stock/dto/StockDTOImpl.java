package com.stock.dto;

public class StockDTOImpl implements StockDTO {

	private String com_id;
	private String  com_name;
	private int quantity;
	private double price;
	public StockDTOImpl(String com_id, String com_name, int quantity, double price) {
		super();
		this.com_id = com_id;
		this.com_name = com_name;
		this.quantity = quantity;
		this.price = price;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "com_id=" + com_id + ", com_name=" + com_name + ", quantity=" + quantity + ", price="
				+ price + "";
	}
	
}
