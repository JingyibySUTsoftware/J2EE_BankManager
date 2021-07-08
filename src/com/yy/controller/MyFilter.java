package com.yy.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String uri=req.getRequestURI();
		if(uri.endsWith("Login.jsp")||uri.endsWith("login")||uri.endsWith("checkaccount")||uri.contains(".css") || uri.contains(".js") || uri.contains(".png")|| uri.contains(".jpg")) {//���Ϊ��¼����
			chain.doFilter(request, response);
		}else {//����ȥ��¼ҳ����¼����
			String uname=(String)req.getSession().getAttribute("uname");
			String mname=(String)req.getSession().getAttribute("mname");
			if(uname!=null||mname!=null) {//����Ա�����û��ѵ�¼
				chain.doFilter(request, response);
			}else{
				req.getSession().setAttribute("Needloginmsg", "something");
				resp.sendRedirect("Login.jsp");			
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

}
