package com.stock.othercases;

import java.util.List;
import java.util.Scanner;

import com.stock.dao.CustomerDAO;
import com.stock.dao.CustomerDAOImpl;
import com.stock.dao.StockDAO;
import com.stock.dao.StockDAOImpl;
import com.stock.dto.CustomerDTO;
import com.stock.dto.StockDTO;
import com.stock.dto.StockDTOImpl;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public class Stocks {

	public static void addStocks(Scanner sc) {
		System.out.print("Please enter company ID:-");
		String com_id=sc.next();
		System.out.print("Please enter company name:-");
		String com_name=sc.next();
		System.out.print("Please enter quantity:-");
		int quantity=sc.nextInt();
		System.out.print("Please enter price of single stock:-");
		double price=sc.nextDouble();
		
		StockDAO stockDAO=new StockDAOImpl();
		StockDTO stockDTO=new StockDTOImpl(com_id,com_name,quantity,price);
		try {
			stockDAO.addStocks(stockDTO);
			System.out.println("Stock added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	public static void viewStocks() {
		StockDAO stockDAO=new StockDAOImpl();
		try {
			List<StockDTO> listCustomer=stockDAO.getAllStocks();
			listCustomer.forEach(System.out::println);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			
		}
	}
	public static void deleteStock(Scanner sc) {
		
		System.out.print("Please enter company Name:-");
		String com_name=sc.next();
		StockDAO stockDAO=new StockDAOImpl();
		try {
			stockDAO.deleteStocks(com_name);
			System.out.println("Stocks deleted successfully");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		
	}
}
