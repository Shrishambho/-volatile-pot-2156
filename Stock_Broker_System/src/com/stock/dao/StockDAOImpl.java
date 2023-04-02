package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dto.CustomerDTO;
import com.stock.dto.CustomerDTOImpl;
import com.stock.dto.StockDTO;
import com.stock.dto.StockDTOImpl;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public class StockDAOImpl implements StockDAO {

	@Override
	public void addStocks(StockDTO stock) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO stock (com_id,com_name,quantity,price) VALUES(?,?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			
			ps.setString(1, stock.getCom_id());
			ps.setString(2, stock.getCom_name());
			ps.setInt(3, stock.getQuantity());
			ps.setDouble(4, stock.getPrice());
			
			
			//execute query
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add stocks");
			
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(conn);				
			}catch(SQLException sqlEX) {
				throw new SomethingWentWrongException(null);
			}
		}
		
		
	}

	@Override
	public List<StockDTO> getAllStocks() throws SomethingWentWrongException, NoRecordFoundException {
		
		Connection conn = null;
		List<StockDTO> list; 
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT com_id,com_name,quantity,price from stock";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Stock found");
			}
			
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new StockDTOImpl(rs.getString(1), rs.getString(2), 
						rs.getInt(3),rs.getDouble(4)));
			}
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to show stock");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}

	@Override
	public void deleteStocks(String com_name) throws SomethingWentWrongException, NoRecordFoundException {
		
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String DELETE_QUERY = "DELETE FROM stock WHERE com_name = ?";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, com_name);
			
			//execute query
			ps.executeUpdate();
		}catch(ClassNotFoundException| SQLException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException("");
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(conn);				
			}catch(SQLException sqlEX) {
				throw new SomethingWentWrongException("");
			}
		}
		
	}

}


