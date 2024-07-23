package it.eng.allerter.allerta;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	        "osgi.http.whiteboard.servlet.pattern=/allerta-img"
	    },
	    service = Servlet.class
	)
public class ImageServlet extends HttpServlet {
	
	static String areeNuove[] =
		{"A1","A2","B1","B2","C1","C2","D1","D2","D3","E1","E2","F1","F2","F3","G1","G2","H1","H2"};
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("tipo");
			String param = req.getParameter("param");
			String w = req.getParameter("w");
			String h = req.getParameter("h");
			int width = Integer.parseInt(w);
			int height = Integer.parseInt(h);
			BufferedImage bi = null;
			
			if (id==null) {
				resp.setStatus(404);
				return;
			}
			
			if (param==null) {
				resp.setStatus(404);
				return;
			}
			
			if (param.length()==2) {
				//contiene solo le zone costiere B2 e D2, aggiungi le altre
				param = "XXX"+param.charAt(0)+"XXX"+param.charAt(1)+"XXXXXXXXXX";
			}
			
			if (id.equals("zone")) {
				bi = getMappaStati(param, width, height);
			}
			
			if (id.equals("zoneNomi")) {
				bi = getMappaStatiNomi(param, width, height);
			}
			
			if (bi!=null) {
				resp.setContentType("image/png");
				ImageIO.write(bi, "PNG", resp.getOutputStream());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private BufferedImage getMappaStati(String param, int w, int h) {
		int stati[] = new int[param.length()];
		
		for (int k=0; k<stati.length; k++) {
			char c = param.charAt(k);
			switch (c) {
			case 'V': stati[k] = 0; break;
			case 'G': stati[k] = 1; break;
			case 'A': stati[k] = 2; break;
			case 'R': stati[k] = 3; break;
			
			case '0': stati[k] = 0; break;
			case '1': stati[k] = 1; break;
			case '2': stati[k] = 2; break;
			case '3': stati[k] = 3; break;
			
			
			case 'X': stati[k] = -1; break;
			default: stati[k] = -1;
			}

		}
		
		return ImageUtility.makeMappaAreeNuoveNoTesto(stati, w, h, areeNuove);
	}
	
	private BufferedImage getMappaStatiNomi(String param, int w, int h) {
		int stati[] = new int[param.length()];
		
		for (int k=0; k<stati.length; k++) {
			char c = param.charAt(k);
			switch (c) {
			case 'V': stati[k] = 0; break;
			case 'G': stati[k] = 1; break;
			case 'A': stati[k] = 2; break;
			case 'R': stati[k] = 3; break;
			case 'X': stati[k] = -1; break;
			
			case '0': stati[k] = 0; break;
			case '1': stati[k] = 1; break;
			case '2': stati[k] = 2; break;
			case '3': stati[k] = 3; break;
			
			default: stati[k] = -1;
			}

		}
		
		return ImageUtility.makeMappaAreeNuove(stati, w, h, areeNuove);
	}

}
