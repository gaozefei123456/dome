package com.chinasoft.app.service;

import java.util.List;

import com.chinasoft.app.entiy.Product;

public interface ProductService {
	public boolean addProduct(String pname,double price,int num,String pic);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int pid);
	//查询全部，根据id查询，根据其他的条件查询
	public Product findById(int id);
	public List<Product> findAll();
	public List<Product> findAlltonum(int currentPage, int pageSize);
}
