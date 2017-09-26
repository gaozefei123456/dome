package com.chinasoft.app.po;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart1 {
	public Map<Integer,CartItem> mycart =new LinkedHashMap<Integer,CartItem>();
	public int totalnum;
	public float totalprice;
	public synchronized void addCartItem(final CartItem cartItem){
		int pid=cartItem.getProduct().getPid();
		if(mycart.containsKey(pid)){
			CartItem item=mycart.get(pid);
			item.setTotalnum(cartItem.getTotalnum()+1);
		}else{
			mycart.put(pid,cartItem);
		}
	}
	public synchronized Map<Integer, CartItem> getMycart() {
		return mycart;
	}
	public synchronized void setMycart(Map<Integer, CartItem> mycart) {
		this.mycart = mycart;
	}
	public int getTotalnum() {
		int totalnum=0;
		for(CartItem cartItem:mycart.values()){
			totalnum+=cartItem.getTotalnum();
		}
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public synchronized float getTotalprice() {
		float totalprice=0.0f;
		for(CartItem cartItem:mycart.values()){
			totalprice+=cartItem.getTotalprice();
		}
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	
}
