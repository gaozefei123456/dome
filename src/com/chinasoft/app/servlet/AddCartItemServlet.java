package com.chinasoft.app.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.app.entiy.Product;
import com.chinasoft.app.po.Cart;
import com.chinasoft.app.po.CartItem;
import com.chinasoft.app.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddCartItemServlet
 */
public class AddCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartItemServlet() {
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
		int pid=Integer.parseInt(request.getParameter("pid"));
		HttpSession session = request.getSession();
		//将购物车存到session中
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
		}
		//生成一个全球唯一的oid
		if(session.getAttribute("orderId")==null){
			String orderId=UUID.randomUUID().toString();
			session.setAttribute("orderId", orderId);
		}
		CartItem cartItem=new CartItem();
		ProductServiceImpl psi = new ProductServiceImpl();
		Product p=psi.findById(pid);
		cartItem.setProduct(p);
		cartItem.setTotalnum(1);
		cart.addCartItem(cartItem);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
		
		
	
	}

}
