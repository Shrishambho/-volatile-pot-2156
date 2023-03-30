package com.stock.dao;

import com.stock.dto.StockDTO;
import com.stock.exception.SomethingWentWrongException;

public interface StockDAO {

	public void addStock(StockDTO stock)throws SomethingWentWrongException;
}
