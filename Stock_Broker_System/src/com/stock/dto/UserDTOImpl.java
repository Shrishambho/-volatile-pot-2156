package com.stock.dto;

public class UserDTOImpl implements UserDTO {

	private String FirstName;
	private String LastName;
	private String UserName;
	private String PassWord;
	private String Address;
	private int Mobile;
	private String E_Mail;
	
	
	public UserDTOImpl(String firstName, String lastName, String userName, String passWord, String address, int mobile,
			String e_Mail) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.UserName = userName;
		this.PassWord = passWord;
		this.Address = address;
		this.Mobile = mobile;
		this.E_Mail = e_Mail;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		Mobile = mobile;
	}
	public String getE_Mail() {
		return E_Mail;
	}
	public void setE_Mail(String e_Mail) {
		E_Mail = e_Mail;
	}
	
	
	
	
}
