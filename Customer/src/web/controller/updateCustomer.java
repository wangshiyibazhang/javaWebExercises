package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.WebUtils;

import domain.Customer;

import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class updateCustomer extends HttpServlet {
	private String id;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		id = request.getParameter("id");
		request.setAttribute("genders",Utils.Gloable.genders);
		request.setAttribute("preferences",Utils.Gloable.preferences );
		request.setAttribute("types",Utils.Gloable.types);
		request.getRequestDispatcher("/jsp/updataCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		try {	
			BusinessService service = new BusinessServiceImpl();
			Customer newCustomer = WebUtils.requestToBean(request, Customer.class);
			newCustomer.setId(id);
			//提供一个修改后的 用户给原来的用户使用
			service.updataCustomer(newCustomer);
			request.setAttribute("messages","修改用户信息成功！");
		} catch (Exception e) {
			request.setAttribute("messages","修改用户信息失败！");
		}
		request.getRequestDispatcher("/messages.jsp").forward(request, response);
	}

}
