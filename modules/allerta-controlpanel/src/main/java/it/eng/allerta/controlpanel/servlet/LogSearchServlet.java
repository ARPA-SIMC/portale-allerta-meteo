package it.eng.allerta.controlpanel.servlet;

import com.liferay.portal.kernel.util.PortalUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(
	    property = "osgi.http.whiteboard.servlet.pattern=/log-servlet",
	    service = Servlet.class
	)
public class LogSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7375290050332226052L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			String cmd = req.getParameter("cmd");
			String p1 = req.getParameter("p1");
			String p2 = req.getParameter("p2");
			String p3 = req.getParameter("p3");
			
			if (cmd==null) {
				resp.setStatus(404);
				return;
			}
			
			resp.setStatus(200);
			String result = doCommand(cmd,p1,p2,p3);
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setContentType("text/html");
			
			ByteBuffer bb = Charset.forName("UTF-8").encode(result);
			byte[] ba = new byte[bb.remaining()];
			
			resp.setContentLength(ba.length);
			
			bb.get(ba);
			
			resp.getOutputStream().write(ba);
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("LogSearchServlet", "doGet", e, "");
		}
	}
	
	public static String doCommand(String cmd, String p1, String p2, String p3) throws Exception {
		
		String command = null;
		
		String LOG_PATH = getHome();
		
		if ("grep".equals(cmd)) {
			command = "/bin/grep "+p2+" "+LOG_PATH+"logs/liferay."+p1+".log";
		}
		
		if ("sed".equals(cmd)) {
			command = "/bin/sed -n -e "+p2+","+p3+"p "+LOG_PATH+"logs/liferay."+p1+".log";
		}
		
		if (command!=null) {
			return execute(command);
		}
		
		if ("ls".equals(cmd)) {
			String output = "";
			File f = new File(LOG_PATH+"logs");
			if (f.exists() && f.isDirectory()) {
				String[] sss = f.list();
				for (String s : sss) {
					if (s.contains(".log")) {
						if (!"".equals(output)) output+=",";
						output+=s;
					}
				} 
				return output;
			} else if (!f.exists()) return f.getAbsolutePath()+" non esiste";
			else if (!f.isDirectory()) return f.getAbsolutePath()+ " non directory";
		}
		
		if ("rm".equals(cmd)) {
			int deleted = 0;
			File f = new File(LOG_PATH+"logs");
			if (f.exists() && f.isDirectory()) {
				String[] sss = f.list();
				for (String s : sss) {
					if (s.contains(".log") || s.contains(".xml")  || s.contains(".zip")   || s.contains(".tar")) {
						File ff = new File(f,s);
						if (ff!=null && ff.exists() && !ff.isDirectory()) {
							BasicFileAttributes bfa = Files.readAttributes(ff.toPath(), BasicFileAttributes.class);
							FileTime fileTime = bfa.lastModifiedTime();
							long quando = new Date().getTime()-fileTime.toMillis();
							if (quando>7*24*3600*1000) {
								//non toccato da almeno una settimana
								System.out.println("Elimino file log "+s);
								ff.delete();
								deleted++;
							}
						}
						
					}
				} 
				return "Cancellati "+deleted+" file.";
			} else if (!f.exists()) return f.getAbsolutePath()+" non esiste";
			else if (!f.isDirectory()) return f.getAbsolutePath()+ " non directory";
		}
		
		if ("dpl".equals(cmd)) {
			File fil = new File(p1);
			for (int k=0; k<5; k++) {
				if (!fil.exists()) Thread.sleep(2000); //aspetta sincronizzazione share rete
			}
			if (fil.exists()) {
				File destination = new File(getHome()+"deploy"+File.separator+fil.getName());
				Files.move(fil.toPath(), destination.toPath(), StandardCopyOption.ATOMIC_MOVE);
				return "File "+fil.getName()+" deployato.";
			} else return "File "+fil.getName()+" non esiste.";
		}
		
		return "";
	}
	
	public static String doCommandOnNode(String node, String cmd, String p1, String p2, String p3) {
		
		try {
			String url = "http://"+node+".ente.regione.emr.it:8080/o/log-servlet?cmd="+cmd;
			if (p1!=null) url+="&p1="+p1;
			if (p2!=null) url+="&p2="+p2;
			if (p3!=null) url+="&p3="+p3;
			
			URL oracle = new URL(url);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));
	
	        String output = "";
	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            output+=inputLine+"\n";
	        in.close();
	        
			return output;
		
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("LogSearchServlet", "doCommandOnNode", e, "");
			return "";
		}
	}
	
	public static String execute(String input) throws Exception {
		
		String output = "";
		Process p = Runtime.getRuntime().exec(input);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line= reader.readLine()) != null) {
			output+=line+"\n";
		}
		reader.close();
		
		reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String error="";
		while ((line= reader.readLine()) != null) {
			error+=line+"\n";
		}
		reader.close();
		if (!error.equals("")) throw new Exception(error);
		return output;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	private static String getHome() {
		return PortalUtil.getPortal().getPortalProperties().getProperty("liferay.home")+File.separator;
	}
}
