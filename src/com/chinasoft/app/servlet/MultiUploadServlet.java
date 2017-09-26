package com.chinasoft.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class MultiUploadServlet
 */
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
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
		SmartUpload su=new SmartUpload("utf-8");
		su.initialize(getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,png,gif");
		su.setMaxFileSize(1000*1024);
        String servletName=null;
        String servletPath=null;
		try {
			su.upload();
			for(int i=0;i<su.getFiles().getCount();i++){
			SmartFile smartFile=su.getFiles().getFile(i);
			DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSS");
			Random random=new Random();
			int num=random.nextInt(900)+100;
			String servletExt=smartFile.getFileExt();
			servletName=df.format(new Date())+num+"."+servletExt;
			servletPath=request.getRealPath("/")+"upload";
			smartFile.saveAs(servletPath+"/"+servletName);
			out.print("<script>alert('上传成功');location='multiupload.jsp'</script>");
			
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("<script>alert('上传失败');location='multiupload.jsp'</script>");
		} catch (SecurityException e){
			e.printStackTrace();
			out.print("<script>alert('上传文件不能超过100k,而且只能上传jpg,gif.png文件')</script>");
		}
	}

}
