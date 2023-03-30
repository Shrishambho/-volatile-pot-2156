package com.stock.dao;

import java.util.List;

import com.stock.dto.CustomerDTO;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public interface CustomerDAO {

	public void addCustomer(CustomerDTO cusDTO) throws SomethingWentWrongException;
    public List<CustomerDTO> viewCustomer() throws SomethingWentWrongException, NoRecordFoundException;
}
