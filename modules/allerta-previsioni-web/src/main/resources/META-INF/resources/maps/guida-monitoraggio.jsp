<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();
String currentLanguage = LanguageUtil.getLanguageId(request);
boolean isEnglish = currentLanguage.startsWith("en");

%>
	<!--Guida Mappa Monitoraggio -->
	<div class="modal fade modal--map-guide modal--map-guide--monitoring"
		id="modal--guida-mappa-monitoraggio" tabindex="-1" role="dialog"
		aria-labelledby="modal-guida-mappa-monitoraggio-title"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-guida-mappa-monitoraggio-title">
						<span class="icon i-question-circle" aria-hidden="true"></span>
						<liferay-ui:message key="allertaprevisioniweb_guidaallamappa" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-lead">
					<liferay-ui:message key="allertaprevisioniweb_guida7" />
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-12 col-lg-7">
							<div class="mb-4">
								<h6><liferay-ui:message key="allertaprevisioniweb_guida9" /></h6>
								<ul class="mb-md-2 nav map-legend__rtdata-guides flex-column">
									<li class="nav-item" data-if="legend" data-when="radar">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida10" /></strong>
											<div class="legend-image">
												<span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #006 !important;"></span> <span
													class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_radar1" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #0f0 !important;"></span> <span
													class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_radar2" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #ff0 !important;"></span> <span
													class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_radar3" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #f00 !important;"></span> <span
													class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_radar4" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #9d18ff !important;"></span> <span
													class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_radar5" /></span>
												</span>
											</div>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="vento">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida11" /></strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_D_vento.png"
												alt="<liferay-ui:message key="allertaprevisioniweb_legendaper" /> Vento (m/s)"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="idrometrico">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida12" /></strong>
											<div class="legend-image">
												<span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--green"></span>
													<span class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_soglia1" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--yellow"></span>
													<span class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_soglia2" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--orange"></span>
													<span class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_soglia3" /></span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--red"></span>
													<span class="legend-measure-el__label"><liferay-ui:message key="allertaprevisioniweb_soglia4" /></span>
												</span>
											</div>
										</div>
									</li>
									<li class="nav-item" data-if="legend"
										data-when="precipitazioni">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida13" /></strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_P_piogge.png"
												alt="<liferay-ui:message key="allertaprevisioniweb_legendaper" /> <liferay-ui:message key="allertaprevisioniweb_guida13" />"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="pressione">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida14" /></strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_P_pressione.png"
												alt="<liferay-ui:message key="allertaprevisioniweb_legendaper" /> <liferay-ui:message key="allertaprevisioniweb_guida14" />"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="umidita">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida15" /></strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_U_umidita.png"
												alt="<liferay-ui:message key="allertaprevisioniweb_legendaper" /> <liferay-ui:message key="allertaprevisioniweb_guida15" />"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="temperature">
										<div class="nav-span d-flex flex-column mb-3">
											<strong><liferay-ui:message key="allertaprevisioniweb_guida16" /></strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_T_temperature.png"
												alt="<liferay-ui:message key="allertaprevisioniweb_legendaper" /> <liferay-ui:message key="allertaprevisioniweb_guida16" />"> </picture>
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-12 col-lg-5">
							<div class="mb-4">
								<h6><liferay-ui:message key="allertaprevisioniweb_guida17" /></h6>
								<ul class="mb-md-2 nav map-legend__utility-guides flex-column">
									<li class="nav-item"><a class="nav-link" href="<%=doc.linkGuidaMonitoraggio() %>"
										target="_blank"><span class="icon i-file-pdf-o"></span><liferay-ui:message key="allertaprevisioniweb_guida18" /></a></li>
								</ul>
							</div>
							<div class="mb-4">
								<h6><liferay-ui:message key="allertaprevisioniweb_guida3" /></h6>
								<ul
									class="mb-md-2 nav map-legend__phenomenon-guides flex-column">
									<li class="nav-item"><a class="nav-link" href="<%=doc.linkGuidaMappa() %>"
										target="_blank"><span class="icon i-file-pdf-o"></span><liferay-ui:message key="allertaprevisioniweb_guida2" /></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ Guida Mappa Monitoraggio -->