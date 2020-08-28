package it.eng.allerta.utils;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.RenderResponseWrapper;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portal.kernel.util.PortletKeys;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + "com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet"
	},
	service = PortletFilter.class
)
/**
 * Filtra la portlet dei blog per intercettare il contenuto e cancellare il nome dell'autore.
 * Perché a quanto pare questo è il modo consigliato - nel 2020 - per modificare
 * le JSP di Liferay.
 * @author GFavini
 *
 */
public class BlogsRenderFilter implements RenderFilter {
	
	public class BufferedRenderResponseWrapper extends RenderResponseWrapper {

		public BufferedRenderResponseWrapper(RenderResponse response) {
			super(response);

			charWriter = new CharArrayWriter();
		}

		public OutputStream getOutputStream() throws IOException {
			if (getWriterCalled) {
				throw new IllegalStateException("getWriter already called");
			}

			getOutputStreamCalled = true;

			return super.getPortletOutputStream();
		}

		public PrintWriter getWriter() throws IOException {
			if (writer != null) {
				return writer;
			}

			if (getOutputStreamCalled) {
				throw new IllegalStateException("getOutputStream already called");
			}

			getWriterCalled = true;

			writer = new PrintWriter(charWriter);

			return writer;
		}

		public String toString() {
			String s = null;

			if (writer != null) {
				s = charWriter.toString();
			}

			return s;
		}

		protected CharArrayWriter charWriter;
		protected PrintWriter writer;
		protected boolean getOutputStreamCalled;
		protected boolean getWriterCalled;

	}

	@Override
	public void init(FilterConfig config) throws PortletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
			throws IOException, PortletException {
		
		String url = (String)request.getAttribute("CURRENT_COMPLETE_URL");
		boolean filtra = !url.contains("report-post-evento")
				&& (url.contains("blog/id/") || url.contains("content/id/"));
		
		if (!filtra) {
			chain.doFilter(request, response);
			return;
		}
		
		/*
		
		Enumeration<String> s = request.getAttributeNames();
		while (s.hasMoreElements()) {
			String at = s.nextElement();
			Object oo = request.getAttribute(at);
			if (oo!=null) System.out.println(at+"->"+oo.toString());
		}*/
		
		RenderResponseWrapper renderResponseWrapper = new BufferedRenderResponseWrapper(response);

		chain.doFilter(request, renderResponseWrapper);

		String text = renderResponseWrapper.toString();
		
		if (url.contains("blog/id/")) {
			try {
				String blogId = url.substring(url.indexOf("blog/id/")+8);
				if (blogId.contains("?")) blogId = blogId.substring(0,blogId.indexOf("?"));
				Long id = Long.parseLong(blogId);
				AssetEntry ae = AssetEntryLocalServiceUtil.fetchAssetEntry(id);
				BlogsEntry be = BlogsEntryLocalServiceUtil.fetchBlogsEntry(ae.getClassPK());
				String subtitle = be.getSubtitle();
				if (subtitle!=null) {
					String interestingText = "<h4 class=\"component-title";
					int index = text.lastIndexOf(interestingText);

					if (index >= 0) {
						int index2 = text.indexOf("</h4>", index)+5;
						String subtitleAddition = "<h5>"+subtitle+"</h5>";
						text = text.substring(0,index2)+subtitleAddition+
								text.substring(index2);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (text != null) {
			String interestingText = "<span class=\"text-truncate user-info";

			int index = text.lastIndexOf(interestingText);

			if (index >= 0) {
				
				int index2 = text.indexOf("</span>", index);
				String newText1 = text.substring(0, index);
				String newText3 = text.substring(index2+7);
				
				String newText = newText1 + newText3;
				
				response.getWriter().write(newText);
			} else response.getWriter().write(text);
		}
	}

}
