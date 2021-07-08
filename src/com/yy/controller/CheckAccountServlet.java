package com.yy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.bean.BankCard;
import com.yy.bean.BankManager;
import com.yy.service.BankService;
import com.yy.service.Impl.BankServiceImpl;

@WebServlet("/checkaccount")
public class CheckAccountServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BankService bankService = new BankServiceImpl();
		BankManager bankManager = new BankManager();
		BankCard card = new BankCard();
		HttpSession session = req.getSession();
		if(req.getParameter("mid")!=null) {//管理员登录验证
			bankManager.setMid(Integer.valueOf(req.getParameter("mid")));
			bankManager.setMpass(req.getParameter("mpass"));
			BankManager manager=bankService.FindBankManager(bankManager);
			if(manager.getMname()!=null) {//管理员角色存在
				req.setAttribute("manager", manager);
				session.setAttribute("mname",manager.getMname());//设置session属性
				req.getRequestDispatcher("WEB-INF/jsp/AdminMain.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("jsp/loginError.jsp");
			}
		}else {//普通用户登录验证
			card.setCid(Long.valueOf(req.getParameter("cid")));
			card.setCpssword(Integer.valueOf(req.getParameter("cpassword")));		
			session.setAttribute("cid", Long.valueOf(req.getParameter("cid")));
			session.setAttribute("cpassword", Integer.valueOf(req.getParameter("cpassword")));
			BankCard bankcard=bankService.FindCardByidAndpwd(card);
			if(bankcard.getBankuser().getUname()!=null) {//如果用户存在
				session.setAttribute("uname",bankcard.getBankuser().getUname());//设置session属性
				req.setAttribute("bankcard", bankcard);
				req.getRequestDispatcher("WEB-INF/jsp/UserMain.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("jsp/loginError.jsp");
			}
		}
		
		
	}

}
