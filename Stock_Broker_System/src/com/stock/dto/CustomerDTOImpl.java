package com.stock.dto;

public class CustomerDTOImpl implements CustomerDTO {

	private String Cus_id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String PassWord;
	private String Address;
	private String Mobile;
	private String E_Mail;
	
	
	
	public CustomerDTOImpl(String Cus_id, String firstName, String lastName, String userName, String passWord, String address, String mobile,
			String e_Mail) {
		super();
		this.Cus_id=Cus_id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.UserName = userName;
		this.PassWord = passWord;
		this.Address = address;
		this.Mobile = mobile;
		this.E_Mail = e_Mail;
	}
	public String getCus_id() {
		return Cus_id;
	}
	public void setCus_id(String cus_id) {
		Cus_id = cus_id;
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
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getE_Mail() {
		return E_Mail;
	}
	public void setE_Mail(String e_Mail) {
		E_Mail = e_Mail;
	}
	@Override
	public String toString() {
		return "Cus_id=" + Cus_id + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", UserName=" + UserName + ", PassWord=" + PassWord + ", Address=" + Address + ", Mobile=" + Mobile
				+ ", E_Mail=" + E_Mail + "";
	}
	
}
