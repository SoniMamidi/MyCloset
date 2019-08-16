package com.DBProjectCloset.model;

public class Address {
String addressLine,zipCode,city,state;
int user_id;
public String getAddressLine() {
	return addressLine;
}
public void setAddressLine(String addressLine) {
	this.addressLine = addressLine;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
@Override
public String toString() {
	return "Address [addressLine=" + addressLine + ", zipCode=" + zipCode + ", city=" + city + ", state=" + state
			+ ", user_id=" + user_id + "]";
}
public Address(String addressLine, String zipCode, String city, String state) {
	super();
	this.addressLine = addressLine;
	this.zipCode = zipCode;
	this.city = city;
	this.state = state;
}
public Address() {
	super();
}

}
