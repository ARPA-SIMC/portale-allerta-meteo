package allerta.url.hook;

import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class UrlHook implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//PortalUtil.getOriginalServletRequest(request);
		
		String completeUrl = request.getAttribute("CURRENT_COMPLETE_URL").toString().toLowerCase();
		
		//boolean check = !request.getServerName().toLowerCase().startsWith("allertameteo.");
		boolean check = !completeUrl.contains("allertameteo.") && !completeUrl.contains("control_panel") && !completeUrl.contains("update_password") && !completeUrl.contains("/o/");
		
		if (!check) {
			chain.doFilter(request, response);
			return;
		}
		
		Object o = request.getAttribute("USER_ID");
		
		if (o!=null) {
			chain.doFilter(request, response);
			return;
		}
		
		o = request.getAttribute("USER");
		
		if (o!=null) {
			chain.doFilter(request, response);
			return;
		}
		
		if (completeUrl.contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		
		Enumeration<String> s = request.getAttributeNames();
		while (s.hasMoreElements()) {
			String en = s.nextElement();
			System.out.println("Param "+en+" -> "+request.getAttribute(en).toString());
		
			if ("com.liferay.portal.kernel.util.CookieKeys".equals(en)) {
				
			}
		}
		
		String uri = (String)request.getAttribute(WebKeys.INVOKER_FILTER_URI);
		System.out.println("Invocato su "+uri+", server "+request.getServerName());
		
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/login");
		
		
		
	}

	@Override
	public void destroy() {
		
	}

}
