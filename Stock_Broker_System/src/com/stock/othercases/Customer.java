package com.stock.othercases;

import java.util.List;
import java.util.Scanner;

import com.stock.dao.CustomerDAO;
import com.stock.dao.CustomerDAOImpl;
import com.stock.dao.LoggedINUser;
import com.stock.dto.CustomerDTO;
import com.stock.dto.CustomerDTOImpl;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;
import com.stock.ui.UIMain;

public class Customer {

	
	public static void addCustomer(Scanner sc) {
		System.out.println("Please Enter Customer Id:-");
		String cus_id=sc.next();
		System.out.println("Please Enter firstName:-");
		String firstname=sc.next();
		System.out.println("Please Enter Lastname:-");
		String lastname=sc.next();
		System.out.println("Please Enter Username:-");
		String username=sc.next();
		System.out.println("Please Enter Password:-");
		String password=sc.next();
		System.out.println("Please Enter E_mail:-");
		String e_mail=sc.next();
		System.out.println("Please Enter address:-");
		String address=sc.next();
		System.out.println("Please Enter mobile:-");
		String mobile=sc.next();
		//create object for category with category id and name
		
		CustomerDAO customerDAO=new CustomerDAOImpl();
		CustomerDTO customerDTO=new CustomerDTOImpl(cus_id,firstname,lastname,username,password,e_mail,address,mobile);
		
		try {
			customerDAO.addCustomer(customerDTO);
			System.out.println("Customer added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	public static void viewCustomer() {
		CustomerDAO customerDAO=new CustomerDAOImpl();
		try {
			List<CustomerDTO> listCustomer=customerDAO.getAllCustomers();
			listCustomer.forEach(System.out::println);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			
		}
	}
	public static void deleteCustomer(Scanner sc) {
		System.out.println("Please Enter username:-");
		String userName=sc.next();
		CustomerDAO customerDAO=new CustomerDAOImpl();
		try {
			customerDAO.deleteCustomer(userName);
			System.out.println("customer deleted successfully.");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	public static boolean login(Scanner sc) {
		boolean loginScuccessfull=false;
		
		System.out.print("Enter username:-");
		String userName=sc.next();
		
		System.out.print("Enter password:-");
		String password=sc.next();
		CustomerDAO customerDAO=new CustomerDAOImpl();
		try {
			customerDAO.login(userName, password);
			System.out.println("Welcome "+ LoggedINUser.LoggedInFirstName+"");
			loginScuccessfull=true;
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		return loginScuccessfull;
	}
	
	public static void logout() {

		 int LoggedInUserId=0;
		  
		  LoggedINUser.LoggedInLastName=null;
		  LoggedINUser.LoggedInUserName=null;
		  LoggedINUser.LoggedInPassWord=null;
		  LoggedINUser.LoggedInEmail=null;
		  LoggedINUser.LoggedInAddress=null;
		  LoggedINUser.LoggedInMobile=null;
		  System.out.println("Thank You "+LoggedINUser.LoggedInFirstName);
		  LoggedINUser.LoggedInFirstName=null;
		  UIMain.main(null);
	}
	public static void deleteUser(String userName) {
		CustomerDAO customerDAO=new CustomerDAOImpl();
		try {
			System.out.println("By By "+LoggedINUser.LoggedInFirstName);
			customerDAO.deleteCustomer(userName);
			UIMain.main(null);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
}
