package com.stock.dao;

import java.util.List;

import com.stock.dto.CustomerDTO;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public interface CustomerDAO {

	public void addCustomer(CustomerDTO customer) throws SomethingWentWrongException;
	public List<CustomerDTO> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException;
	public void deleteCustomer(String userName)throws SomethingWentWrongException, NoRecordFoundException;
	public void login(String userName,String password)throws SomethingWentWrongException, NoRecordFoundException;
}
