package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Reservation;
import com.ts.dto.Passenger;

public class ReservationDAO {
	/*public Reservation getStatus(String pId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Reservation reservation =null;
	final String SELECT_QUERY = "select * from bus where pId = ?";
	try{
		Connection con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, pId);
		rst = pst.executeQuery();
		if(rst.next()){
				Reservation rs = new Reservation();
				rs.setpId(( rst).getPassenger(1));
				bus.setSeats(rst.getInt(2));
				bus.setSource(rst.getString(3));
				bus.setDestination(rst.getString(4));
				bus.setDriverName(rst.getString(5));
				bus.setDriverNumber(rst.getLong(6));
				bus.setDate(rst.getDate(7));
				bus.setTime(rst.getString(8));
				bus.setPrice(rst.getInt(9));
		System.out.println(reservation));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return reservation;
	}*/
		
	
	}


