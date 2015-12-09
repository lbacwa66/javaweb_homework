package com.stu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.CommentCtrl;
import com.stu.model.Account;
import com.stu.model.Comment;

import javax.servlet.http.Part;

/**
 * Servlet implementation class AddComment
 */
@MultipartConfig
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
		HttpSession session = request.getSession();
		System.out.println("AddComment : " + request.getParameter("post_id"));
		
		Account account = (Account)session.getAttribute("account");
		
		if("on".equals(request.getParameter("anonymous"))) {
//			account.setUsername("匿名");
			account.setUser_id(1);
		}
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String content = request.getParameter("content");
		Comment comment = new Comment();
		comment.setComment_date(new Date());
		comment.setContent(content);
		comment.setPost_id(post_id);
		System.out.println("AddComment : " + ((Account)session.getAttribute("account")).getUser_id());
		comment.setUser_id(account.getUser_id());
		
		comment.setPicture_id(updatePicture(request, response));
		
		CommentCtrl.addComment(comment);
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected int updatePicture(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException {
        //存储路径
        String savePath = getServletContext().getRealPath("");
        System.out.println("AddComment: "+savePath);
        //获取上传的文件集合
        Collection<Part> parts = request.getParts();
        
        System.out.println("AddComment: "+ parts.size());
        
        if (parts.size() == 0) {
        	return -1;
        } else {
            //Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
           //Part part = parts[0];//从上传的文件集合中获取Part对象
//           Part part = request.getPart("file");//通过表单file控件(<insput type="file" name="file">)的名字直接获取Part对象
           //Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
           //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
//           String header = part.getHeader("content-disposition");
           //获取文件名
           int pid = CommentCtrl.newPicId();
           String fileName = pid + ".jpg";
           //一次性上传多个文件
           for (Part part : parts) {//循环处理上传的文件
               //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
               String header = part.getHeader("content-disposition");
               //获取文件名
               //把文件写到指定路径
               part.write(savePath+File.separator+fileName);
           }
           //把文件写到指定路径
          // part.write(savePath+File.separator+fileName);
           return pid;
        }
//       }else {
//           //一次性上传多个文件
//           for (Part part : parts) {//循环处理上传的文件
//               //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
//               String header = part.getHeader("content-disposition");
//               //获取文件名
//               String fileName = getFileName(header);
//               //把文件写到指定路径
//               part.write(savePath+File.separator+fileName);
//           }
//       }
		//return -1;
	}

}
