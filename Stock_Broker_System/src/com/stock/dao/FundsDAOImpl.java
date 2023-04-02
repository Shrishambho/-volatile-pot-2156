package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stock.dto.CustomerFund;
import com.stock.exception.SomethingWentWrongException;

public class FundsDAOImpl implements FundsDAO{

	@Override
	public void addfunds(CustomerFund customer) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO funds (customer_id,add_funds) VALUES (?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			
			ps.setInt(1, customer.getCustomer_id());
			ps.setDouble(2, customer.getAdd_funds());
			
			
			//execute query
			ps.executeUpdate();
			FundsAmount.walletBalance=customer.getAdd_funds();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add funds");
			
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(conn);				
			}catch(SQLException sqlEX) {
				throw new SomethingWentWrongException(null);
			}
		}
		
	}

}
