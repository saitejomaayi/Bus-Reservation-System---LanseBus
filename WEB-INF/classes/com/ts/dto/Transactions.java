package com.ts.dto;

public class Transactions {
	private Bus bId;
	private Passenger pId;
	private int noOfSeats;
	
	public Bus getbId(){
		return bId;
	}
	public void setbId(Bus bId){
		this.bId = bId;
	}
	public Passenger getPId(){
		return pId;
	}
	public void setPId(Passenger PId){
		this.pId = PId;
	}
	public int getNoOfSeats(){
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats){
		this.noOfSeats = noOfSeats;
	}
	public String toString() {
		return "Transactions [bId=" + bId + ", pId=" + pId + ", noOfseats=" + noOfSeats+"]";
	}

}
