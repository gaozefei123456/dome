package com.chinasoft.app.entiy;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private int num;
	private String pic;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Product(int pid, String pname, double price, int num, String pic) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.pic = pic;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
