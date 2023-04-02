package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dto.CustomerDTO;
import com.stock.dto.CustomerDTOImpl;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public void addCustomer(CustomerDTO customer) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO customer (cus_id, firstName, lastName, userName, password, email, address, mobile) VALUES (?,?,?,?,?,?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			
			ps.setString(1, customer.getCus_id());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getUserName());
			ps.setString(5, customer.getPassword());
			ps.setString(6, customer.getEmail());
			ps.setString(7, customer.getAddress());
			ps.setString(8, customer.getMobile());
			
			//execute query
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add category");
			
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
	public List<CustomerDTO> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<CustomerDTO> list; 
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT cus_id,firstName,lastName,userName,password,email,address,mobile from customer";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Customer found");
			}
			
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new CustomerDTOImpl(rs.getString(1), rs.getString(2), 
						rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to show customer");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}

	@Override
	public void deleteCustomer(String userName) throws SomethingWentWrongException, NoRecordFoundException {

		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String DELETE_QUERY = "DELETE FROM customer WHERE userName = ?";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, userName);
			
			//execute query
			ps.executeUpdate();
		}catch(ClassNotFoundException| SQLException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException("User not found");
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(conn);				
			}catch(SQLException sqlEX) {
				throw new SomethingWentWrongException("");
			}
		}
		
	}

	@Override
	public void login(String userName, String password) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			//prepare the query
			String LOGIN_QUERY = "SELECT id,firstName,lastName,userName,password,email,address,mobile FROM customer WHERE userName = ? AND password = ?";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(LOGIN_QUERY);
			
			//stuff the data in the query
			ps.setString(1, userName);
			ps.setString(2, password);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("Invalid Username and Password");
			}
			
			
			//you are here means username and password combination is correct
			resultSet.next();
			
			LoggedINUser.LoggedInUserId = resultSet.getInt("id");
			
			LoggedINUser.LoggedInFirstName=resultSet.getString("firstName");
			LoggedINUser.LoggedInLastName=resultSet.getString("lastName");
			LoggedINUser.LoggedInUserName=resultSet.getString("userName");
			LoggedINUser.LoggedInPassWord=resultSet.getString("password");
			LoggedINUser.LoggedInEmail=resultSet.getString("email");
			LoggedINUser.LoggedInAddress=resultSet.getString("address");
			LoggedINUser.LoggedInMobile=resultSet.getString("mobile");
			
			
		}catch(ClassNotFoundException | SQLException sqlEx) {
			//code to log the error in the file
			throw new SomethingWentWrongException("user not found");
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


