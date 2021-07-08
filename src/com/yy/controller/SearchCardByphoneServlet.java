package com.yy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.bean.BankCard;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;

@WebServlet("/tosearch")
public class SearchCardByphoneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankService bankService = new BankServiceImpl();
		int phone=Integer.valueOf(req.getParameter("phone"));
		List<BankCard> list=bankService.SearchCardByphone(phone);
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/jsp/ShowCard.jsp").forward(req, resp);
	}
	
}