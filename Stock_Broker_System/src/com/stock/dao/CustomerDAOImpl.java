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

	@Override
	public List<CustomerDTO> viewCustomer() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn=null;
		List<CustomerDTO> list;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query="SELECT id,cus_id,firstName,lastName,userName,email,password,address,mobile";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No cutomer availables");
			}
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new CustomerDTOImpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Customer list is empty");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}

	
	
	
}
