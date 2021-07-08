package com.yy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.bean.BankUser;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;

@WebServlet("/updatebyuid")
public class UpdateUserByuidServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BankService bankService = new BankServiceImpl();
		BankUser user=new BankUser();
		user.setUid(Integer.valueOf(req.getParameter("uid")));
		user.setUname(req.getParameter("uname"));
		user.setUphone(Integer.valueOf(req.getParameter("uphone")));
		user.setCompany(req.getParameter("company"));
		user.setHometown(req.getParameter("hometown"));
		boolean flag=bankService.UpdateUserByuid(user);
		if(flag) {
			if(flag) {
				resp.sendRedirect("findalluser");
			}else {
				resp.sendRedirect("jsp/updateError.jsp");
			}
		}
	}
	
}
