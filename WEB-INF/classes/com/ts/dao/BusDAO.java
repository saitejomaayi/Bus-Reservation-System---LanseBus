package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Bus;


public class BusDAO {
	public List<Bus> getAllBusDetails(){
		List<Bus> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from Bus";
	try{
		Connection con = DBConnection.getConnection(); 
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Bus bus=new Bus();
			bus.setbId(rst.getString(1));
			bus.setSeats(rst.getInt(2));
			bus.setSource(rst.getString(3));
			bus.setDestination(rst.getString(4));
			bus.setDriverName(rst.getString(5));
			bus.setDriverNumber(rst.getLong(6));
			bus.setDate(rst.getDate(7));
			bus.setTime(rst.getString(8));
			bus.setPrice(rst.getInt(9));
			list.add(bus);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	System.out.println(list);
	return list;
	}
	public Bus getBusDetails(String source,String destination, java.util.Date date){
		System.out.println(source+" "+destination+" "+" "+date);
		PreparedStatement pst = null;
		ResultSet rst = null;
		Bus bus=null;
		final String SELECT_QUERY = "select * from bus where Source = ? and Destination = ? and Date = ?";
		try{
		Connection con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, source);
			pst.setString(2, destination);
			pst.setDate(3,new java.sql.Date(date.getTime()));
			rst = pst.executeQuery();
			if(rst.next()){
				bus =new Bus();
				bus.setbId(rst.getString(1));
				bus.setSeats(rst.getInt(2));
				bus.setSource(rst.getString(3));
				bus.setDestination(rst.getString(4));
				bus.setDriverName(rst.getString(5));
				bus.setDriverNumber(rst.getLong(6));
				bus.setDate(rst.getDate(7));
				bus.setTime(rst.getString(8));
				bus.setPrice(rst.getInt(9));
				
				//System.out.println(bus);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		System.out.print("Inside getBusDetails dao."+bus);
		return bus;
	}
	
		
	public List<Bus> getDetails(String source,String destination, java.util.Date date){
		List<Bus> list=new ArrayList<>();
		System.out.println(source+" "+destination+" "+" "+date);
		PreparedStatement pst = null;
		ResultSet rst = null;
		Bus bus=null;
		final String SELECT_QUERY = "select * from bus where Source = ? and Destination = ? and Date = ?";
		try{
		Connection con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, source);
			pst.setString(2, destination);
			pst.setDate(3,new java.sql.Date(date.getTime()));
			rst = pst.executeQuery();
			if(rst.next()){
				bus =new Bus();
				bus.setbId(rst.getString(1));
				bus.setSeats(rst.getInt(2));
				bus.setSource(rst.getString(3));
				bus.setDestination(rst.getString(4));
				bus.setDriverName(rst.getString(5));
				bus.setDriverNumber(rst.getLong(6));
				bus.setDate(rst.getDate(7));
				bus.setTime(rst.getString(8));
				bus.setPrice(rst.getInt(9));
				list.add(bus);
				System.out.println(bus);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		System.out.print("Inside dao. Test "+bus);
		return list;
	}
	public int removeBus(String bId){
		System.out.println(bId);
		PreparedStatement pst = null;
		
		Bus bus=null;
		int status=0;
		final String DELETE_QUERY = "delete from bus where bId = ?";
		try{
			Connection con = DBConnection.getConnection();
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setString(1, bId);
			
			status = pst.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
				}
		System.out.print("Inside dao."+bus);
		return status;
	}
	public int updateBus(Bus bus) {
		Connection con = null;
		PreparedStatement pst = null;
		int x = 0;
			try {
				con = DBConnection.getConnection();
				pst = con.prepareStatement("update bus set Seats= ?,Source=?,Destination=?,drivername=?,driverNumber=?,Date=?,Time=?,Price=? where bId = ?");
				pst.setString(9, bus.getbId());
				pst.setInt(1, bus.getSeats());
				pst.setString(2, bus.getSource());
				pst.setString(3, bus.getDestination());
				pst.setString(4, bus.getDriverName());
				pst.setLong(5, bus.getDriverNumber());
				pst.setDate(6, new java.sql.Date((bus.getDate()).getTime()));
				pst.setString(7, bus.getTime());
				pst.setInt(8, bus.getPrice());
				x = pst.executeUpdate();
				System.out.println("Inside Update....."+bus);
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
			finally{
				try {
					con.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return x;
		}
	public Bus getBus(String bId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Bus bus=null;
	final String SELECT_QUERY = "select * from bus where bId = ?";
	try{
		Connection con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, bId);
		rst = pst.executeQuery();
		if(rst.next()){
			 bus =new Bus();
			 bus.setbId(rst.getString(1));
				bus.setSeats(rst.getInt(2));
				bus.setSource(rst.getString(3));
				bus.setDestination(rst.getString(4));
				bus.setDriverName(rst.getString(5));
				bus.setDriverNumber(rst.getLong(6));
				bus.setDate(rst.getDate(7));
				bus.setTime(rst.getString(8));
				bus.setPrice(rst.getInt(9));
		System.out.println(bus);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return bus;
	}
	public int add(Bus bus){
		final String INSERT_QUERY="insert into Bus(bId,Seats,Source,Destination,driverName,driverNumber,date,time,Price) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try{
		Connection con=DBConnection.getConnection(); 
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, bus.getbId());
			pst.setInt(2, bus.getSeats());
			pst.setString(3, bus.getSource());
			pst.setString(4, bus.getDestination());
			pst.setString(5, bus.getDriverName());
			pst.setLong(6, bus.getDriverNumber());
			pst.setDate(7, new java.sql.Date((bus.getDate()).getTime()));
			pst.setString(8, bus.getTime());
			pst.setInt(9, bus.getPrice());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}
	/*public Bus getNoOfSeats(String bId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Bus bus=null;
		final String SELECT_QUERY = "select * from bus where bId = ?";
		
		try {
			Connection con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1,bId);
			rst = pst.executeQuery();
			if(rst.next()){
				bus=new Bus();
				pst.setString(1,bId);
				pst.setInt(2, bus.getSeats());
				pst.setInt(3, bus.getPrice());
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		System.out.println("inside noofSeats"+ bus);
		return bus;
		}*/
	
}
