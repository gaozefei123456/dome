package com.chinasoft.app.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.app.dao.impl.ProductDAOImpl;
import com.chinasoft.app.entiy.Product;
import com.chinasoft.app.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public boolean addProduct(String pname, double price, int num, String pic) {
		// TODO Auto-generated method stub
		ProductDAOImpl pdi=new ProductDAOImpl();
		int num1=pdi.addProduct(pname, price, num, pic);
		if(num1>0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		ProductDAOImpl pdi=new ProductDAOImpl();
		int num=pdi.updateProduct(product);
		if(num>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> al=new ArrayList<Product>();
		ProductDAOImpl pdi=new ProductDAOImpl();
		ResultSet res=pdi.findAll();
		try {
			while(res.next()){
				Product p=new Product();
				p.setPid(res.getInt(1));
				p.setPname(res.getString(2));
				p.setPrice(res.getDouble(3));
				p.setNum(res.getInt(4));
				p.setPic(res.getString(5));
				al.add(p);
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findAlltonum(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		ProductDAOImpl pdi=new ProductDAOImpl();
		return pdi.findAlltonum(currentPage, pageSize);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		ProductDAOImpl pdi=new ProductDAOImpl();
		return pdi.findById(id);
	}

}
