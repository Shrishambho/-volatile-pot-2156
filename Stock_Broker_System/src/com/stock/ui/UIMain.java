package com.stock.ui;

import java.util.Scanner;

public class UIMain {

	static void showAdminMenu() {
		System.out.println("1. View All Customer.");
		System.out.println("2. Add new stocks");
		System.out.println("3. View all stocks");
		System.out.println("4. Show sold stocks");
		System.out.println("5. Delete Customer");
		System.out.println("6. Delete Stocks");
	}
	static void adminMenu(Scanner sc) {
		System.out.println("Welcome admin");
		int choice=0;
		do {
			showAdminMenu();
			System.out.print("Enter selection:- ");
			choice =sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("By By Admin");
				break;
			case 1:
//				StockUI.viewStock();
				break;
			case 2:
				StockUI.addStocks(sc);
				break;
				
			}
		}while(choice!=0);
	}
	static void adminLogin(Scanner sc) {
		System.out.print("Enter Username:- ");
		String Username=sc.next();
		System.out.print("Enter Password:-");
		String Password=sc.next();
		
		if(Username.equalsIgnoreCase("admin")&&Password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}
		else {
			System.out.println("Incorrect Username or Password.");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("=======================================");
			System.out.println("Welcome to Stock Broker.");
			System.out.println("Invest with us safely.");
			System.out.println("1. Admin Login\n2. Customer Login\n3. Customer SignUp\n4. Exit");
			System.out.println("=======================================");
			System.out.print("Enter Selection:- ");
			
			choice=sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("Thank you visite again.");
				break;
			case 1:
				adminLogin(sc);
				break;
			case 2:
				UserUI.logIn(sc);
				break;
			case 3:
				UserUI.signUp(sc);
			}
		}while(choice!=0);
	}
}
