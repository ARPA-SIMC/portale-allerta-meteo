<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="it.eng.allertaer.allertebollettini.portlet.config.ReportPostEventoConfiguration"%>
<%@page import="java.util.List"%>
<%@page import="it.eng.allertaer.allertebollettini.beans.Link"%>
<%@ include file="./init.jsp"%>

<%
	List<Link> reports = (List<Link>) renderRequest.getAttribute("reports");

	ReportPostEventoConfiguration myConfiguration = (ReportPostEventoConfiguration) renderRequest
			.getAttribute(ReportPostEventoConfiguration.class.getName());

	String renderConfigurationItem = "";

	if (Validator.isNotNull(myConfiguration)) {
		renderConfigurationItem = portletPreferences.getValue("renderTypeItem",
				myConfiguration.renderTypeItem());
	}
%>

<%
	if (renderConfigurationItem.equals("Home")) {
%>

<section class="col panel panel--expandible" id="report-post-evento">
	<h2 class="panel__heading" id="panel--report-post-evento__heading">
		<button class="btn-link" type="button" aria-expanded="true"
			aria-controls="panel--report-post-evento__body"
			data-toggle="collapse-down-md"
			data-target="#panel--report-post-evento__body">
			<span class="panel--expandible__heading__label"><span
				class="icon i-report-post-evento" aria-hidden="true"></span> <a href="/archivio-report-post-evento">Report
				post-evento</a></span> <span class="icon i-chevron-down icon--toggle"
				title="Icona che indica l'azione espandere o richiudere la sezione"></span>
		</button>
	</h2>
	<div class="row collapse panel__body d-print-flex"
		id="panel--report-post-evento__body"
		aria-labelledby="panel--report-post-evento__heading"
		style="display: block;">
		<ul class="link-list  ">
			<c:forEach items="${reports}" var="report">
				<li class="link-list-item"><a class="link-list-link"
					href="${report.url}"> <span class="link-list__item-label">${report.name}</span>
				</a>
					<div class="u-item-meta">
						<span class="icon i-clock-o" title="Pubblicato il"></span>
						${report.date}
					</div></li>
			</c:forEach>

		</ul>
		<a class="u-more-link" href="/archivio-report-post-evento" title="Vedi tutti">Vedi tutti <span
			class="icon i-arrow-circle-o-right" aria-hidden="true"></span></a>
	</div>
	<div class="row panel__footer"></div>
</section>

<%
	} else if (renderConfigurationItem.equals("Interna")) {
%>

<h3>Report post evento</h3>
<ul class="clear-ul">
	<c:forEach items="${reports}" var="report">
		<li>
			<div class="place-link ">
				<a href="${report.url}"> <i
					class="content-entry__icon fa fa-book"></i> ${report.name}
				</a>
			</div>
		</li>
	</c:forEach>

</ul>
<%
	} else {
%>
<div class="aside-widget aside-widget--report-post-evento">
	<h3>Report post-evento</h3>
	<ul class="link-list  ">
		<c:forEach items="${reports}" var="report">
			<li class="link-list-item"><a class="link-list-link"
				href="${report.url}"> <span class="link-list__item-label">${report.name}</span>
			</a>
				<div class="u-item-meta">
					<span class="icon i-clock" title="Pubblicato il"></span>
					${report.date}
				</div></li>
		</c:forEach>
	</ul>
	<a class="u-more-link" href="/report-post-evento" title="Vedi tutti">
		Vedi tutti <span class="icon i-arrow-circle-o-right"
		aria-hidden="true"></span>
	</a>
</div>
<%
	}
%>
