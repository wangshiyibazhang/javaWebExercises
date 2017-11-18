package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;
import service.impl.BusinessServiceImpl;
//删除客户
public class deleteCustomer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		try {
			BusinessService service = new BusinessServiceImpl();
			String id = request.getParameter("id");
			//sString id = (String) request.getAttribute("id");
			service.deleteCustomer(id);
			request.setAttribute("messages", "删除用户成功！");
		} catch (Exception e) {
			request.setAttribute("messages","删除用户失败！");
		}
		request.getRequestDispatcher("/messages.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
