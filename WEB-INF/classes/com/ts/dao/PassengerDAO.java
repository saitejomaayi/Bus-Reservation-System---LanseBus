package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Passenger;

public class PassengerDAO {
	public int add(Passenger passenger){
		final String INSERT_QUERY="insert into passenger(pId,pName,Gender,Age,Phone,Password) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try{
		Connection con=DBConnection.getConnection(); 
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, passenger.getpId());
			pst.setString(2, passenger.getpName());
			pst.setString(3, passenger.getGender());
			pst.setInt(4, passenger.getAge());
			pst.setLong(5, passenger.getPhone());
			pst.setString(6, passenger.getPassword());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	public Passenger getPassenger(String pName,String password){
		System.out.println(pName+" "+password);
		PreparedStatement pst = null;
		ResultSet rst = null;
		Passenger passenger=null;
		final String SELECT_QUERY = "select * from passenger where pName = ? and Password = ?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, pName);
			pst.setString(2, password);
			rst = pst.executeQuery();
			if(rst.next()){
				passenger=new Passenger();
				passenger.setpId(rst.getString(1));
				passenger.setpName(rst.getString(2));
				passenger.setGender(rst.getString(3));
				passenger.setAge(rst.getInt(4));
				passenger.setPhone(rst.getLong(5));
				passenger.setPassword(rst.getString(6));
				System.out.println(passenger);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		System.out.print("Inside dao."+passenger);
		return passenger;
	}
	

}
