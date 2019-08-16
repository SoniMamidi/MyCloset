package com.DBProjectCloset.model;

public class User {
int id;
String name,username,password,type,email,statusMsg;
public String getStatusMsg() {
	return statusMsg;
}
public void setStatusMsg(String statusMsg) {
	this.statusMsg = statusMsg;
}
String phone_no;
Address address;

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", type=" + type
			+ ", email=" + email + ", phone_no=" + phone_no + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}
public User() {
	super();
}
public User(String name, String username, String password, String type, String email,
		String phone_no) {
	super();
	this.name = name;
	this.username = username;
	this.password = password;
	this.type = type;
	this.email = email;
	this.phone_no = phone_no;
}
public User(String name, String username, String password, String type, String email, String phone_no,
		Address address) {
	super();
	this.name = name;
	this.username = username;
	this.password = password;
	this.type = type;
	this.email = email;
	this.statusMsg = statusMsg;
	this.phone_no = phone_no;
	this.address = address;
}

}
