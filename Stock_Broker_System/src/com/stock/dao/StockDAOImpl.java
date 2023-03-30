package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stock.dto.StockDTO;
import com.stock.exception.SomethingWentWrongException;

public class StockDAOImpl implements StockDAO {

	@Override
	public void addStock(StockDTO stkDTO)throws SomethingWentWrongException{
		Connection conn=null;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query="INSERT Into stock(com_id,com_name,quantity,price) VALUES(?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, stkDTO.getCom_id());
			ps.setString(2,stkDTO.getCom_name());
			ps.setInt(3, stkDTO.getQuantity());
			ps.setLong(4,stkDTO.getPrice());
			
			ps.executeUpdate();
			
			
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("unable to add stock");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
}
