package com.chinasoft.app.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.app.dao.ProductDAO;
import com.chinasoft.app.entiy.Product;
import com.chinasoft.app.util.DBUtil;




public class ProductDAOImpl implements ProductDAO{

	@Override
	public int addProduct(String pname, double price, int num, String pic) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql="insert into product values(null,?,?,?,?)";
		int num1=db.executOther(sql, new Object[]{pname,price,num,pic});
		return num1;
	}


	

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql="update product set pname=?,price=?,num=?,pic=? where pid=?";
		int num = db.executOther(sql, new Object[]{product.getPname(),product.getPrice(),product.getNum(),product.getPic(),product.getPid()});
		
		return num;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		DBUtil db = new DBUtil();
		ResultSet res = db.execQuery(sql, new Object[]{});
		return res;
	}




	@Override
	public List<Product> findAlltonum(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql="select * from product limit ?,?";
		ResultSet res=db.execQuery(sql, new Object[]{(currentPage-1)*pageSize,pageSize});
		ArrayList<Product> al=new ArrayList<Product>();
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
	public Product findById(int id) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql="select * from product where pid=?";
		ResultSet res = db.execQuery(sql, new Object[]{id});
		try {
			while(res.next()){
				Product p=new Product();
				p.setPid(res.getInt(1));
				p.setPname(res.getString(2));
				p.setPrice(res.getDouble(3));
				p.setNum(res.getInt(4));
				p.setPic(res.getString(5));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
