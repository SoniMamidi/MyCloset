package com.DBProjectCloset.model;

public class ApprovedItems {
int approved_id;
String date_posted,reduction,sold; 
boolean approved;
double selling_price,value,asking_price;
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}

public int getApproved_id() {
	return approved_id;
}
public void setApproved_id(int approved_id) {
	this.approved_id = approved_id;
}
public String getDate_posted() {
	return date_posted;
}
public void setDate_posted(String date_posted) {
	this.date_posted = date_posted;
}
public String getReduction() {
	return reduction;
}
public void setReduction(String reduction) {
	this.reduction = reduction;
}
public String getSold() {
	return sold;
}
public void setSold(String sold) {
	this.sold = sold;
}


public double getSelling_price() {
	return selling_price;
}
public void setSelling_price(double selling_price) {
	this.selling_price = selling_price;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public double getAsking_price() {
	return asking_price;
}
public void setAsking_price(double asking_price) {
	this.asking_price = asking_price;
}

@Override
public String toString() {
	return "ApprovedItems [approved_id=" + approved_id + ", date_posted=" + date_posted + ", reduction=" + reduction
			+ ", sold=" + sold + ", approved=" + approved + ", selling_price=" + selling_price + ", value=" + value
			+ ", asking_price=" + asking_price + "]";
}
public ApprovedItems() {
	super();
}

}
