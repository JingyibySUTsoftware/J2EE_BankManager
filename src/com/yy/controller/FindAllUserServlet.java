package com.yy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.bean.BankUser;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;

@WebServlet("/findalluser")
public class FindAllUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankService bankService = new BankServiceImpl();
		List<BankUser> list=bankService.FindAllUser();
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/jsp/ShowUser.jsp").forward(req, resp);
		
	}
	
}
