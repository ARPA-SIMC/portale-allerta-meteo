package it.eng.allerter.allerta;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/api/heartbeat/*"
	    },
	    service = Servlet.class
	)
public class HeartbeatServlet extends HttpServlet {
	
	//private Log logger = LogFactoryUtil.getLog(EmailPDFServlet.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5671481737513250320L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

	}
}
