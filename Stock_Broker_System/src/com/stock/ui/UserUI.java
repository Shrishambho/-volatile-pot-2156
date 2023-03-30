package com.stock.ui;

import java.util.Scanner;

import com.stock.dao.CustomerDAO;
import com.stock.dao.CustomerDAOImpl;


import com.stock.dto.CustomerDTO;
import com.stock.dto.CustomerDTOImpl;


import com.stock.exception.SomethingWentWrongException;

public class UserUI {

	static void signUp(Scanner sc) {
		System.out.println("=======================================");
		System.out.print("Please Enter Your customerId:-");
		String Cus_id=sc.next();
		System.out.print("Please Enter Your FirstName:-");
		String FirstName=sc.next();
		System.out.print("Please Enter Your LastName:-");
		String LastName=sc.next();
		System.out.print("Please Enter Your UserName:-");
		String UserName=sc.next();
		System.out.print("Please Enter Your PassWord:-");
		String PassWord=sc.next();
		System.out.print("Please Enter Your Address:-");
		String Address=sc.next();
		System.out.print("Please Enter Your Mobile Number:-");
		String Mobile=sc.next();
		System.out.print("Please Enter Your E_mail Id:-");
		String E_mail=sc.next();
		System.out.println("=======================================");
		
		CustomerDTO user=new CustomerDTOImpl(Cus_id,FirstName,LastName,UserName,PassWord,Address,Mobile,E_mail);
	    
		CustomerDAO useDAO=new CustomerDAOImpl();
		try {
			useDAO.addCustomer(user);
			System.out.println("Customer added successfully");	
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	static void logIn(Scanner sc) {
		
	}
	static void logOut() {
		
	}
}
