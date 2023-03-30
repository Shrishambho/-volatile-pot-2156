package com.stock.dao;

import com.stock.dto.UserDTO;
import com.stock.exception.SomethingWentWrongException;

public interface UserDAO {

	public void user(UserDTO useDTO) throws SomethingWentWrongException;
}
