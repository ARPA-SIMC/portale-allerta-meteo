<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();

%>

<h4 class="sr-only">Guide e supporto</h4>
	<!-- Guida Mappa Previsioni -->
	<div class="modal  fade modal--map-guide modal--map-guide--forecast"
		id="modal--guida-mappa-previsioni" tabindex="-1" role="dialog"
		aria-labelledby="modal-guida-mappa-previsioni-title"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-guida-mappa-previsioni-title">Guida
						alla mappa</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-lead">
					I livelli di criticità di ogni fenomeno si basano su soglie e
					valutazioni differenti.<br> Questa è una breve guida alla
					lettura della mappa.
				</div>
				<div class="modal-body">
					<div class="row flex-lg-column">


						<div class="col-12 col-lg-7 mb-4">
							<h6>Legenda colori</h6>
							<div>
								<div class="d-flex flex-row align-items-center my-md-2">
									<div data-toggle="tooltip" title=""
										class="alert-sign alert-sign--red"
										data-original-title="Fenomeni ingenti ed estesi">
										<div></div>
										<div></div>
										<div></div>
										<div></div>
									</div>
									<div>Fenomeni ingenti ed estesi</div>
								</div>
								<div class="d-flex flex-row align-items-center my-md-2">
									<div data-toggle="tooltip" title=""
										class="alert-sign alert-sign--orange"
										data-original-title="Fenomeni diffusi">
										<div></div>
										<div></div>
										<div></div>
										<div></div>
									</div>
									<div>Fenomeni diffusi</div>
								</div>
								<div class="d-flex flex-row align-items-center my-md-2">
									<div data-toggle="tooltip" title=""
										class="alert-sign alert-sign--yellow"
										data-original-title="Fenomeni localizzati">
										<div></div>
										<div></div>
										<div></div>
										<div></div>
									</div>
									<div>Fenomeni localizzati</div>
								</div>
								<div class="d-flex flex-row align-items-center my-md-2">
									<div data-toggle="tooltip" title=""
										class="alert-sign alert-sign--green"
										data-original-title="Assenza di fenomeni significativi prevedibili">
										<div></div>
										<div></div>
										<div></div>
										<div></div>
									</div>
									<div>Assenza di fenomeni significativi prevedibili</div>
								</div>
							</div>
						</div>

						<div class="col-12 col-lg-7 mb-4" data-if="legend"
							data-when="rtdata">
							<h6>Legenda dati in tempo reale</h6>
							<p class="lead">Visibili sulla mappa presente nella pagine
								dei singoli comuni, agendo sull'apposito menu a tendina.</p>
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
								<li class="nav-item" data-if="legend" data-when="precipitazioni">
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



						<div class="col-12 col-lg-5 mb-4">
							<h6>Guide di utilità</h6>
							<ul class="mb-md-2 nav map-legend__utility-guides flex-column">
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkGuidaMappa() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Guida
										alla lettura della mappa</a></li>
							</ul>
						</div>

						<div class="col-12 col-lg-5 mb-4">
							<h6>Guide al rischio per i fenomeni</h6>
							<ul class="mb-md-2 nav map-legend__phenomenon-guides flex-column">
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkPieneFiumi() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Piene
										dei fiumi</a></li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkFrane() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Frane
										e piene dei corsi minori</a></li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkTemporali() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Temporali</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkVento() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Vento</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkNeve() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Neve</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkPioggiaGela() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Pioggia
										che gela</a></li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkTemperature() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Temperature
										estreme</a></li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkStatoMare() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Stato
										del mare</a></li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkMareggiate() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Mareggiate</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="<%=doc.linkValanghe() %>"
									target="_blank"><span class="icon i-file-pdf-o"></span>Valanghe</a>
								</li>
							</ul>
						</div>


					</div>
				</div>
				<!-- / modal-body -->

			</div>
		</div>
	</div>
	<!-- / Guida Mappa Previsioni -->