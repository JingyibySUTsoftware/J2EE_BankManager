package com.yy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.bean.BankCard;
import com.yy.bean.BankUser;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;
@WebServlet("/addcard")
public class AddCardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BankService bankService = new BankServiceImpl();
		BankCard card=new BankCard();
		BankUser user = new BankUser();
		card.setBankuser(user);
		card.setCpssword(Integer.valueOf(req.getParameter("password")));
		card.setCmoney(Double.valueOf(req.getParameter("cmoney")));
		card.setCtype(req.getParameter("ctype"));
		card.getBankuser().setUid(Integer.valueOf(req.getParameter("ID")));
		boolean flag=bankService.AddCard(card);
		if(flag) {
			if(flag) {
				resp.sendRedirect("toaddcard");
			}else {
				resp.sendRedirect("jsp/addcardError.jsp");
			}
		}
	}
}
