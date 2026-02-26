<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchHelper"%>
<%@page import="allerta.verifica.web.bean.VerificaDisplayTerms"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchContainer"%>
<%@page import="allerta.verifica.web.bean.VerificaAllertaBean"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>

<%
	VerificaAllertaBean bean = new VerificaAllertaBean(request);

	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();

	VerificaSearchContainer verificaSearchContainer = new VerificaSearchContainer(renderRequest, portletURL);
	VerificaDisplayTerms displayTerms = (VerificaDisplayTerms) verificaSearchContainer.getDisplayTerms();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	User u = PortalUtil.getUser(request);
	long[] rol = u.getRoleIds();
	boolean modifica = false;
	int k;
	if (rol != null) {
		for (k = 0; k < rol.length; k++)
			if (rol[k] == 1993255 || rol[k] == 20161 || rol[k] == 168321)
				modifica = true;
	}
%>

<aui:form action="<%=portletURLString%>" method="post" name="smsService">


	<div class="row">


		<div class="col-md-3">
			<label class="control-label" for="datetimepicker1">Da:</label>

			<div class='input-group date' id="datetimepicker1">
				<aui:input type="text" class="form-control" name="dataInvioDa"
					label="" placeholder="gg/mm/aaaa" />
				<span class="input-group-addon"> <i
					class="far fa-calendar-minus"></i>
				</span>
			</div>

			<script type="text/javascript">
				$(function() {
					$('#datetimepicker1').datetimepicker({
						format : 'DD/MM/YYYY',
						icons : {
							time : "far fa-clock",
							date : "far fa-calendar-minus",
							up : "fa fa-arrow-up",
							down : "fa fa-arrow-down"
						}
					});
				});
			</script>
		</div>

		<div class="col-md-3">
			<label class="control-label" for="datetimepicker2">A:</label>

			<div class='input-group date' id="datetimepicker2">
				<aui:input type="text" class="form-control" name="dataInvioA"
					label="" placeholder="gg/mm/aaaa" />
				<span class="input-group-addon"> <i
					class="far fa-calendar-minus"></i>
				</span>
			</div>

			<script type="text/javascript">
				$(function() {
					$('#datetimepicker2').datetimepicker({
						format : 'DD/MM/YYYY',
						icons : {
							time : "far fa-clock",
							date : "far fa-calendar-minus",
							up : "fa fa-arrow-up",
							down : "fa fa-arrow-down"
						}
					});
				});
			</script>
		</div>

		<div class="col-md-2">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_evento">Evento</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_evento"><option
					value=""></option>
				<option value="1" <%="1".equals(displayTerms.getEvento())?"selected":"" %> >Piene dei fiumi</option>
				<option value="2" <%="2".equals(displayTerms.getEvento())?"selected":"" %>>Frane e piene dei fiumi minori</option>
				<option value="3" <%="3".equals(displayTerms.getEvento())?"selected":"" %>>Temporali</option>
				<option value="4" <%="4".equals(displayTerms.getEvento())?"selected":"" %>>Vento</option>
				<option value="5" <%="5".equals(displayTerms.getEvento())?"selected":"" %>>Temperature estreme</option>
				<option value="6" <%="6".equals(displayTerms.getEvento())?"selected":"" %>>Neve</option>
				<option value="7" <%="7".equals(displayTerms.getEvento())?"selected":"" %>>Pioggia che gela</option>
				<option value="8" <%="8".equals(displayTerms.getEvento())?"selected":"" %>>Stato del mare</option>
				<option value="9" <%="9".equals(displayTerms.getEvento())?"selected":"" %>>Criticit&agrave; costiera</option></select>
		</div>
		<div class="col-md-2">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_zona">Zona</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_zona"><option value=""></option>
				<option value="A1" <%="A1".equals(displayTerms.getZona())?"selected":"" %> >A1</option>
				<option value="A2" <%="A2".equals(displayTerms.getZona())?"selected":"" %> >A2</option>
				<option value="B1" <%="B1".equals(displayTerms.getZona())?"selected":"" %> >B1</option>
				<option value="B2" <%="B2".equals(displayTerms.getZona())?"selected":"" %> >B2</option>
				<option value="C1" <%="C1".equals(displayTerms.getZona())?"selected":"" %> >C1</option>
				<option value="C2" <%="C2".equals(displayTerms.getZona())?"selected":"" %> >C2</option>
				<option value="D1" <%="D1".equals(displayTerms.getZona())?"selected":"" %> >D1</option>
				<option value="D2" <%="D2".equals(displayTerms.getZona())?"selected":"" %> >D2</option>
				<option value="E1" <%="E1".equals(displayTerms.getZona())?"selected":"" %> >E1</option>
				<option value="E2" <%="E2".equals(displayTerms.getZona())?"selected":"" %> >E2</option>
				<option value="F1" <%="F1".equals(displayTerms.getZona())?"selected":"" %> >F1</option>
				<option value="F2" <%="F2".equals(displayTerms.getZona())?"selected":"" %> >F2</option>
				<option value="F3" <%="F3".equals(displayTerms.getZona())?"selected":"" %> >F3</option>
				<option value="G1" <%="G1".equals(displayTerms.getZona())?"selected":"" %> >G1</option>
				<option value="G2" <%="G2".equals(displayTerms.getZona())?"selected":"" %> >G2</option>
				<option value="H1" <%="H1".equals(displayTerms.getZona())?"selected":"" %> >H1</option>
				<option value="H2" <%="H2".equals(displayTerms.getZona())?"selected":"" %> >H2</option></select>
		</div>
		<div class="col-md-3">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePre">Colore previsto</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePre"><option
					value=""></option>
				<option value="VERDE" <%="VERDE".equals(displayTerms.getColorePre())?"selected":"" %>  >VERDE</option>
				<option value="GIALLO" <%="GIALLO".equals(displayTerms.getColorePre())?"selected":"" %> >GIALLO</option>
				<option value="ARANCIONE" <%="ARANCIONE".equals(displayTerms.getColorePre())?"selected":"" %> >ARANCIONE</option>
				<option value="ROSSO" <%="ROSSO".equals(displayTerms.getColorePre())?"selected":"" %> >ROSSO</option></select>
		</div>
		<div class="col-md-3">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePost">Colore
				osservato</label><select class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePost"><option
					value=""></option>
				<option value="VERDE" <%="VERDE".equals(displayTerms.getColorePost())?"selected":"" %> >VERDE</option>
				<option value="GIALLO" <%="GIALLO".equals(displayTerms.getColorePost())?"selected":"" %> >GIALLO</option>
				<option value="ARANCIONE" <%="ARANCIONE".equals(displayTerms.getColorePost())?"selected":"" %> >ARANCIONE</option>
				<option value="ROSSO" <%="ROSSO".equals(displayTerms.getColorePost())?"selected":"" %> >ROSSO</option></select>
		</div>

		<div class="col-md-2">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_correttezza">Correttezza</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_correttezza"><option
					value=""></option>
				<option value="C" <%="C".equals(displayTerms.getCorrettezza())?"selected":"" %> >C</option>
				<option value="PC" <%="PC".equals(displayTerms.getCorrettezza())?"selected":"" %> >PC</option>
				<option value="FA" <%="FA".equals(displayTerms.getCorrettezza())?"selected":"" %> >FA</option>
				<option value="MA" <%="MA".equals(displayTerms.getCorrettezza())?"selected":"" %> >MA</option></select>
		</div>
		<div class="col-md-2">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_magnitudo">Magnitudo</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_magnitudo"><option
					value=""></option>
				<option value="+" <%="+".equals(displayTerms.getMagnitudo())?"selected":"" %> >+</option>
				<option value="++" <%="++".equals(displayTerms.getMagnitudo())?"selected":"" %> >++</option>
				<option value="-" <%="-".equals(displayTerms.getMagnitudo())?"selected":"" %> >-</option>
				<option value="--" <%="--".equals(displayTerms.getMagnitudo())?"selected":"" %>  >--</option></select>
		</div>
		<div class="col-md-2">
			<label class="control-label" for="_allerta_verifica_web_AllertaVerificaWebPortlet_localizzazione">Localizzazione</label><select
				class="form-control " style="" name="_allerta_verifica_web_AllertaVerificaWebPortlet_localizzazione"><option
					value=""></option>
				<option value="+" <%="+".equals(displayTerms.getLocalizzazione())?"selected":"" %> >+</option>
				<option value="++" <%="++".equals(displayTerms.getLocalizzazione())?"selected":"" %> >++</option>
				<option value="-" <%="-".equals(displayTerms.getLocalizzazione())?"selected":"" %> >-</option>
				<option value="--" <%="--".equals(displayTerms.getLocalizzazione())?"selected":"" %> >--</option></select>
		</div>

		<div class="col-md-3" style='text-align: center; margin-top: 25px;'>
			<button class="btn btn-primary" id='aggiorna'>Aggiorna</button>
		</div>

		<div class="col-md-3" style='text-align: center; margin-top: 25px;'>
			<button class="btn btn-primary"
				onclick="esportaExcel();return false;" id='aggiorna'>
				Esporta Excel</button>
		</div>

	</div>

</aui:form>


<div class="row">
	<div class="col-12">
		<h2>Elenco verifiche allerte</h2>
		<div class="row"></div>

	</div>

	<liferay-ui:search-container
		searchContainer="<%=verificaSearchContainer%>"
		total="<%=VerificaSearchHelper.getVerificheCount(displayTerms)%>">

		<liferay-ui:search-container-results
			results="<%=VerificaSearchHelper.getVerifiche(displayTerms, verificaSearchContainer.getStart(),
						verificaSearchContainer.getEnd())%>" />

		<liferay-ui:search-container-row
			className="allerta.verifica.model.Verifica" modelVar="ver">

			<liferay-ui:search-container-column-text property="titolo"
				name="Documento" />
			<liferay-ui:search-container-column-text name="Valido da">
				<%=(ver.getDataInizio() != null ? sdf.format(ver.getDataInizio()) : "")%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Stato">
				<%=(ver.getStato() == 0 ? "In compilazione" : (ver.getStato() == 1 ? "Consolidato" : ""))%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Ultima modifica">
				<%=(ver.getModifiedDate() != null && ver.getModifiedDate().after(ver.getCreateDate())
								? sdf.format(ver.getModifiedDate())
								: "")%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Azioni">
				<liferay-ui:icon-menu direction="left-side"
					icon="<%=StringPool.BLANK%>" markupView="lexicon"
					message="<%=StringPool.BLANK%>" showWhenSingleIcon="<%=true%>">


					<c:choose>
						<c:when test="<%=ver.getStato() == 0 && modifica%>">


							<portlet:renderURL var="compilaUrl">
								<portlet:param name="mvcRenderCommandName"
									value="/allertaer/verifica/compila" />
								<portlet:param name="id"
									value="<%=String.valueOf(ver.getId())%>" />
							</portlet:renderURL>
							<liferay-ui:icon message="Modifica"
								url="<%=compilaUrl.toString()%>" />

							<portlet:actionURL var="bloccaUrl"
								name="/allertaer/verifica/consolida">
								<portlet:param name="id"
									value="<%=String.valueOf(ver.getId())%>" />
								<portlet:param name="home" value="1" />
							</portlet:actionURL>
							<liferay-ui:icon message="Consolida"
								url="<%=bloccaUrl.toString()%>" />

						</c:when>


						<c:otherwise>

							<portlet:renderURL var="compilaUrl">
								<portlet:param name="mvcRenderCommandName"
									value="/allertaer/verifica/compila" />
								<portlet:param name="id"
									value="<%=String.valueOf(ver.getId())%>" />
							</portlet:renderURL>

							<liferay-ui:icon message="Consulta"
								url="<%=compilaUrl.toString()%>" />
							<c:choose>
								<c:when test="<%=modifica%>">
									<portlet:actionURL var="sbloccaUrl"
										name="/allertaer/verifica/sblocca">
										<portlet:param name="id"
											value="<%=String.valueOf(ver.getId())%>" />
										<portlet:param name="home" value="1" />

									</portlet:actionURL>
									<liferay-ui:icon message="Sblocca"
										url="<%=sbloccaUrl.toString()%>" />
								</c:when>
							</c:choose>

						</c:otherwise>
					</c:choose>


				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>



		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="<%=true%>" />

	</liferay-ui:search-container>

	<script type="text/javascript">
		function esportaExcel(e) {
			var da = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_dataInvioDa"]')
					.val()
			var a = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_dataInvioA"]')
					.val()
			var zona = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_zona"]')
					.val()
			var evento = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_evento"]')
					.val()
			var colorePre = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePre"]')
					.val()
			var colorePost = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_colorePost"]')
					.val()
			var correttezza = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_correttezza"]')
					.val()
			var magnitudo = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_magnitudo"]')
					.val()
			if (magnitudo) magnitudo = magnitudo.replaceAll("+","plus")
			var localizzazione = $(
					'[name="_allerta_verifica_web_AllertaVerificaWebPortlet_localizzazione"]')
					.val()
			if (localizzazione) localizzazione = localizzazione.replaceAll("+","plus")
			da = da.split(" ")[0]
			a = a.split(" ")[0]
			window.open('/o/report/verifica/excel?datada=' + da + '&dataa=' + a
					+ "&zona=" + zona+ "&evento=" + evento + "&colorePre=" + colorePre + "&colorePost=" + colorePost
					+ "&correttezza=" + correttezza + "&magnitudo=" + magnitudo
					+ "&localizzazione=" + localizzazione, '_blank')
		}
	</script>

</div>