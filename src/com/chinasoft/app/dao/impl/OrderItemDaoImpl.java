package com.chinasoft.app.dao.impl;

import com.chinasoft.app.dao.OrderItemDao;
import com.chinasoft.app.entiy.OrderItem;
import com.chinasoft.app.util.DBUtil;

public class OrderItemDaoImpl implements OrderItemDao{

	@Override
	public int AddOrderItem(OrderItem oi) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="insert into orderitem values(?,?,?,?)";
		int res=db.executOther(sql, new Object[]{null,oi.getOrders().getOid(),oi.getProduct().getPid(),oi.getNum()});
		
		return res;
	}

}
