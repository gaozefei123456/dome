package com.chinasoft.app.service.impl;

import com.chinasoft.app.dao.OrderItemDao;
import com.chinasoft.app.dao.impl.OrderItemDaoImpl;
import com.chinasoft.app.entiy.OrderItem;
import com.chinasoft.app.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{

	@Override
	public int addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		return orderItemDao.AddOrderItem(orderItem);
	}

}
