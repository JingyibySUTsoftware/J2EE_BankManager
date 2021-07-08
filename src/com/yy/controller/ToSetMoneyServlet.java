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

@WebServlet("/tosetmoney")
public class ToSetMoneyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankService bankService = new BankServiceImpl();
		BankCard card = new BankCard();
		HttpSession session = req.getSession();
		card.setCid((long)session.getAttribute("cid"));
		card.setCpssword((int)session.getAttribute("cpassword"));
		BankCard bankcard=bankService.FindCardByidAndpwd(card);
		int phone=bankcard.getBankuser().getUphone();
		List<BankCard> list=bankService.SearchCardByphone(phone);
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/jsp/SetMoneyPage.jsp").forward(req, resp);
	}
	
}
