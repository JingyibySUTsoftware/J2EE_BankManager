package com.yy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;
@WebServlet("/deletebycid")
public class DeleteCardBycidServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankService bankService = new BankServiceImpl();
		long cid=Integer.valueOf(req.getParameter("cid"));
		boolean flag=bankService.DeleteBycid(cid);
		if(flag) {
			resp.sendRedirect("findallcard");
		}else {
			resp.sendRedirect("jsp/deletecardError.jsp");
		}
	}
	
}
