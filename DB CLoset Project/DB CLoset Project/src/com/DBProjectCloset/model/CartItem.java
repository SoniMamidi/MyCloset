package com.DBProjectCloset.model;

public class CartItem {
 int itemid;int customerID;String itemName;int cartItemID;String ImgURl;double itemPrice;

public int getItemid() {
	return itemid;
}

public void setItemid(int itemid) {
	this.itemid = itemid;
}

public int getCustomerID() {
	return customerID;
}

public void setCustomerID(int customerID) {
	this.customerID = customerID;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public int getCartItemID() {
	return cartItemID;
}

public void setCartItemID(int cartItemID) {
	this.cartItemID = cartItemID;
}

public String getImgURl() {
	return ImgURl;
}

public void setImgURl(String imgURl) {
	ImgURl = imgURl;
}

public double getItemPrice() {
	return itemPrice;
}

public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
 
}
