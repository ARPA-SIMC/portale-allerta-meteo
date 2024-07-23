<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();

%>

<div aria-hidden="true" hidden="" class="map-templates">

			<!-- Template singoli fenomeni (livello allerta + icone) -->
			<div class="idraulica-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--idraulica-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di piene dei fiumi">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idraulica icon i-piene-fiumi"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Piene
							dei fiumi</span>
					</div>
				</div>
			</div>
			<div class="idraulica-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--idraulica-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di piene dei fiumi">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idraulica icon i-piene-fiumi"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Piene
							dei fiumi</span>
					</div>
				</div>
			</div>
			<div class="idraulica-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--idraulica-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di piene dei fiumi">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idraulica icon i-piene-fiumi"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Piene
							dei fiumi</span>
					</div>
				</div>
			</div>
			<div class="idraulica-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--idraulica-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di piene dei fiumi">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idraulica icon i-piene-fiumi"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Piene
							dei fiumi</span>
					</div>
				</div>
			</div>
			<div class="idrogeologica-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--idrogeologica-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di frane e piene dei corsi minori">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idrogeologica icon i-frane"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Frane
							e piene dei corsi minori</span>
					</div>
				</div>
			</div>
			<div class="idrogeologica-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--idrogeologica-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di frane e piene dei corsi minori">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idrogeologica icon i-frane"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Frane
							e piene dei corsi minori</span>
					</div>
				</div>
			</div>
			<div class="idrogeologica-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--idrogeologica-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di frane e piene dei corsi minori">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idrogeologica icon i-frane"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Frane
							e piene dei corsi minori</span>
					</div>
				</div>
			</div>
			<div class="idrogeologica-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--idrogeologica-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di frane e piene dei corsi minori">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__idrogeologica icon i-frane"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Frane
							e piene dei corsi minori</span>
					</div>
				</div>
			</div>
			<div class="temporali-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--temporali-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di temporali">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temporali icon i-temporali"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temporali</span>
					</div>
				</div>
			</div>
			<div class="temporali-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--temporali-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di temporali">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temporali icon i-temporali"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temporali</span>
					</div>
				</div>
			</div>
			<div class="temporali-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--temporali-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di temporali">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temporali icon i-temporali"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temporali</span>
					</div>
				</div>
			</div>
			<div class="temporali-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--temporali-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di temporali">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temporali icon i-temporali"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temporali</span>
					</div>
				</div>
			</div>
			<div class="vento-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--vento-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di vento">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__vento icon i-vento"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Vento</span>
					</div>
				</div>
			</div>
			<div class="vento-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--vento-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di vento">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__vento icon i-vento"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Vento</span>
					</div>
				</div>
			</div>
			<div class="vento-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--vento-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di vento">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__vento icon i-vento"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Vento</span>
					</div>
				</div>
			</div>
			<div class="vento-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--vento-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di vento">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__vento icon i-vento"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Vento</span>
					</div>
				</div>
			</div>
			<div class="neve-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--neve-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di neve">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__neve icon i-neve"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Neve</span>
					</div>
				</div>
			</div>
			<div class="neve-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--neve-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di neve">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__neve icon i-neve"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Neve</span>
					</div>
				</div>
			</div>
			<div class="neve-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--neve-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di neve">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__neve icon i-neve"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Neve</span>
					</div>
				</div>
			</div>
			<div class="neve-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--neve-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di neve">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__neve icon i-neve"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Neve</span>
					</div>
				</div>
			</div>
			<div class="ghiaccio-pioggia-gela-red-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--ghiaccio-pioggia-gela-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di pioggia che gela">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__ghiaccio-pioggia-gela icon i-pioggia-gelata"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Pioggia
							che gela</span>
					</div>
				</div>
			</div>
			<div class="ghiaccio-pioggia-gela-orange-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--ghiaccio-pioggia-gela-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di pioggia che gela">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__ghiaccio-pioggia-gela icon i-pioggia-gelata"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Pioggia
							che gela</span>
					</div>
				</div>
			</div>
			<div class="ghiaccio-pioggia-gela-yellow-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--ghiaccio-pioggia-gela-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di pioggia che gela">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__ghiaccio-pioggia-gela icon i-pioggia-gelata"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Pioggia
							che gela</span>
					</div>
				</div>
			</div>
			<div class="ghiaccio-pioggia-gela-green-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--ghiaccio-pioggia-gela-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di pioggia che gela">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__ghiaccio-pioggia-gela icon i-pioggia-gelata"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Pioggia
							che gela</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-alte-red-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-alte-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di temperature estreme calde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-alte icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-alte-orange-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-alte-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di temperature estreme calde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-alte icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-alte-yellow-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-alte-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di temperature estreme calde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-alte icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-alte-green-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-alte-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di temperature estreme calde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-alte icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-basse-red-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-basse-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di temperature estreme fredde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-basse icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-basse-orange-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-basse-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di temperature estreme fredde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-basse icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-basse-yellow-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-basse-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di temperature estreme fredde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-basse icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="temperature-estreme-basse-green-tpl">
				<div
					class="phenomenon-sign phenomenon-sign--temperature-estreme-basse-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di temperature estreme fredde">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__temperature-estreme-basse icon i-temperature-es"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Temperature
							estreme</span>
					</div>
				</div>
			</div>
			<div class="stato-mare-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--stato-mare-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di stato del mare">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__stato-mare icon i-stato-mare"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Stato
							del mare</span>
					</div>
				</div>
			</div>
			<div class="stato-mare-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--stato-mare-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di stato del mare">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__stato-mare icon i-stato-mare"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Stato
							del mare</span>
					</div>
				</div>
			</div>
			<div class="stato-mare-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--stato-mare-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di stato del mare">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__stato-mare icon i-stato-mare"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Stato
							del mare</span>
					</div>
				</div>
			</div>
			<div class="stato-mare-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--stato-mare-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di stato del mare">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__stato-mare icon i-stato-mare"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Stato
							del mare</span>
					</div>
				</div>
			</div>
			<div class="mareggiate-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--mareggiate-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di mareggiate">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__mareggiate icon i-mareggiate"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Mareggiate</span>
					</div>
				</div>
			</div>
			<div class="mareggiate-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--mareggiate-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di mareggiate">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__mareggiate icon i-mareggiate"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Mareggiate</span>
					</div>
				</div>
			</div>
			<div class="mareggiate-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--mareggiate-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di mareggiate">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__mareggiate icon i-mareggiate"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Mareggiate</span>
					</div>
				</div>
			</div>
			<div class="mareggiate-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--mareggiate-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di mareggiate">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span
							class="phenomenon-sign__icon icon__mareggiate icon i-mareggiate"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Mareggiate</span>
					</div>
				</div>
			</div>
			<div class="valanghe-red-tpl">
				<div class="phenomenon-sign phenomenon-sign--valanghe-red"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni ingenti ed estesi di valanghe">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--red"
						data-original-title="Fenomeni ingenti ed estesi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__valanghe icon i-valanghe"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Valanghe</span>
					</div>
				</div>
			</div>
			<div class="valanghe-orange-tpl">
				<div class="phenomenon-sign phenomenon-sign--valanghe-orange"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni diffusi di valanghe">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--orange"
						data-original-title="Fenomeni diffusi">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__valanghe icon i-valanghe"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Valanghe</span>
					</div>
				</div>
			</div>
			<div class="valanghe-yellow-tpl">
				<div class="phenomenon-sign phenomenon-sign--valanghe-yellow"
					data-toggle="tooltip" title=""
					data-original-title="Rischio fenomeni localizzati di valanghe">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--yellow"
						data-original-title="Fenomeni localizzati">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__valanghe icon i-valanghe"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Valanghe</span>
					</div>
				</div>
			</div>
			<div class="valanghe-green-tpl">
				<div class="phenomenon-sign phenomenon-sign--valanghe-green"
					data-toggle="tooltip" title=""
					data-original-title="Rischio assenza di fenomeni significativi prevedibili di valanghe">
					<div data-toggle="tooltip" title=""
						class="alert-sign alert-sign--green"
						data-original-title="Assenza di fenomeni significativi prevedibili">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<div class="phenomenon-sign__body">
						<span class="phenomenon-sign__icon icon__valanghe icon i-valanghe"
							aria-hidden="true"></span> <span class="phenomenon-sign__text">Valanghe</span>
					</div>
				</div>
			</div>
			<!-- / Template singoli fenomeni (livello allerta + icone)-->

			<!-- Template Toggle dei marker per accessibilità -->
			<div class="map-accessibility-toggle-tpl">
				<a href="#" class="toggle-accessibility"
					data-toggle="toggle-accessibility"
					title="Mostra/nascondi i segnali accessibili dei livelli di allerta sulla mappa ">
					<span class="toggle-accessibility__off-icon icon i-square-o"
					data-toggle="tooltip" title=""
					data-original-title="Mostra i segnali accessibili dei livelli di allerta sulla mappa"></span>
					<span class="toggle-accessibility__on-icon icon i-check-square-o"
					data-toggle="tooltip" title=""
					data-original-title="Nascondi i segnali accessibili dei livelli di allerta sulla mappa"></span>
					<span class="icon i-eye" aria-hidden="true"></span>
				</a>
			</div>
			<!-- / Template Toggle dei marker per accessibilità -->


			<!-- Template Legenda Mappa di Previsione (con link ad apertura della modale) -->
			<div class="map-legend--previsioni-tpl">
				<div class="map-legend">

					<a href="#modal--guida-mappa-previsioni"
						class="d-block d-lg-none d-print-none" data-toggle="modal"
						data-target="#modal--guida-mappa-previsioni"> <span>
							Guida alla mappa </span> <span class="icon i-info-circle" title="Info"></span>
					</a>

					<div class="d-none d-lg-flex d-print-flex flex-lg-column">
						<h3>
							<a href="#" title="Expandi/richiudi la legenda"
								class="d-flex justify-content-between map-legend__toggle is-expanded">
								<span>Legenda </span> <span
								class="icon i-close map-legend__toggle--collapse"
								title="Richiudi"></span> <span
								class="icon i-expand map-legend__toggle--expand" title="Espandi"></span>
							</a>
						</h3>
						<div class="map-legend__toggable">
							<div class="mb-md-2">
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

							<div data-if="filter" data-when="generale">
								<a href="#modal--guida-mappa-previsioni" data-toggle="modal"
									data-target="#modal--guida-mappa-previsioni"> <span
									class="icon i-info-circle" title="Info"></span> <span>
										Guida alla mappa </span>
								</a>
							</div>

							<div data-if="filter" data-when="!generale">
								<h3 class="sr-only">Guide al rischio degli fenomeni</h3>
								<ul class="nav map-legend__phenomenon-guides flex-column">
									<li class="nav-item" data-if="filter" data-when="idraulica">
										<a class="nav-link" href="<%=doc.linkPieneFiumi() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Piene dei fiumi</a>
									</li>
									<li class="nav-item" data-if="filter" data-when="idrogeologica">
										<a class="nav-link" href="<%=doc.linkFrane() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Frane e piene dei corsi
											minori</a>
									</li>
									<li class="nav-item" data-if="filter" data-when="temporali">
										<a class="nav-link" href="<%=doc.linkTemporali() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Temporali</a>
									</li>
									<li class="nav-item" data-if="filter" data-when="vento"><a
										class="nav-link" href="<%=doc.linkVento() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Vento</a></li>
									<li class="nav-item" data-if="filter" data-when="neve"><a
										class="nav-link" href="<%=doc.linkNeve() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Neve</a></li>
									<li class="nav-item" data-if="filter"
										data-when="ghiaccio-pioggia-gela"><a class="nav-link"
										href="<%=doc.linkPioggiaGela() %>" target="_blank"><span class="icon i-file-pdf-o"></span>Pioggia
											che gela</a></li>
									<li class="nav-item" data-if="filter"
										data-when="temperature-estreme-alte"><a class="nav-link"
										href="<%=doc.linkTemperature() %>" target="_blank"><span class="icon i-file-pdf-o"></span>Temperature
											estreme</a></li>
									<li class="nav-item" data-if="filter"
										data-when="temperature-estreme-basse"><a class="nav-link"
										href="<%=doc.linkTemperature() %>" target="_blank"><span class="icon i-file-pdf-o"></span>Temperature
											estreme</a></li>
									<li class="nav-item" data-if="filter" data-when="stato-mare">
										<a class="nav-link" href="<%=doc.linkStatoMare() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Stato del mare</a>
									</li>
									<li class="nav-item" data-if="filter" data-when="mareggiate">
										<a class="nav-link" href="<%=doc.linkMareggiate() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Mareggiate</a>
									</li>
									<li class="nav-item" data-if="filter" data-when="valanghe">
									   <div class="d-flex flex-row align-items-center my-md-2">
									<div style="margin-top: -0.4rem !important;" data-toggle="tooltip" title=""
										class="alert-sign alert-sign--white"
										data-original-title="No neve">
										<div style="background-color:#cccccc"></div>
										<div style="background-color:#cccccc"></div>
										<div style="background-color:#cccccc"></div>
										<div style="background-color:#cccccc"></div>
									</div>
									<div style="font-size: .9rem;">Fenomeno non valutabile</div>
								</div>
										<a class="nav-link" href="<%=doc.linkValanghe() %>" target="_blank"><span
											class="icon i-file-pdf-o"></span>Valanghe</a>
									</li>
								</ul>
							</div>

						</div>
					</div>


				</div>
			</div>
			<!-- / Template Legenda Mappa di Previsione (con link ad apertura della modale) -->

			<!-- Template Legenda Mappa di Monitoraggio (con link ad apertura della modale) -->
			<div class="map-legend--monitoraggio-tpl">
				<div class="map-legend">

					<a href="#" class="d-block" data-toggle="modal"
						data-target="#modal--guida-mappa-monitoraggio"> <span
						class="icon i-info-circle" title="Info"></span> <span>
							Guida alla mappa </span>
					</a>

				</div>
			</div>
			<!-- / Template Legenda Mappa di Monitoraggio (con link ad apertura della modale) -->

			<!-- Template di link Informati e preparati-->
            <div class="map-infopages-tpl">
                    <div class="nav-item" data-if="comune" data-when="idraulica">
                        <a class="nav-link nav-link--iep-idraulica" href="/cosa-fare-in-caso-di-alluvioni" target="_blank">
                            <span class="icon i-piene-fiumi" title="Icona piene dei fiumi"></span>
                            <span>Cosa fare in caso di piene dei fiumi</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="idrogeologica">
                        <a class="nav-link nav-link--iep-idrogeologica" href="/cosa-fare-in-caso-di-frane" target="_blank">
                            <span class="icon i-frane" title="Icona frane"></span>
                            <span>Cosa fare in caso di frane e piene dei corsi minori</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="temporali">
                        <a class="nav-link nav-link--iep-temporali" href="/cosa-fare-in-caso-di-temporali-fulmini-e-trombe-d-aria" target="_blank">
                            <span class="icon i-temporali" title="Icona temporali"></span>
                            <span>Cosa fare in caso di temporali</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="vento">
                        <a class="nav-link nav-link--iep-vento" href="/cosa-fare-in-caso-di-vento" target="_blank">
                            <span class="icon i-vento" title="Icona vento"></span>
                            <span>Cosa fare in caso di vento</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="neve">
                        <a class="nav-link nav-link--iep-neve" href="/cosa-fare-in-caso-di-neve" target="_blank">
                            <span class="icon i-neve" title="Icona neve"></span>
                            <span>Cosa fare in caso di neve</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="ghiaccio-pioggia-gela">
                        <a class="nav-link nav-link--iep-ghiaccio-pioggia-gela" href="/cosa-fare-in-caso-di-pioggia-che-gela" target="_blank">
                            <span class="icon i-pioggia-gelata" title="Icona pioggia che gela"></span>
                            <span>Cosa fare in caso di pioggia che gela</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="temperature-estreme">
                        <a class="nav-link nav-link--iep-temperature-estreme" href="/cosa-fare-in-caso-di-temperature-estreme" target="_blank">
                            <span class="icon i-temperature-es" title="Icona temperature estreme"></span>
                            <span>Cosa fare in caso di temperature estreme</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="mareggiate-stato-mare">
                        <a class="nav-link nav-link--iep-mareggiate-stato-mare" href="/cosa-fare-in-caso-di-mareggiate" target="_blank">
                            <span class="icon i-mareggiate" title="Icona mareggiate e stato del mare"></span>
                            <span>Cosa fare in caso di mareggiate / stato del mare</span>
                        </a>
                    </div>
                    <div class="nav-item" data-if="comune" data-when="valanghe">
                        <a class="nav-link nav-link--iep-valanghe" href="/cosa-fare-in-caso-di-valanghe" target="_blank">
                            <span class="icon i-valanghe" title="Icona valanghe"></span>
                            <span>Cosa fare in caso di valanghe</span>
                        </a>
                    </div>
            </div>
            <!-- / Template di link Informati e preparati-->
                               


			<!-- Template di Real Time Data Switch--->
			<div class="map-rtdata-dropdown-tpl">
				<div class="form-group map-rtdata-dropdown">
					<label for="form-control-select-sensore" title=""
						style="cursor: help;" data-placement="right" data-toggle="tooltip"
						data-original-title="Mostra dati in tempo reale"> <span
						class="icon i-bar-chart" aria-hidden="true"></span> <span
						class="sr-only">Scegli il dato da mostrare</span>
					</label> <select id="form-control-select-sensore" class="form-control"
						data-trigger="rtdata-filter">
						<option value="">- mostra dati -</option>
						<option value="">Nessuno</option>
						<option value="precipitazioni">Precipitazioni</option>
						<option value="idrometrico">Liv. Idrometrico</option>
						<option value="temperature">Temperature</option>
						<option value="umidita">Umidità</option>
						<option value="pressione">Pressione</option>
						<option value="vento">Vento</option>
					</select>
				</div>
			</div>
			<!-- / Template di Real Time Data Switch--->

			<!-- Template di Real Time Data Update --->
			<div class="map-rtdata-update-tpl">
				<div class="form-group map-rtdata-update">
					<div>
						Dati del <span id="rt-update-date"
							class="map-rtdata-update__datetime"></span>
					</div>
					<a href="#" data-trigger="refresh" class="btn btn-default btn-sm">
						<span class="icon i-refresh" aria-hidden="true"></span> <span
						class="sr-only">Aggiorna i dati sulla mappa</span>
					</a>
				</div>
			</div>
			<!-- / Template di Real Time Data Update--->


			<!-- Template Legenda Mappa di Dati Osservati (con modali specifiche) -->
			<div class="map-legend--observed-data--radar-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
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
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--vento-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
							<strong>Vento (m/s)</strong>
							<picture> <img
								src="/o/allerta-previsioni/img/legend/rt_D_vento.png"
								alt="Legenda per Vento (m/s)"> </picture>
						</div>
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--idrometrico-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
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
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--precipitazioni-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
							<strong>Precipitazioni (mm/ora)</strong>
							<picture> <img
								src="/o/allerta-previsioni/img/legend/rt_P_piogge.png"
								alt="Legenda per Precipitazioni (mm/ora)"> </picture>
						</div>
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--pressione-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
							<strong>Pressione (hPa)</strong>
							<picture> <img
								src="/o/allerta-previsioni/img/legend/rt_P_pressione.png"
								alt="Legenda per Pressione (hPa)"> </picture>
						</div>
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--umidita-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
							<strong>Umidità (%)</strong>
							<picture> <img
								src="/o/allerta-previsioni/img/legend/rt_U_umidita.png"
								alt="Legenda per Umidità (%)"> </picture>
						</div>
					</div>
				</div>
			</div>
			<div class="map-legend--observed-data--temperature-tpl">
				<div class="d-flex">
					<div class="map-legend">
						<a href="#" class="d-block" data-toggle="modal"
							data-target="#modal--guida-mappa-dato-osservato"> <span
							class="icon i-info-circle" title="Info"></span> <span>
								Guida alla mappa </span>
						</a>
					</div>

					<div class="d-none d-md-flex d-print-flex flex-md-row ml-4">
						<div class="map-legend--rtdata-legend">
							<strong>Temperature (C°)</strong>
							<picture> <img
								src="/o/allerta-previsioni/img/legend/rt_T_temperature.png"
								alt="Legenda per Temperature (C°)"> </picture>
						</div>
					</div>
				</div>
			</div>
			<!-- / Template Legenda Mappa di Dati Osservati (con modali specifiche) -->

		</div>