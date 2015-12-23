package com.stu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.AccountCtrl;
import com.stu.model.Account;

/**
 * Servlet implementation class Modify
 */
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		String newpwd = req.getParameter("newpwd");
		Account account = AccountCtrl.getAccountByName(username);
		account.setPwd(pwd);
		// 用户名存在
		if(AccountCtrl.isAccountNameExist(account)) {
			if (!AccountCtrl.checkAccount(account)) {
				session.setAttribute("info", "The old password is wrong");
				resp.sendRedirect("info.jsp");
			} else {
				account.setPwd(newpwd);
				AccountCtrl.changePwd(account);
				session.setAttribute("info", "Success");
				resp.sendRedirect("info.jsp");
			}
		} else {
			session.setAttribute("info", "The username doesn\'t exist");
			resp.sendRedirect("info.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
