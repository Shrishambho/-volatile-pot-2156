package com.stock.dao;

import java.sql.Connection;

import com.stock.dto.UserDTO;
import com.stock.exception.SomethingWentWrongException;

public class UserDAOImpl implements UserDAO {

	@Override
	public void user(UserDTO useDTO) throws SomethingWentWrongException {
		Connection conn=null;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query="INSERT INTO ";
		}
	}

}
