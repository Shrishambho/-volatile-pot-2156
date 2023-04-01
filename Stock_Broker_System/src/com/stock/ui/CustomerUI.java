package com.stock.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.stock.dao.CustomerDAO;
import com.stock.dao.CustomerDAOImpl;
import com.stock.dto.CustomerDTO;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public class CustomerUI {

	public static void viewAllCustomer(){
		CustomerDAO customerDAO = new CustomerDAOImpl();
		try {
			List<CustomerDTO> customerList=customerDAO.getAllCustomers();
//			Consumer<CustomerDTO> con=c -> System.out.println("cus_id "+c.getCus_id());
			
			customerList.forEach(System.out::println);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
}
