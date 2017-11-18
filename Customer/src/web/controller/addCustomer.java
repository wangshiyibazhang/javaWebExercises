package web.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import service.BusinessService;
import service.impl.BusinessServiceImpl;

import domain.Customer;

import Utils.WebUtils;

public class addCustomer extends HttpServlet {
	
	//ͨ在a标记中的内容提交时时默认的以GET方式提交，表单中的内容可以设置为post方式提交
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("genders",Utils.Gloable.genders);
		request.setAttribute("preferences",Utils.Gloable.preferences );
		request.setAttribute("types",Utils.Gloable.types);
		request.getRequestDispatcher("/jsp/addCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			//表单校验
			//ConvertUtils.register(new DateLocaleConverter(), Date.class);
			Customer c = WebUtils.requestToBean(request, Customer.class);
			c.setId(WebUtils.getID());
			
			BusinessService  service = new BusinessServiceImpl();
			service.addCustomer(c);
			request.setAttribute("messages","添加成功！");
		} catch (Exception e) {
			request.setAttribute("messages","添加用户失败，请检查用户信息！" );
		}
		
		request.getRequestDispatcher("/messages.jsp").forward(request, response);
		
	}

}
