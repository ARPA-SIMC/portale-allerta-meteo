<%@page import="it.eng.allerter.model.AllertaParametro"%>
<%@page import="it.eng.allerter.service.AllertaParametroLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<portlet:defineObjects/>
<theme:defineObjects/>
<%
Allerta feedback=null;
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm",Locale.ITALY);
SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy",Locale.ITALY);
if(request.getAttribute("allerta")!=null)
 feedback = (Allerta)request.getAttribute("allerta");

List<Long> stati = new ArrayList<Long>();
List<String> classi = new ArrayList<String>();

String vedi = "";
String hash = "<p>Hash del file (SHA-256): "+feedback.getHash()+"</p>";

if (feedback!=null && feedback.getTipoAllerta()) vedi = "VEDI L'ALLERTA"; else vedi = "VEDI IL BOLLETTINO";


String displaynone = (feedback.getStato()==WorkflowConstants.STATUS_APPROVED?"":"display:none");
String notdisplaynone = (feedback.getStato()!=WorkflowConstants.STATUS_APPROVED?"":"display:none");
String stato = "In revisione";
if (feedback.getStato()==WorkflowConstants.STATUS_APPROVED) stato = "Approvata";
if (feedback.getStato()==WorkflowConstants.STATUS_DRAFT) stato = "In lavorazione";
if (feedback.getStato()==WorkflowConstants.STATUS_DENIED) stato = "Respinta";
System.out.println(stato);



String pdfLink = feedback.getLink();
String sintesiLink = "";
String modificaLink = "";
String sintesi = feedback.getSintesi();
if (sintesi!=null) {
	sintesi = sintesi.replaceAll("\r\n", "<br/>");
	sintesi = sintesi.replaceAll("\r", "<br/>");
	sintesi = sintesi.replaceAll("\n", "<br/>");
	int index = 0;
	while (sintesi.contains("+++")) {
		if (index++ % 2 == 0 ) sintesi = sintesi.replaceFirst("\\+\\+\\+", "<b>");
		else sintesi = sintesi.replaceFirst("\\+\\+\\+", "</b>");
	}
	
}

try {
	AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_SINTESI_LINK");
	
	if (ap!=null && ap.getValore()!=null && user!=null) {
		
		String[] ruoli = ap.getValore().split(",");
		
		long roles[] = user.getRoleIds();
		
		boolean trovato = false;
		
		for (String s : ruoli)
			for (long r : roles) {
				if (r==Long.parseLong(s)) trovato = true;
			}
		
		if (trovato) {
			
			AllertaParametro ap2 = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_SINTESI_LINK");
			if (ap2!=null && ap2.getValore()!=null) {
				sintesiLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
				sintesiLink = "<a href=\""+sintesiLink+"\">Modifica sintesi documento</a>";
				sintesiLink = "<div class=\"allerta-boll-documento__sintesi\">"+sintesiLink+"</div>";
			}
			
		}
		
	}
	
	
	 ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
	
	if (feedback.getStato()==WorkflowConstants.STATUS_DRAFT && ap!=null && ap.getValore()!=null && user!=null) {
		
		String[] ruoli = ap.getValore().split(",");
		
		long roles[] = user.getRoleIds();
		
		boolean trovato = false;
		
		for (String s : ruoli)
			for (long r : roles) {
				if (r==Long.parseLong(s)) trovato = true;
			}
		
		if (trovato) {
			
			AllertaParametro ap2 = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_MODIFICA_LINK");
			if (ap2!=null && ap2.getValore()!=null) {
				modificaLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
				modificaLink = "<a href=\""+modificaLink+"\">Modifica documento</a>";
				modificaLink = "<div class=\"allerta-boll-documento__modifica\">"+modificaLink+"</div>";
			}
			
		}
		
	}
	
} catch (Exception e) {
	e.printStackTrace();
}


%>
<style type="text/css"> 
header h1 { display:none; }
.asset-abstract { display:block !important; }

.taglib-social-bookmarks { display:none; }

.temporali { display:none; }
.idrogeologica { display:none; }
.idraulica { display:none; }
.vento { display:none; }
.temperature { display:none; }
.neve { display:none; }
.ghiaccio { display:none; }
.mare { display:none; }
.costiera { display:none; }

<% for (String l : classi) { %>
		
		<%=l %> {
			display:block !important;
		}
		<% 
}

%>
</style>
<article>
	<header class="page-title">
		
		<div class="page__publish">
			<i class="fa fa-clock-o">Emanato il <%=(feedback.getDataEmissione()!=null?sdf2.format(feedback.getDataEmissione()):"---") %> alle <%=(feedback.getDataEmissione()!=null?sdf.format(feedback.getDataEmissione()):"---") %></i>
		</div>
		
		<div  class="allerta-boll-documento__validita">Valida dalle <%=sdf.format(feedback.getDataInizio()) %> del <%=sdf2.format(feedback.getDataInizio()) 
		%> fino alle <%=sdf.format(feedback.getDataFine()) %> del <%=sdf2.format(feedback.getDataFine()) 
		%></div>
		
		<div class="allerta-boll-documento__sintesi">
			<%=sintesi %>
		</div>
		
		<%=sintesiLink %>
		
		<%=modificaLink %>
		
		<div class="allerta-boll-documento__desc"><%=(feedback.getSintesi()!=null && !feedback.getSintesi().equals("")?"": feedback.getDescrizioneMeteo()) %></div>
		
		<%=hash %>
		
		<div style="<%=displaynone%>" >
			<div class="evidence-box" style="text-align:center; ">
								<a href="#pdf-viewer-widget" data-toggle="firstmodal" class="btn btn-lg btn-primary">
									<span class="fa fa-file-pdf-o"></span> &nbsp; <%=vedi %>
								</a>
			</div>
		</div>
		
		<div style="<%=notdisplaynone%>" >
			<a target="_blank" href="<%=pdfLink%>">Scarica il PDF </a>	
		</div>
		
	</header>	
</article>

<div class="first-modal-outer pdf-viewer-widget" id="pdf-viewer-widget" style="<%=displaynone%>" >
    				
    				<article id="123" class="first-modal-inner">
	    				<div class="first-modal-head">
	    					<a href="#pdf-viewer-widget" class="btn btn-sm btn-default first-modal-close first-modal-close-exit">
	    						<i class="fa fa-times"></i> Chiudi</a>
	    				</div>
	    				
						<header>
							<h1><i class="fa fa-file-pdf-o"></i> <span class="pdf-viewer-title parametrize-me__title"> Allerta <%=feedback.getNumero()%></span></h1>
							<p class="widget-hint-text">
								Non riesci a vederlo bene? <a href="<%=pdfLink%>"><i class="fa fa-download"></i> Scarica il PDF </a>	
							</p>
						</header>
						
						<div class="pdf-viewer-embed-wrp">
							<object class="parametrize-me__pdf" data="<%=pdfLink%>#zoom=100" type="application/pdf" internalinstanceid="371" style="height:100%; width:100%">
							  <p>Sembra che il tuo browser non riesca a visualizzare i PDF qui dentro.
							  <a href="<%=pdfLink%>" class="btn btn-sm btn-default"><i class="fa fa-download"></i>Scarica il PDF sul tuo dispositivo</a></p>
							</object>
						</div>
						<div class="first-modal-backdrop"></div>	
					</article>
					
</div>
