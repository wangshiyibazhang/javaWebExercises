package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.WebUtils;

import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;

import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class listCustomer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			BusinessService service = new BusinessServiceImpl();
			QueryInfo info = WebUtils.requestToBean(request, QueryInfo.class);
			PageBean pagebean = service.pageQuery(info);
			request.setAttribute("pagebean",pagebean);
			request.getRequestDispatcher("/jsp/listCustomer.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("messages","查看客户失败！！！");
			request.getRequestDispatcher("/messages.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}

}
