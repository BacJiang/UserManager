package com.hikvision.usermanager.bean;

public class UserInfo {
	private int id;
	private String userName;
	private String sex;
	private int age;
	private String email;
	private String address;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String userName, String sex, int age, String email, String address) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
