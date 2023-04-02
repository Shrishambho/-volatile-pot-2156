package com.stock.dao;

import com.stock.dto.CustomerFund;
import com.stock.exception.SomethingWentWrongException;

public interface FundsDAO {

	void addfunds(CustomerFund customer) throws SomethingWentWrongException;

	
}
