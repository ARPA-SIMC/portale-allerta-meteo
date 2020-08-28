package it.eng.allerter.allerta;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.eng.allerter.service.LogInternoLocalServiceUtil;

public class SMSSimulationServlet extends HttpServlet {
	
	public class SocketThread implements Runnable {
		
		
		
		

		@Override
		public void run() {}
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	public void destroy() {}
	
	@Override
	public void init(ServletConfig config) throws ServletException {}

}
