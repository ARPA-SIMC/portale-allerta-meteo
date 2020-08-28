<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page
	import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.allerter.model.AllertaParametro"%>
<%@page
	import="it.eng.allerter.service.AllertaParametroLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="it.eng.allerter.model.AllertaStato"%>

<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="it.eng.allerter.service.AllertaStatoLocalServiceUtil"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
	Allerta feedback = null;

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ITALY);
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALY);
	
	

	if (request.getAttribute("allerta") != null)
		feedback = (Allerta) request.getAttribute("allerta");
	
	String sintesi = feedback.getSintesi();
	if (sintesi!=null) {
		sintesi = sintesi.replaceAll("\r\n", "<br/>");
		sintesi = sintesi.replaceAll("\r", "<br/>");
		sintesi = sintesi.replaceAll("\n", "<br/>");
		int index = 0;
		while (sintesi.contains("+++")) {
			if (index++ % 2 == 0 ) sintesi = sintesi.replaceFirst("\\+\\+\\+", "<b>");
			else sintesi= sintesi.replaceFirst("\\+\\+\\+", "</b>");
		}
		
		
	}

	DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(AllertaStato.class)
			.add(PropertyFactoryUtil.forName("allertaId").eq(feedback.getAllertaId()));

	List<AllertaStato> bb = AllertaStatoLocalServiceUtil.dynamicQuery(dyn);
	List<Long> stati = new ArrayList<Long>();
	List<String> classi = new ArrayList<String>();

	String vedi = "";
	String hash = "<p>Hash del file (SHA-256): " + feedback.getHash() + "</p>";

	if (feedback != null && feedback.getTipoAllerta())
		vedi = "VEDI L'ALLERTA";
	else
		vedi = "VEDI IL BOLLETTINO";

	for (AllertaStato b : bb) {

		if (b.getStatoId() != 1000 && b.getStatoId() != 0) {

			boolean trovato = false;

			for (Long l : stati)
				if (l.equals(b.getEventoId())) {
					trovato = true;
				}

			if (!trovato) {

				stati.add(b.getEventoId());

				if (b.getEventoId() == 1)
					classi.add(".idraulica");
				if (b.getEventoId() == 2)
					classi.add(".idrogeologica");
				if (b.getEventoId() == 3)
					classi.add(".temporali");
				if (b.getEventoId() == 4)
					classi.add(".vento");
				if (b.getEventoId() == 5)
					classi.add(".temperature");
				if (b.getEventoId() == 6)
					classi.add(".neve");
				if (b.getEventoId() == 7)
					classi.add(".ghiaccio");
				if (b.getEventoId() == 8)
					classi.add(".mare");
				if (b.getEventoId() == 9)
					classi.add(".costiera");
			}

		}
	}

	String displaynone = (feedback.getStato() == WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
	String notdisplaynone = (feedback.getStato() != WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
	String stato = "In revisione";

	if (feedback.getStato() == WorkflowConstants.STATUS_APPROVED)
		stato = "Approvata";
	if (feedback.getStato() == WorkflowConstants.STATUS_DRAFT)
		stato = "In lavorazione";
	if (feedback.getStato() == WorkflowConstants.STATUS_DENIED)
		stato = "Respinta";

	System.out.println(stato);

	String pdfLink = feedback.getLink();
	String previewPdfLink = pdfLink += "?previewFile=1";
	
	String sintesiLink = "";
	String modificaLink = "";

	try {
		AllertaParametro ap = AllertaParametroLocalServiceUtil
				.fetchAllertaParametro("ALLERTA_RUOLI_SINTESI_LINK");

		if (ap != null && ap.getValore() != null && user != null) {

			String[] ruoli = ap.getValore().split(",");

			long roles[] = user.getRoleIds();

			boolean trovato = false;

			for (String s : ruoli)
				for (long r : roles) {
					if (r == Long.parseLong(s))
						trovato = true;
				}

			if (trovato) {

				AllertaParametro ap2 = AllertaParametroLocalServiceUtil
						.fetchAllertaParametro("ALLERTA_SINTESI_LINK");
				if (ap2 != null && ap2.getValore() != null) {
					//sintesiLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
					sintesiLink="/allerte-e-bollettini?p_p_id=AllertaCompilaSbPortlet&p_p_lifecycle=0&_AllertaCompilaSbPortlet_mvcRenderCommandName=%2Fallertaer%2Fallerta%2Fcompila&_AllertaCompilaSbPortlet_allertaId="+
							feedback.getAllertaId()+"&_AllertaCompilaSbPortlet_sintesi=true";
					
					sintesiLink = "<a href=\"" + sintesiLink + "\">Modifica sintesi documento</a>";
					sintesiLink = "<div class=\"allerta-boll-documento__sintesi\">" + sintesiLink + "</div>";
				}

			}

		}

		ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");

		if (feedback.getStato() == WorkflowConstants.STATUS_DRAFT && ap != null && ap.getValore() != null
				&& user != null) {

			String[] ruoli = ap.getValore().split(",");

			long roles[] = user.getRoleIds();

			boolean trovato = false;

			for (String s : ruoli)
				for (long r : roles) {
					if (r == Long.parseLong(s))
						trovato = true;
				}

			if (trovato) {

				AllertaParametro ap2 = AllertaParametroLocalServiceUtil
						.fetchAllertaParametro("ALLERTA_MODIFICA_LINK");

				if (ap2 != null && ap2.getValore() != null) {

					modificaLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
					modificaLink = "<a href=\"" + modificaLink + "\">Modifica documento</a>";
					modificaLink = "<div class=\"allerta-boll-documento__modifica\">" + modificaLink + "</div>";
				}

			}

		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	String loginPortletId = AllertaKeys.AllertaLogin;

	String socialPortletId = AllertaKeys.AllertaSocialPortlet;

	JournalArticle previsioniDatiArticle = JournalArticleLocalServiceUtil
			.fetchArticleByUrlTitle(themeDisplay.getScopeGroupId(), "menu-previsione-e-da-1");

	JournalArticleDisplay previsioniDatiDisplay = null;

	if (previsioniDatiArticle != null)
		previsioniDatiDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(),
				previsioniDatiArticle.getArticleId(), "VIEW", "IT", themeDisplay);

	JournalArticle mappeRischioArticle = JournalArticleLocalServiceUtil
			.fetchArticleByUrlTitle(themeDisplay.getScopeGroupId(), "menu-mappe-di-rischio");

	JournalArticleDisplay mappeRischioDisplay = null;
	if (mappeRischioArticle != null)
		mappeRischioDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(),
				mappeRischioArticle.getArticleId(), "VIEW", "IT", themeDisplay);
%>

<style type="text/css">
.mb-2 {
	display: none !important;
}

.metadata-author {
	display: none;
}

.separator {
	display: none;
}

.asset-details {
	display: none;
}

.panel {
	background: none !important;
}
</style>



<main class="page main page--single-doc" id="main-content">

	<div class="page__head">
		<div class="container d-flex">
			<div class="row w-100 justify-content-between">
				<h1 class="col-12 col-lg-10"><%=feedback.getTitolo()%></h1>
			</div>
		</div>

		<div class="breadcrumb-container">
			<div class="container d-flex">
				<nav class="row" aria-label="Hai percorso">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
						<li class="breadcrumb-item"><a href="/allerte-e-bollettini">Allerte
								e bollettini</a></li>
						<li class="breadcrumb-item active" aria-current="page"><%=feedback.getTitolo()%></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container page__body">
		<div class="row">

			<div class="col-12 col-md-9 col-lg-10">
				<div class="page__content" id="page-content">

					<div class="page--single-doc__emitted">
						<span class="icon i-clock" title="Icona orologio"></span> Emanato
						il
						<%=(feedback.getDataEmissione() != null ? sdf2.format(feedback.getDataEmissione()) : "---")%>
						alle
						<%=(feedback.getDataEmissione() != null ? sdf.format(feedback.getDataEmissione()) : "---")%>
					</div>
					<div class="page--single-doc__validity">
						Valida dalle
						<%=sdf.format(feedback.getDataInizio())%>
						del
						<%=sdf2.format(feedback.getDataInizio())%>
						fino alle
						<%=sdf.format(feedback.getDataFine())%>
						del
						<%=sdf2.format(feedback.getDataFine())%>
					</div>

					<div class="page--single-doc__summary">
						<%=(sintesi!=null && !sintesi.equals("")?
								sintesi: feedback.getDescrizioneMeteo())%>
						
						<%=(sintesiLink!=null?sintesiLink:"") %>
					</div>

					<div class="page--single-doc__desc"></div>

					<div class="page--single-doc__hash">
						Hash del file (SHA-256):
						<%=feedback.getHash()%></div>


					<div class="page--single-doc__cta">
						<a href="<%=pdfLink%>" class="btn btn-lg btn-primary"
							data-toggle="pdf-viewer"> <span class="icon i-file-pdf-o"
							aria-hidden="true"></span> <%=vedi%>
						</a>
					</div>


					<hr>
					


					<c:if
						test="<%=previsioniDatiDisplay != null && mappeRischioDisplay != null%>">

						<section class="px-lg-3">
							<p class="sr-only">Di seguito ulteriori risorse e strumenti
								utili correlati a questo documento.</p>
							<div class="row">
								<div class="col-12 col-md-6">
									<%=previsioniDatiDisplay.getContent()%>
								</div>
								<div class="col-12 col-md-6">
									<%=mappeRischioDisplay.getContent()%>
								</div>
							</div>
						</section>

					</c:if>

					<section class="px-lg-3">
						<p class="sr-only">Di seguito ulteriori risorse e strumenti
							utili correlati a questo documento.</p>
						<div class="row"></div>
					</section>

					<h3 hidden aria-hidden="true">Strumenti di supporto</h3>
					<h4 hidden aria-hidden="true">Finestre modali di anteprima dei
						documenti</h4>

					<div class="modal modal-pdf-viewer" tabindex="-1" role="dialog"
						id="modal-pdf-viewer">
						<div class="modal-dialog modal-xxl" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">
										Anteprima del PDF (non riesci a vederlo bene? <a
											data-beforeload="pdf-viewer"
											href="<%=pdfLink %>"
											title="Scarica il PDF"> <span class="icon i-donwload"
											aria-hidden="true"></span> Scarica il PDF
										</a>).
									</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Chiudi">
										<span class="icon i-close"
											title="Icona del bottone che chiude la finestra modale"></span>
									</button>
								</div>
								<div class="modal-body">
									<object class="modal__pdf-viewer" data-beforeload="pdf-viewer"
										data="<%=pdfLink %>"
										type="application/pdf">
										<p class="p-3">
											Sembra che il tuo browser non riesca a visualizzare i PDF qui
											dentro. <a data-beforeload="pdf-url"
												href="<%=pdfLink %>"
												class="btn btn-sm btn-default"> <span
												class="icon i-download" aria-hidden="true"></span>>Scarica il
												PDF sul tuo dispositivo
											</a>
										</p>
									</object>
								</div>
	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</main>
