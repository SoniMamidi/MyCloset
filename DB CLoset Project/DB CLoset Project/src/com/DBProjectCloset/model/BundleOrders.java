package com.DBProjectCloset.model;

public class BundleOrders {
int id,total_order,shipping,tax,grand_total;
String bundle_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTotal_order() {
	return total_order;
}
public void setTotal_order(int total_order) {
	this.total_order = total_order;
}
public int getShipping() {
	return shipping;
}
public void setShipping(int shipping) {
	this.shipping = shipping;
}
public int getTax() {
	return tax;
}
public void setTax(int tax) {
	this.tax = tax;
}
public int getGrand_total() {
	return grand_total;
}
public void setGrand_total(int grand_total) {
	this.grand_total = grand_total;
}
public String getBundle_id() {
	return bundle_id;
}
public void setBundle_id(String bundle_id) {
	this.bundle_id = bundle_id;
}
@Override
public String toString() {
	return "BundleOrders [id=" + id + ", total_order=" + total_order + ", shipping=" + shipping + ", tax=" + tax
			+ ", grand_total=" + grand_total + ", bundle_id=" + bundle_id + ", getId()=" + getId()
			+ ", getTotal_order()=" + getTotal_order() + ", getShipping()=" + getShipping() + ", getTax()=" + getTax()
			+ ", getGrand_total()=" + getGrand_total() + ", getBundle_id()=" + getBundle_id() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public BundleOrders() {
	super();
}

}
