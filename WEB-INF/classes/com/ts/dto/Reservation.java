package com.ts.dto;

import java.util.Date;

public class Reservation {
	private Passenger pId;
	private Date date;
	private String status;
	private String time;
	
	public Passenger getpId(){
		return pId;
	}
	public void setpId(Passenger pId){
		this.pId = pId;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String Status){
		this.status = status;
	}
	public String getTime(){
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String toString() {
		return "Reservation [pId=" + pId + ", date=" + date + ", status=" + status
				+ ", time=" + time +  "]";
	}

}
