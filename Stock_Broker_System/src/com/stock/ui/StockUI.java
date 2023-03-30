package com.stock.ui;

import java.util.Scanner;

import com.stock.dao.StockDAO;
import com.stock.dao.StockDAOImpl;
import com.stock.dto.StockDTO;
import com.stock.dto.StockDTOImpl;
import com.stock.exception.SomethingWentWrongException;

public class StockUI {
 static void addStocks(Scanner sc) {
	 System.out.print("Please Enter Company Id:-");
	 String com_id=sc.next();
	 System.out.print("Please Enter Company Name:-");
	 String com_name=sc.next();
	 System.out.print("Please Enter quantity of stocks:-");
	 int quantity=sc.nextInt();
	 System.out.print("Please enter price of a single stock:-");
	 long price=sc.nextLong();
	 
	 StockDTO stock=new StockDTOImpl(com_id,com_name,quantity,price);
	 
	 StockDAO stkDAO=new StockDAOImpl();
	 try {
		 stkDAO.addStock(stock);
		 System.out.println("Stock added suceesfully");
	 }catch(SomethingWentWrongException ex) {
		 System.out.println(ex);
	 }
	 
 }
	
}
