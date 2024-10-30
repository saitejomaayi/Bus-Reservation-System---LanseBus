package com.ts.dto;
import java.util.Date;
public class Bus {
	private String bId;
	private int seats;
	private String source;
	private String destination;
	private String driverName;
	private long driverNumber;
	private Date date;
	private String time;
	private int price;
	
	public String getbId(){
		return bId;
	}
	public void setbId(String bId){
		this.bId = bId;
	}
	public int getSeats(){
		return seats;
	}
	public void setSeats(int seats){
		this.seats = seats;
	}
	public String getSource(){
		return source;
	}
	public void setSource(String source){
		this.source = source; 
	}
	public String getDestination(){
		return destination;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public String getDriverName(){
		return driverName;
	}
	public void setDriverName(String driverName){
		this.driverName = driverName;
	}
	public long getDriverNumber(){
		return driverNumber;
	}
	public void setDriverNumber(long driverNumber){
		this.driverNumber = driverNumber;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public String getTime(){
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public String toString() {
		return "Bus [bId=" + bId + ", seats =" + seats + ", source =" + source
				+ ", destination=" + destination + ", driverName=" + driverName + ", driverNumber="+ driverNumber +", date=" + date + ", time=" + time + ", price" + price +  "]";
	}
	

}
