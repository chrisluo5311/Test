package com.chrisproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chrisproject.Bean.CancerBean;
import com.chrisproject.Dao.CancerDAOImpl;


@WebServlet("/GellAllCancerData")
public class GellAllCancerData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     CancerDAOImpl dao = new CancerDAOImpl();
	     List<CancerBean> canr = dao.findAllCancer();
	     request.setAttribute("queryResult", canr);
	     request.getRequestDispatcher("/com.chrisproject.Jsp/query.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
