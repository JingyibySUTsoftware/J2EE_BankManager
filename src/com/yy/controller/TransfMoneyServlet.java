package com.yy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;
@WebServlet("/transfmoney")
public class TransfMoneyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankService bankService = new BankServiceImpl();
		HttpSession session = req.getSession();
		double money=Double.valueOf(req.getParameter("money"));
		long tocid=Long.valueOf(req.getParameter("tocid"));
		long cid=(long)session.getAttribute("cid");
		boolean flag=bankService.TransfMoney(money,cid,tocid);
		if(flag) {
			resp.sendRedirect("totransf");
		}else {
			resp.sendRedirect("jsp/transfmoneyError.jsp");
		}
		
	}
}
