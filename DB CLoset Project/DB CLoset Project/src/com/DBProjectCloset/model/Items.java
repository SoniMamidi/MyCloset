package com.DBProjectCloset.model;

import com.DBProjectCloset.dao.CustomerDetailsDao;

public class Items {
int itemid,customer_id;
double itemprice,requested_price,discount;
String category,name,itemAge,description,imagebrand,gender,size,color,imageurl,quantity,donorstatus,approved_by,date_posted;
boolean isapproved,issold;
User user;
CustomerDetailsDao dao1=new CustomerDetailsDao();
public User getUser(int customer_id) {
	return dao1.getCustomer(customer_id);
}
public void setUser(User user) {
	this.user = user;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public String getItemAge() {
	return itemAge;
}
public void setItemAge(String itemAge) {
	this.itemAge = itemAge;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public double getItemprice() {
	return itemprice;
}
public void setItemprice(double itemprice) {
	this.itemprice = itemprice;
}
public double getRequested_price() {
	return requested_price;
}
public void setRequested_price(double requested_price) {
	this.requested_price = requested_price;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImagebrand() {
	return imagebrand;
}
public void setImagebrand(String imagebrand) {
	this.imagebrand = imagebrand;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getDonorstatus() {
	return donorstatus;
}
public void setDonorstatus(String donorstatus) {
	this.donorstatus = donorstatus;
}
public String getApproved_by() {
	return approved_by;
}
public void setApproved_by(String approved_by) {
	this.approved_by = approved_by;
}
public String getDate_posted() {
	return date_posted;
}
public void setDate_posted(String date_posted) {
	this.date_posted = date_posted;
}
public boolean isIsapproved() {
	return isapproved;
}
public void setIsapproved(boolean isapproved) {
	this.isapproved = isapproved;
}
public boolean isIssold() {
	return issold;
}
public void setIssold(boolean issold) {
	this.issold = issold;
}
public Items() {
	super();
}
@Override
public String toString() {
	return "Items [itemid=" + itemid + ", itemAge=" + itemAge + ", customer_id=" + customer_id + ", itemprice="
			+ itemprice + ", requested_price=" + requested_price + ", discount=" + discount + ", category=" + category
			+ ", name=" + name + ", description=" + description + ", imagebrand=" + imagebrand + ", gender=" + gender
			+ ", size=" + size + ", color=" + color + ", imageurl=" + imageurl + ", quantity=" + quantity
			+ ", donorstatus=" + donorstatus + ", approved_by=" + approved_by + ", date_posted=" + date_posted
			+ ", isapproved=" + isapproved + ", issold=" + issold + "]";
}


}
