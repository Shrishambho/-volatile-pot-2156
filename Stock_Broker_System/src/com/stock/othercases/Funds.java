package com.stock.othercases;

import java.util.Scanner;

import com.stock.dao.FundsAmount;
import com.stock.dao.FundsDAO;
import com.stock.dao.FundsDAOImpl;
import com.stock.dao.LoggedINUser;
import com.stock.dto.CustomerFund;
import com.stock.dto.CustomerFundImpl;
import com.stock.exception.SomethingWentWrongException;

public class Funds {

	public static void addFunds(Scanner sc) {
		System.out.println("Enter amount:-");
		double amount=sc.nextDouble();
		
		FundsDAO fundsDAO =new FundsDAOImpl();
		CustomerFund customer=new CustomerFundImpl(LoggedINUser.LoggedInUserId,amount);
		try {
			fundsDAO.addfunds(customer);
			System.out.println("funds added successfully");
			System.out.println("Your wallet balance is "+FundsAmount.walletBalance);
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
}
