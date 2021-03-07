package com.chrisproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chrisproject.Bean.CancerBean;
import com.chrisproject.Dao.CancerDAOImpl;


@WebServlet("/InsertCancerData")
public class InsertCancerData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    CancerBean cancerbean = new CancerBean();
	    String cno = request.getParameter("cno");
		String cyear = request.getParameter("cyear");
		String ccause = request.getParameter("ccause");
		String crank = request.getParameter("crank");
		String cdeatotal = request.getParameter("cdeatotal");
		String cdeathman = request.getParameter("cdeathman");
		String cdeathwoman = request.getParameter("cdeathwoman");
		String cdeathrate = request.getParameter("cdeathrate");
		String cdeathrateman = request.getParameter("cdeathrateman");
		String cdeathratewoman = request.getParameter("cdeathratewoman");
		
		cancerbean.setCanno(cno);
		cancerbean.setYear(cyear);
		cancerbean.setCauseOfDeath(ccause);
		cancerbean.setRank(crank);
		cancerbean.setDeathTotal(cdeatotal);
		cancerbean.setDeathMan(cdeathman);
		cancerbean.setDeathWoman(cdeathwoman);
		cancerbean.setDeathRate(cdeathrate);
		cancerbean.setDeathRateMan(cdeathrateman);
		cancerbean.setDeathRateWoman(cdeathratewoman);
		
	    CancerDAOImpl dao = new CancerDAOImpl();
		dao.addCancer(cancerbean);
		request.getRequestDispatcher("/GellAllCancerData").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
