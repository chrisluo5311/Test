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


@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     CancerBean cancerbean = new CancerBean();
	     CancerDAOImpl dao = new CancerDAOImpl();
	     List<CancerBean> canr = dao.findAllCancer();
	     int result = dao.downloadfile(canr);
	     cancerbean.setCount(result);
	     request.setAttribute("downloadcount", cancerbean);
	     request.getRequestDispatcher("/GellAllCancerData").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
