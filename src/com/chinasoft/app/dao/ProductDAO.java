package com.chinasoft.app.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chinasoft.app.entiy.Product;


public interface ProductDAO {
	public int addProduct(String pname,double price,int num,String pic);
	public ResultSet findAll();
	public int updateProduct(Product product);
	public int deleteProduct(int id);
	public List<Product> findAlltonum(int currentPage,int pageSize);
	public Product findById(int id);
}
