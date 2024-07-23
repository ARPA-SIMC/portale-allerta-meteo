package it.eng.allerta.messages.services.servletWS;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter(filterName="ServletFilterWS", urlPatterns={"/ServletRestWS/*"}, displayName="FilterRestWS", description = "Filter authentication")
public class ServletFilter implements Filter {
	
	private static Log _log = LogFactoryUtil.getLog(ServletFilter.class);

	private String realm = "Protected";
	
	/**
	 * Default constructor. 
	 */
	public ServletFilter() {
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
		String ip = servletRequest.getRemoteAddr();
		String token = (String) servletRequest.getParameter("token");
		
		_log.debug("token: "+token);
        
		if(!token.equals("XG8ub2SNXoil5LWmdWUu")){
			_log.warn("Accesso non autorizzato da ip: " + ip);
			unauthorized(response, "Invalid authentication token");
		}else{
			_log.info("Accesso autorizzato da ip: " + ip);
			chain.doFilter(request, response);
		}
	}

	private void unauthorized(HttpServletResponse response, String message) throws IOException {
		response.setHeader("WWW-Authenticate", "Basic realm=\"" + realm + "\"");
		response.sendError(401, message);
	}
}

