package com.stock.dao;

import java.util.List;

import com.stock.dto.CustomerDTO;
import com.stock.dto.StockDTO;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public interface StockDAO {

	public void addStocks(StockDTO stock) throws SomethingWentWrongException;
	public List<StockDTO> getAllStocks() throws SomethingWentWrongException, NoRecordFoundException;
	public void deleteStocks(String com_name)throws SomethingWentWrongException, NoRecordFoundException;
}
