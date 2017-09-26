package com.chinasoft.app.po;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer,CartItem> mycart = new LinkedHashMap<Integer, CartItem>();
	private int totalnum;
	private float totalprice;
	//添加商品
	public synchronized void addCartItem(final CartItem cartItem){
		//首先判断购物车中是否有这个商品，通过pid
		int pid  = cartItem.getProduct().getPid();
		//如果购物车中有这个商品了，商品的数量加一
		if(mycart.containsKey(pid)){
			CartItem item = mycart.get(pid);
			item.setTotalnum(item.getTotalnum()+1);
		}else{
			mycart.put(pid, cartItem);
		}
	}
	//synchronized：就是在一个时间有且仅有一个人才能访问
	public synchronized Map<Integer, CartItem> getMycart() {
		return mycart;
	}
	public void setMycart(Map<Integer, CartItem> mycart) {
		this.mycart = mycart;
	}
	//获得总数量
	public synchronized int getTotalnum() {
		int totalnum=0;
		for(CartItem cartItem:mycart.values()){
			totalnum+=cartItem.getTotalnum();
		}
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	//获得总价格
	public synchronized float getTotalprice() {
		float totalprice = 0.0f;
		for(CartItem cartItem:mycart.values()){
			totalprice+=cartItem.getTotalprice();
		}
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	//删除商品:两种情况：一种是直接删除商品flat=2，另一种减少商品数量 flag=1：
	public synchronized void removeProduct(final int pid,final int flag){
		if(flag==1){
			//分为两种情况：第一种减数量，第二种，当数量为1的时候，直接删除商品
			if(mycart.get(pid).getTotalnum()==1){
				mycart.remove(pid);
			}else{
				mycart.get(pid).setTotalnum(mycart.get(pid).getTotalnum()-1);
			}
		}else{
			mycart.remove(pid);
		}
	}
	//清空购物车
	public synchronized void clearCart(){
		mycart.clear();
	}
}
