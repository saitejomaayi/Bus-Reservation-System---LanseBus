package com.ts.dto;

public class Passenger {
	private String pId;
	private String pName;
	private int age;
	private String gender;
	private long phone;
	private String password;
	public String getpId(){
		return pId;
	}
	public void setpId(String pId){
		this.pId = pId;
	}
	public String getpName(){
		return pName;
	}
	public void setpName(String pName){
		this.pName = pName;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public long getPhone(){
		return phone;
	}
	public void setPhone(long phone){
		this.phone = phone;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String toString() {
		return "Passenger [pId=" + pId + ", pName=" + pName + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + ", password=" + password +"]";
	}
	
}
