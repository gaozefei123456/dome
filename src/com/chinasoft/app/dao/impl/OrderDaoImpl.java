package com.chinasoft.app.dao.impl;

import com.chinasoft.app.dao.OrderDao;
import com.chinasoft.app.entiy.Orders;
import com.chinasoft.app.util.DBUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public int addOrders(Orders orders) {
		// TODO Auto-generated method stub
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		DBUtil db=new DBUtil();
		int res = db.executOther(sql, new Object[]{orders.getOid(),orders.getAddress(),orders.getPhone(),orders.getRename(),orders.getState(),orders.getOrderTime(),orders.getMoney(),orders.getUser().getUid()});
		return res;
	}

}
