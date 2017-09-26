package com.chinasoft.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;











import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.app.service.impl.ProductServiceImpl;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		PrintWriter out=response.getWriter();
		//String pname=request.getParameter("pname");
		//创建smartUpload对象
		SmartUpload su=new SmartUpload("utf-8");
		//初始化
		
		su.initialize(getServletConfig(), request, response);
		//设置上传类型
		su.setAllowedFilesList("jpg,gif.png");
		//设置上传大小为100k
		su.setMaxFileSize(1000*1024);
		
		try {
			//上传临时文件
			su.upload();
			
			//提取上传文件
			SmartFile smartfile=su.getFiles().getFile(0);
			//提取尾巴
			String servletExt=smartfile.getFileExt();
			//准备上传路径
			String servletPath=request.getRealPath("/")+"upload";
			//判断文件是否提取成功
			if(!smartfile.isMissing()){
				DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSS");
				String now=df.format(new Date());
				String servletFileName=now+"."+servletExt;
				smartfile.saveAs(servletPath+"/"+servletFileName);
				String pname=su.getRequest().getParameter("pname");
				Double price=Double.parseDouble(su.getRequest().getParameter("price"));
				int num=Integer.parseInt(su.getRequest().getParameter("num"));
				String pic=su.getRequest().getParameter("pic");
				ProductServiceImpl psi=new ProductServiceImpl();
				if(psi.addProduct(pname, price, num, servletFileName)){
					out.print("添加成功");
				}else{
					out.print("添加失败");
				}
				out.print("<script>alert('上传成功');location='addproduct.jsp'</script>");
			}else{
				out.print("<script>alert('必须上传图片，才能上传');location='addproduct.jsp'</script>");
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
			out.print("<script>alert('上传失败');location='addproduct.jsp'</script>");
		} catch (SecurityException e){
			e.printStackTrace();
			out.print("<script>alert('上传文件不能超过100k,而且只能上传jpg,gif.png文件')</script>");
		}
		
	}

}
