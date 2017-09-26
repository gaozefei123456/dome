package com.chinasoft.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.app.entiy.OrderItem;
import com.chinasoft.app.entiy.Orders;
import com.chinasoft.app.entiy.User;
import com.chinasoft.app.po.Cart;
import com.chinasoft.app.po.CartItem;
import com.chinasoft.app.service.OrderService;
import com.chinasoft.app.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class CreatOrderServlet
 */
public class CreatOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		Date date=new Date();
		float money=Float.parseFloat(request.getParameter("money"));
		Orders orders=new Orders();
		orders.setMoney(money);
		orders.setAddress(address);
		orders.setOrderTime(date);
		orders.setPhone(phone);
		orders.setRename(username);
		orders.setState("1");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		orders.setUser(user);
		List<OrderItem> list=new ArrayList<OrderItem>();
		Cart cart=(Cart) session.getAttribute("cart");
		for(CartItem cartItem:cart.getMycart().values()){
			OrderItem oi=new OrderItem();
			oi.setProduct(cartItem.getProduct());
			oi.setNum(cartItem.getTotalnum());
			oi.setOrders(orders);
			list.add(oi);
		}
		orders.setOrderItems(list);
		String oid = (String)session.getAttribute("orderId");
		orders.setOid(oid);
		
		OrderService os = new OrderServiceImpl();
		os.addOrders(orders);
		response.sendRedirect("pay.jsp");
	}

}
