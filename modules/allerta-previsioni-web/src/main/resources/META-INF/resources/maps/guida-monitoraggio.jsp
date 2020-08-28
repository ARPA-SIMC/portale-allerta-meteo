<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();

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
						Guida alla mappa
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-lead">
					I livelli di criticità di ogni fenomeno si basano su soglie e
					valutazioni differenti. <br> Questa è una breve guida alla
					lettura della mappa.
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-12 col-lg-7">
							<div class="mb-4">
								<h6>Legenda dati in tempo reale per il Monitoraggio</h6>
								<ul class="mb-md-2 nav map-legend__rtdata-guides flex-column">
									<li class="nav-item" data-if="legend" data-when="radar">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Radar (stima della pioggia)</strong>
											<div class="legend-image">
												<span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #006 !important;"></span> <span
													class="legend-measure-el__label">A tratti</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #0f0 !important;"></span> <span
													class="legend-measure-el__label">Debole</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #ff0 !important;"></span> <span
													class="legend-measure-el__label">Media</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #f00 !important;"></span> <span
													class="legend-measure-el__label">Forte</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color"
													style="background-color: #9d18ff !important;"></span> <span
													class="legend-measure-el__label">Intensa</span>
												</span>
											</div>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="vento">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Vento (m/s)</strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_D_vento.png"
												alt="Legenda per Vento (m/s)"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="idrometrico">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Livello Idrometrico</strong>
											<div class="legend-image">
												<span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--green"></span>
													<span class="legend-measure-el__label">Inf. soglia 1</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--yellow"></span>
													<span class="legend-measure-el__label">Sup. soglia 1</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--orange"></span>
													<span class="legend-measure-el__label">Sup. soglia 2</span>
												</span> <span class="legend-measure-el"> <span
													class="legend-measure-el__color legend-measure-el__color--red"></span>
													<span class="legend-measure-el__label">Sup. soglia 3</span>
												</span>
											</div>
										</div>
									</li>
									<li class="nav-item" data-if="legend"
										data-when="precipitazioni">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Precipitazioni (mm/ora)</strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_P_piogge.png"
												alt="Legenda per Precipitazioni (mm/ora)"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="pressione">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Pressione (hPa)</strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_P_pressione.png"
												alt="Legenda per Pressione (hPa)"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="umidita">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Umidità (%)</strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_U_umidita.png"
												alt="Legenda per Umidità (%)"> </picture>
										</div>
									</li>
									<li class="nav-item" data-if="legend" data-when="temperature">
										<div class="nav-span d-flex flex-column mb-3">
											<strong>Temperature (C°)</strong>
											<picture> <img
												src="/o/allerta-previsioni/img/legend/rt_T_temperature.png"
												alt="Legenda per Temperature (C°)"> </picture>
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-12 col-lg-5">
							<div class="mb-4">
								<h6>Guide alle mappe di monitoraggio</h6>
								<ul class="mb-md-2 nav map-legend__utility-guides flex-column">
									<li class="nav-item"><a class="nav-link" href="<%=doc.linkGuidaMonitoraggio() %>"
										target="_blank"><span class="icon i-file-pdf-o"></span>Guida
											e legende delle mappe di monitoraggio</a></li>
								</ul>
							</div>
							<div class="mb-4">
								<h6>Guide di utilità</h6>
								<ul
									class="mb-md-2 nav map-legend__phenomenon-guides flex-column">
									<li class="nav-item"><a class="nav-link" href="<%=doc.linkGuidaMappa() %>"
										target="_blank"><span class="icon i-file-pdf-o"></span>Guida
											alla lettura della mappa</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ Guida Mappa Monitoraggio -->