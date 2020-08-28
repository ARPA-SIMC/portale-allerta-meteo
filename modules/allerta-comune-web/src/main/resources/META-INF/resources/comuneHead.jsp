<%@page import="java.io.Serializable"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>

<%@ include file="./init.jsp"%>

<%
	Group site = themeDisplay.getSiteGroup();
	String comune = site.getName();
	
	String area = "";
	Map<String, Serializable> expandoAttribs =  null;
	if(site != null) {
		expandoAttribs=  site.getExpandoBridge().getAttributes();
		area = (String) expandoAttribs.get("Area");
	}
%>

<div class="page--comune">	
 <div class="page__head">
	<div class="container-fluid c-lg-container d-flex">
		<div class="row w-100 justify-content-between">
	        <div class="col-10 col-lg-8 d-flex  ">
	            <div class="page__head__icon icon i-map-marker" title="Icona per Luogo"></div>
	            <div>
	                <h1><%=comune %></h1>
	                <p class="col-12 lead">
	                    Area di allertamento <%=area%>
	                </p>
	            </div>
	        </div>
                            

            <div class="d-flex page-tools" role="group" aria-label="Azioni sulla pagina">
                    <button type="button" class="btn btn-transparent page-tools__item" title="Condividi sui social media" data-toggle="share-popover">
                        <span class="icon i-share-alt" title="Icona di condivisione"></span> <span class="sr-only">Condividi</span>
                    </button> 
            
                    <div class="page-tools__share-popover-content">
                        <div class="d-flex flex-row flex-lg-column addthis_inline_share_toolbox d-print-flex">
                        
                            <a data-am-share-channel="fb" class="share-component__item">
                                <span class="icon i-facebook" title="Condividi su Facebook"></span>
                            </a>
                            <a data-am-share-channel="tw" class="share-component__item">
                                <span class="icon i-twitter" title="Condividi su Twitter"></span>
                            </a>
                            <a data-am-share-channel="wa" class="share-component__item">
                                <span class="icon i-whatsapp" title="Condividi via WhatsApp"></span>
                            </a>
            
                        </div>
                        <!-- Go to www.addthis.com/dashboard to customize your tools --> 
                        <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5cf4d7ff9c8211b9"></script>
                    </div>
            
            </div>
            
        </div>
    </div>
</div>
</div>