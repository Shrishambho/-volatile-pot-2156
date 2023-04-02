package com.stock.ui;

import java.util.Scanner;

import com.stock.dao.LoggedINUser;
import com.stock.othercases.Customer;
import com.stock.othercases.Funds;
import com.stock.othercases.Stocks;

public class UIMain {

	static void displayAdminMenu() {
		System.out.println("1. View all customers.");
		System.out.println("2. Add new stocks.");
		System.out.println("3. View all stocks.");
		System.out.println("4. View consolidated report");
		System.out.println("5. Delete customer");
		System.out.println("6. Delete Stock");
		System.out.println("7. Logout admin");
	}
	static void adminMenu(Scanner sc) {
		int choice=0;
		do {
			displayAdminMenu();
			System.out.println("Enter Selection:-");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				Customer.viewCustomer();
				break;
			case 2:
				Stocks.addStocks(sc);
				break;
			case 3:
				Stocks.viewStocks();
				break;
			case 4:
				
				break;
			case 5:
				Customer.deleteCustomer(sc);
				break;
			case 6:
				Stocks.deleteStock(sc);
				break;
			case 7:
				System.out.println("Bye Bye admin");
				UIMain.main(null);
				break;
			}
		}while(choice!=0);
	}
	
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username:-");
	    String username=sc.next();
	    System.out.print("Enter password:-");
	    String password=sc.next();
	    
	    if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")) {
	    	adminMenu(sc);
	    }
	    else
	    {
	    	System.out.println("Invalid Username and Password");
	    }
	    
	}
	
	static void displayCustomerMenu() {
		System.out.println("---------------------------------------------");
		System.out.println("|   1.View Stocks                           |");
		System.out.println("|   2.Buy and Sells Stocks                  |");
		System.out.println("|   3.View Owen Transaction History         |");
		System.out.println("|   4.Add funds                             |");
		System.out.println("|   5.Withdraw funds                        |");
		System.out.println("|   6.LogOut                                |");
		System.out.println("|   7.Delete Account                        |");
		System.out.println("---------------------------------------------");
	}
	
	static void customerLogin(Scanner sc) {
		if(!Customer.login(sc)) {
			return;
		}
		int choice=0;
		do {
			displayCustomerMenu();
			System.out.print("Enter Selection:-");
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					Stocks.viewStocks();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					Funds.addFunds(sc);
					break;
				case 5:
					
					break;
				case 6:
					Customer.logout();
					break;
				case 7:
					Customer.deleteUser(LoggedINUser.LoggedInUserName);
					break;
				default:
					System.out.println("Please choose correct options");
					
			}
			
		}while(LoggedINUser.LoggedInUserId!=0);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int choice =0;
		do {
			System.out.println("Welcome to Stock Broker");
			System.out.println("Invest us with safely");
			System.out.println("1. Admin Login\n2. Customer Login\n3. Customer SignUp\n4. Exit");
			System.out.print("Enter your choice:- ");
			choice=sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("Thank you,Visit again");
				break;
			case 1:
				adminLogin(sc);
				break;
			case 2:
				customerLogin(sc);
				break;
			case 3:
				Customer.addCustomer(sc);
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		}while(choice!=0);
	}
	
	
	
	
	
	
}
