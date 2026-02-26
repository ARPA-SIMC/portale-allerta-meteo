package it.eng.allerter.allerta;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = "osgi.http.whiteboard.servlet.pattern=/delArticle",
	    service = Servlet.class
	)
public class DeleteContentServlet  extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2782609832922640930L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/javascript");
		
		String ida = req.getParameter("id");
		Long id = Long.parseLong(ida);
		JournalArticle ja = JournalArticleLocalServiceUtil.fetchArticle(id);
		
		String out = "{}";
		try {
			JournalArticleLocalServiceUtil.moveArticleToTrash(20198L, ja);

		} catch (Exception e) {
			out = "{\"error\":\""+e.getMessage()+"\"}";
		}
		
		
		
		resp.setContentLength(out.length());
	
		
		resp.getOutputStream().write(out.getBytes());
		
	}
	
	

}
