package com.yy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.bean.BankCard;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;
@WebServlet("/setmoney")
public class SetMoneyservlet extends HttpServlet {
	
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
		long cid=(long)session.getAttribute("cid");
		bankService.SetMoney(money,cid);
		resp.sendRedirect("tosetmoney");
	}
}
