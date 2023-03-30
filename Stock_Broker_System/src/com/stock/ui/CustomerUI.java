package com.stock.ui;

import java.util.List;
import java.util.Scanner;

import com.stock.dao.CustomerDAO;
import com.stock.dao.CustomerDAOImpl;
import com.stock.dto.CustomerDTO;

public class CustomerUI {

	public void viewCustomer() {
		CustomerDAO customerDAO=new CustomerDAOImpl();
		List<CustomerDTO> list=customerDAO.viewCustomer();
	}
	public void deleteCustomer() {
		
	}
	
	
}
