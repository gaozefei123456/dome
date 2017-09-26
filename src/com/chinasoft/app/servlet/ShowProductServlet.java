package com.chinasoft.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.app.entiy.Product;
import com.chinasoft.app.po.PageModel;
import com.chinasoft.app.po.ProductPage;
import com.chinasoft.app.service.ProductService;
import com.chinasoft.app.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ShowProductServlet
 */
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
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
		
		ProductService ps=new ProductServiceImpl();
		//ArrayList<Product> list=(ArrayList<Product>) ps.findAll();
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageSize=10;
		PageModel<Product> productPage=new PageModel<Product>();
		productPage.setCurrentPage(currentPage);
		productPage.setList(ps.findAlltonum(currentPage, pageSize));
		int totalCount=ps.findAll().size();
		productPage.setTotalCount(totalCount);
		int totalPage=(totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
		productPage.setTotalPage(totalPage);
		productPage.setPageSize(pageSize);
	    request.setAttribute("productPage", productPage);
	    request.getRequestDispatcher("showproduct.jsp").forward(request, response);
	}

}
