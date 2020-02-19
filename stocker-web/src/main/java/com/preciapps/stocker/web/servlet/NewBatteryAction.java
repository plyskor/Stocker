package com.preciapps.stocker.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.preciapps.stocker.dao.service.inter.BatteryServiceInterface;
import com.preciapps.stocker.model.Battery;
import com.preciapps.stocker.model.StandardBattery;

/**
 * Servlet implementation class NewBatteryAction
 */
public class NewBatteryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BatteryServiceInterface bServ;  

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBatteryAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		AnnotationConfigApplicationContext springContext= (AnnotationConfigApplicationContext) context.getAttribute("springContext");
        
		bServ= springContext.getBean(BatteryServiceInterface.class);
		Battery b = new StandardBattery(request.getParameter("capacity"),request.getParameter("resistance"),request.getParameter("leakage"),request.getParameter("ocv"),request.getParameter("brand"),request.getParameter("structure"),request.getParameter("message"),request.getParameter("stage"),request.getParameter("serial"));
		bServ.persist(b);
		doGet(request, response);
	}

}
