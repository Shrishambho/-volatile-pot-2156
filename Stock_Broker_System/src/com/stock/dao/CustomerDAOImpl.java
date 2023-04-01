package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.stock.dto.CustomerDTO;
import com.stock.dto.CustomerDTOImpl;
import com.stock.exception.NoRecordFoundException;
import com.stock.exception.SomethingWentWrongException;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addCustomer(CustomerDTO cusDTO) throws SomethingWentWrongException {
		Connection conn=null;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query=("INSERT INTO customer (cus_id,firstName,lastName,userName,password,email,address,mobile) VALUES(?,?,?,?,?,?,?,?)");
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1,cusDTO.getCus_id());
			
			ps.setString(2,cusDTO.getFirstName());
			
			ps.setString(3, cusDTO.getLastName());
			
			ps.setString(4, cusDTO.getUserName());
			
			ps.setString(5, cusDTO.getPassWord());
			
			ps.setString(6, cusDTO.getE_Mail());
			
			ps.setString(7, cusDTO.getAddress());
			
			ps.setString(8, cusDTO.getMobile());
			
			ps.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("unable to add customer");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		
	}

	public List<CustomerDTO> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<CustomerDTO> list=new ArrayList<>();
		try {
			//connect to database
			conn = DBUtils.getConnectionTodatabase();
			
			//prepare the query
			String SELECT_QUERY = "SELECT cus_id,firstName,lastName,userName,password,email,address,mobile from customer";
			
			//get the prepared statement object
			PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet rs = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Customer Found");
			}
		
			while(rs.next()) {
				list.add(new CustomerDTOImpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			System.out.println("I am here6");
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
	
}
	
	
	
	

