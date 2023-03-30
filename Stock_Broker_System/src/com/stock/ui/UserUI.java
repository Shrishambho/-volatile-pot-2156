package com.stock.ui;

import java.util.Scanner;

import com.stock.dto.UserDTO;
import com.stock.dto.UserDTOImpl;

public class UserUI {

	static void signUp(Scanner sc) {
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
		int Mobile=sc.nextInt();
		System.out.print("Please Enter Your E_mail Id:-");
		String E_mail=sc.next();
		
		
		UserDTO user=new UserDTOImpl(FirstName,LastName,UserName,PassWord,Address,Mobile,E_mail);
	    
	}
	static void logIn(Scanner sc) {
		
	}
	static void logOut() {
		
	}
}
