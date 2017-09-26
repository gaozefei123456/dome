package com.chinasoft.app.service.impl;

import com.chinasoft.app.dao.impl.OrderDaoImpl;
import com.chinasoft.app.entiy.Orders;
import com.chinasoft.app.service.OrderItemService;
import com.chinasoft.app.service.OrderService;
import com.chinasoft.app.service.ProductService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		OrderDaoImpl odi=new OrderDaoImpl();
		odi.addOrders(orders);
		
		OrderItemService orderItemService  = new OrderItemServiceImpl();
		ProductService pr = new ProductServiceImpl();
		for(int i=0;i<orders.getOrderItems().size();i++){
			orderItemService.addOrderItem(orders.getOrderItems().get(i));
			orders.getOrderItems().get(i).getProduct().setNum(orders.getOrderItems().get(i).getProduct().getNum()-orders.getOrderItems().get(i).getNum());
			pr.updateProduct(orders.getOrderItems().get(i).getProduct());
		}
		
	}

}
