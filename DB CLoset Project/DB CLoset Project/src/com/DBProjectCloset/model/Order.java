package com.DBProjectCloset.model;

import com.DBProjectCloset.dao.BundleOrdersDao;
import com.DBProjectCloset.dao.CustomerDetailsDao;
import com.DBProjectCloset.dao.ItemDetailDao;

public class Order {
int order_id,customer_id,item_id;
String bundle_id,date_ordered,order_status;
Items item;

BundleOrders bundleOrder;
User user;
ItemDetailDao dao=new ItemDetailDao();
CustomerDetailsDao dao1=new CustomerDetailsDao();
BundleOrdersDao dao2=new BundleOrdersDao();
public BundleOrders getBundleOrder(String bundleId) {
	return dao2.getBundles(bundleId);
}
public void setBundleOrder(BundleOrders bundleOrder) {
	this.bundleOrder = bundleOrder;
}
public User getUser(int customer_id) {
	return dao1.getCustomer(customer_id);
}
public void setUser(User user) {
	this.user = user;
}
public Items getItem(int item_id) {
	return dao.getItem(item_id);
}
public void setItem(Items item) {
	this.item = item;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public int getItem_id() {
	return item_id;
}
public void setItem_id(int item_id) {
	this.item_id = item_id;
}
public String getBundle_id() {
	return bundle_id;
}
public void setBundle_id(String bundle_id) {
	this.bundle_id = bundle_id;
}
public String getDate_ordered() {
	return date_ordered;
}
public void setDate_ordered(String date_ordered) {
	this.date_ordered = date_ordered;
}
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
@Override
public String toString() {
	return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", item_id=" + item_id + ", bundle_id="
			+ bundle_id + ", date_ordered=" + date_ordered + ", order_status=" + order_status + "]";
}
public Order() {
	super();
}

}
