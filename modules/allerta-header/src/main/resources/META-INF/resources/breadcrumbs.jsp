<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.theme.NavItem"%>
<%@ include file="./init.jsp" %>

<%
List<NavItem> navItems = (List<NavItem>) renderRequest.getAttribute("navItems");
String siteUrl = (String)renderRequest.getAttribute("siteUrl");
String siteName = (String)renderRequest.getAttribute("siteName");
%>


<!-- # sezioni/layout/breadcrumb -->
  <div class="breadcrumb-container">
    <div class="container d-flex">
        <nav class="row" aria-label="Hai percorso">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/">Home</a>
                </li>
                
                <% if (siteUrl!=null) {
                	%> <li class="breadcrumb-item">
                    		<a href="<%=siteUrl%>"><%=siteName%></a>
                		</li> 
                	<%
                }
                	%>
                

<%for(NavItem n: navItems) {

	if( navItems.indexOf(n) != (navItems.size() -1)  ) {%> 
		      <li class="breadcrumb-item ">
		          <a href="<%=n.getURL()%>">
		          		<%=n.getName() %>
		          </a>
		      </li>
<%	} else {%>
			<li class="breadcrumb-item active" aria-current="page"><%=n.getName() %></li>
<%  }
}%>
                

            </ol>
        </nav>
    </div>
</div><!-- / sezioni/layout/breadcrumb -->