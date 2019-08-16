package com.DBProjectCloset.model;

public class DonatedItems {
	int item_ID,quantity,donor_ID;
	String category,item_Condition,description,type,color,picture_URL,gender,size;
	public int getItem_ID() {
		return item_ID;
	}
	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}
	public DonatedItems() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "DonatedItems [item_ID=" + item_ID + ", quantity=" + quantity + ", donor_ID=" + donor_ID + ", category="
				+ category + ", item_Condition=" + item_Condition + ", description=" + description + ", type=" + type
				+ ", color=" + color + ", picture_URL=" + picture_URL + ", gender=" + gender + ", size=" + size + "]";
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDonor_ID() {
		return donor_ID;
	}
	public void setDonor_ID(int donor_ID) {
		this.donor_ID = donor_ID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem_Condition() {
		return item_Condition;
	}
	public void setItem_Condition(String item_Condition) {
		this.item_Condition = item_Condition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPicture_URL() {
		return picture_URL;
	}
	public void setPicture_URL(String picture_URL) {
		this.picture_URL = picture_URL;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
