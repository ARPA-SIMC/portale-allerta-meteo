<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.BollettinoParametroSearchContainer"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.AllertaParametroSearchHelper"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.AllertaParametroDisplayTerms"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.AllertaParametroSearchContainer"%>

<%@page
	import="it.eng.allerta.controlpanel.portlet.BollettinoParametroSearchHelper"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.BollettinoParametroDisplayTerms"%>
<%@page
	import="it.eng.allerta.controlpanel.portlet.BollettinoParametroSearchContainer"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.eng.allerta.controlpanel.portlet.ControlPanelBean"%>
<%@ include file="/init.jsp"%>



<%
	ControlPanelBean bean = new ControlPanelBean(request);
	List<String> sezioni = new ArrayList<String>();
	sezioni.add("Generale");
	sezioni.add("SMS");
	sezioni.add("Dati in tempo reale");
	sezioni.add("Log");
	sezioni.add("Query");
	sezioni.add("Parametri Allerta");
	sezioni.add("Parametri Monitoraggio");
	sezioni.add("Deploy");

	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();

	AllertaParametroSearchContainer apSearchContainer = new AllertaParametroSearchContainer(
			renderRequest, portletURL);
	AllertaParametroDisplayTerms displayTerms = (AllertaParametroDisplayTerms) apSearchContainer
			.getDisplayTerms();
	
	BollettinoParametroSearchContainer bpSearchContainer = new BollettinoParametroSearchContainer(
			renderRequest, portletURL);
	BollettinoParametroDisplayTerms bpDisplayTerms = (BollettinoParametroDisplayTerms) bpSearchContainer
			.getDisplayTerms();
	
	SearchContainer smsSC = bean.getSMSSearchContainer(renderRequest, portletURL,"erroriSms1");
	SearchContainer smsSC2 = bean.getSMSSearchContainer(renderRequest, portletURL,"erroriSms2");
	SearchContainer invioSC = bean.getInvioSearchContainer(renderRequest, portletURL, "inviiNonRicevuti");
%>

					<portlet:renderURL var="compilaUrl">
						<portlet:param name="mvcRenderCommandName" value="/controlpanel/render"/>
					</portlet:renderURL>
					
					<portlet:actionURL var="inviaSMSURL" name="/controlpanel/inviasms">
						<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>			
						<portlet:param name="id" value="SMS" />			
						
					</portlet:actionURL>


		<script type="text/javascript">
			function <portlet:namespace/>submitAllertaForm(actionUrl) {
			document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
			document.forms.<portlet:namespace/>fmCompila.submit();
	          
			}
		</script>
		
		<style>
		.verde {
			border: 1px solid green;
   			 padding: 7px;
    		border-radius: 5px;
    		background-color: #ddffdd;
		}
		.giallo {
			border: 1px solid yellow;
   			 padding: 7px;
    		border-radius: 5px;
    		background-color: #ffffbb;
		}
		.arancio {
			border: 1px solid orange;
   			 padding: 7px;
    		border-radius: 5px;
    		background-color: #ffeeaa;
		}
		.rosso {
			border: 3px solid red;
   			 padding: 7px;
    		border-radius: 5px;
    		background-color: #ffeeee;
		}
		
		.grigio {
			border: 1px solid grey;
   			 padding: 7px;
    		border-radius: 5px;
    		background-color: #dddddd;
		}
		</style>
		
		

<aui:form method="post" name="fmCompila" id="fmCompila"
	cssClass="controlpanel-form">

	<div class="row">
		<div class="col-4 form-group">
			<label class="control-label">Sezione del Pannello di Controllo</label> <select id="<portlet:namespace/>id"
				onChange="<portlet:namespace/>submitAllertaForm('<%=compilaUrl.toString()%>')"
				name="<portlet:namespace/>id" class="form-control">
				<c:set var="sez" value="<%=bean.getActivePanel() %>" />
				<c:set var="sezioni" value="<%=sezioni %>" />
				<c:forEach var="op" items="${sezioni}">
				

				
					<option ${op == sez? 'selected="true"' : '' } 
					value="${op}">${op}</option>
				</c:forEach>
				

			</select>
		</div>
	</div>
	
	<c:if test="<%="Dati in tempo reale".equals(bean.getActivePanel()) %>">
	
	<%
		int dati10 = bean.getDatiTempoRealeInMinuti(10);
		int dati60 = bean.getDatiTempoRealeInMinuti(60);
		boolean anomalia = dati10==0 || dati60<3500;
	
	%>
	
	<div class="row">
			<div class="col-12 form-group">
				<label class="control-label">Dati arrivati negli ultimi 10 minuti:</label>
				<%=dati10 %>
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				<label class="control-label">Dati arrivati negli ultimi 60 minuti:</label>
				<%=dati60 %>
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				In condizioni normali arrivano circa <b>5000</b> dati ogni ora, e nuovi dati ogni 1-3 minuti.
				I numeri possono essere pi&ugrave; alti in caso di recupero di rallentamenti precedenti.
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				La situazione attuale &egrave; <b><%=anomalia?"ANOMALIA":"NORMALE" %></b>.
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
			<c:if test="<%=anomalia && dati10==0 %>">
				Non arriva alcun dato sul web service. Verificare con ARPAE lo stato del servizio.
			</c:if>
			<c:if test="<%=anomalia && dati10>0 %>">
				Arrivano dati sul web service, ma troppo pochi. Verificare con ARPAE lo stato del servizio.
			</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				Per ulteriori controlli, si possono confrontare le mappe dei sensori sul portale con quelle presenti
				sul sito ARPAE alla stessa ora:
				<ul>
				<li><a target="_blank" href="/livello-idrometrico">Idrometri sul portale</a> vs <a target="_blank" href="https://www.arpae.it/it/temi-ambientali/acqua/dati-acque/acque-superficiali/dati-idrometrici-in-tempo-reale-1">Idrometri su sito ARPAE</a></li>
				<li><a target="_blank" href="/precipitazioni">Pluviometri sul portale</a> vs <a target="_blank" href="https://www.arpae.it/it/temi-ambientali/meteo/dati-e-osservazioni/dati-in-tempo-reale">Pluviometri e altro su sito ARPAE</a> (selezionare 'Precipitazione cumulata su 1h' nel menu presente nella barra della mappa)</li>
				</ul>
				Tenendo presente che l'elenco dei sensori non coincide esattamente sui due siti, l'assenza di dati nelle stesse zone alla stessa ora &egrave; indizio forte di ritardo dei dati all'origine.
		
			
			</div>
		</div>
	</c:if>


	<c:if test="<%="Generale".equals(bean.getActivePanel()) %>">
		<div class="row">
			<div class="col-12 form-group">
				<label class="control-label">Nodo di questa sessione:</label>
				<%=bean.getComputer()%>
				(<%=bean.getNodo()%>)
			</div>
		</div>
				<div class="row">
			<div class="col-12 form-group">
				<label class="control-label">Liferay home:</label>
				<%=bean.getHome()%>
			
			</div>
		</div>
	</c:if>
	
	<c:if test="<%="Query".equals(bean.getActivePanel()) %>">
		<div class="row">
			<div class="col-12 form-group">
				<c:if test="<%=bean.getRisultatiQuery()!=null %>">
					<h3>Risultati query</h3>
					<table>
					<c:set var="risultatiQuery" value="<%=bean.getRisultatiQuery() %>" />
					<c:forEach var="resultRow" items="${risultatiQuery}">
						<tr>
							<c:forEach var="resultCol" items="${resultRow}">
								<td>
									${resultCol}
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
			<label class="control-label">Query</label> 
			<input value="<%=bean.getDbQuery() %>" type="text" id="<portlet:namespace/>dbQuery" name="<portlet:namespace/>dbQuery" />
			
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=compilaUrl.toString()%>')"
				class="btn btn-primary">Esegui</button>
			</div>
		</div>
	</c:if>

	<c:if test="<%="Log".equals(bean.getActivePanel()) %>">
		<div class="row">
			<div class="col-12 form-group">
			<%=bean.getLogOutput() %>
			</div>
		</div>
		
		<div class="row">
		<div class="col-6 form-group">
			<label class="control-label">Comando da eseguire</label> <select id="<portlet:namespace/>comandoLog"
				name="<portlet:namespace/>comandoLog" class="form-control">
				<option value="grep" <%=bean.getLogCmd().equals("grep")?" selected ":"" %> >Ricerca stringa in log</option>
				<option value="sed" <%=bean.getLogCmd().equals("sed")?" selected ":"" %> >Visualizza intervallo di righe in log</option>
				<option value="ls" <%=bean.getLogCmd().equals("ls")?" selected ":"" %> >Elenco log nella directory generale</option>
				<option value="rm" <%=bean.getLogCmd().equals("rm")?" selected ":"" %> >Elimina log pi&ugrave; vecchi di 7 giorni</option>
			</select>
		</div>
		<div class="col-6 form-group">
			<label class="control-label">Nodo su cui eseguire</label> <select id="<portlet:namespace/>nodoLog"
				
				name="<portlet:namespace/>nodoLog" class="form-control">
				<option value="nodo1" <%=bean.getLogNodo().equals("nodo1")?" selected ":"" %> >Nodo 1</option>
				<option value="nodo2" <%=bean.getLogNodo().equals("nodo2")?" selected ":"" %> >Nodo 2</option>
				<c:if test="<%=bean.getNodo().equals("nodo non riconosciuto") %>">
				<option value="nodoX" <%=bean.getLogNodo().equals("nodoX")?" selected ":"" %> >Questo nodo</option>
				</c:if>
			</select>
		</div>
	</div>
	
		<div class="row">
			<div class="col-3 form-group">
			<label class="control-label">Parametro 1 (data del log)</label>
			<input value="<%=bean.getLogParam1() %>" type="text" id="<portlet:namespace/>logParam1" name="<portlet:namespace/>logParam1" />
			</div>

			<div class="col-3 form-group">
			<label class="control-label">Parametro 2 (testo da cercare o riga iniziale)</label>
			<input value="<%=bean.getLogParam2() %>" type="text" id="<portlet:namespace/>logParam2" name="<portlet:namespace/>logParam2" />
			</div>

			<div class="col-3 form-group">
			<label class="control-label">Parametro 3 (riga finale)</label>
			<input value="<%=bean.getLogParam3() %>" type="text" id="<portlet:namespace/>logParam3" name="<portlet:namespace/>logParam3" />
			</div>
		</div>
	
		<div class="row">
			<div class="col-12 form-group">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=compilaUrl.toString()%>')"
				class="btn btn-primary">Esegui</button>
			</div>
		</div>

	</c:if>

	<c:if test="<%="Parametri Allerta".equals(bean.getActivePanel()) %>">
		<div class="row">
			<div class="col-12 form-group">
			<liferay-ui:search-container searchContainer="<%=apSearchContainer%>"
				total="<%=AllertaParametroSearchHelper.getParametroCount(displayTerms)%>">

				<liferay-ui:search-container-results
					results="<%=AllertaParametroSearchHelper.getParametros(displayTerms,
							apSearchContainer.getStart(),
							apSearchContainer.getEnd())%>" />

				<liferay-ui:search-container-row
					className="it.eng.allerter.model.AllertaParametro" modelVar="ver">

					<liferay-ui:search-container-column-text property="parametroId"
						name="parametroId" orderable="false"
						orderableProperty="parametroId" />
					<liferay-ui:search-container-column-text name="valore"
						orderable="false" orderableProperty="valore">
						<textarea id="ap_<%=ver.getParametroId() %>"
							name="ap_<%=ver.getParametroId() %>" 
							style="min-width: 400px">${ver.valore}</textarea>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="Azioni">
						<liferay-ui:icon-menu direction="left-side"
							icon="<%=StringPool.BLANK%>" markupView="lexicon"
							message="<%=StringPool.BLANK%>" showWhenSingleIcon="<%=true%>">

							<portlet:actionURL var="compilaApUrl"
								name="/controlpanel/ap/update">
								<portlet:param name="id"
									value="<%=String.valueOf(ver.getParametroId())%>" />
							</portlet:actionURL>
							<liferay-ui:icon message="Modifica"
								url="<%=compilaApUrl.toString()%>" />

						</liferay-ui:icon-menu>
					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%=true%>" />

			</liferay-ui:search-container>
			</div>
		</div>

	</c:if>

	<c:if test="<%="Parametri Monitoraggio".equals(bean.getActivePanel()) %>">
	<div class="row">
			<div class="col-12 form-group">
		<liferay-ui:search-container
				searchContainer="<%=bpSearchContainer %>"
				total="<%=BollettinoParametroSearchHelper.getParametroCount(bpDisplayTerms)%>">

				<liferay-ui:search-container-results
					results="<%=BollettinoParametroSearchHelper.getParametros(bpDisplayTerms,
							bpSearchContainer.getStart(),
							bpSearchContainer.getEnd())%>" />

				<liferay-ui:search-container-row
					className="it.eng.bollettino.model.BollettinoParametro"
					modelVar="ver">

					<liferay-ui:search-container-column-text property="parametroId"
						name="parametroId" orderable="false"
						orderableProperty="parametroId" />
					<liferay-ui:search-container-column-text name="valore"
						orderable="false" orderableProperty="valore">
						<textarea id="bp_<%=ver.getParametroId() %>"
							name="bp_<%=ver.getParametroId() %>" 
							style="min-width: 400px">${ver.valore}</textarea>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="Azioni">
						<liferay-ui:icon-menu direction="left-side"
							icon="<%=StringPool.BLANK%>" markupView="lexicon"
							message="<%=StringPool.BLANK%>" showWhenSingleIcon="<%=true%>">

							<portlet:actionURL var="compilaBpUrl"
								name="/controlpanel/bp/update">
								<portlet:param name="id"
									value="<%=String.valueOf(ver.getParametroId())%>" />
							</portlet:actionURL>
							<liferay-ui:icon message="Modifica"
								url="<%=compilaBpUrl.toString()%>" />

						</liferay-ui:icon-menu>
					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%=true%>" />

			</liferay-ui:search-container>
		</div>
		</div>

	</c:if>

	<c:if test="<%="SMS".equals(bean.getActivePanel()) %>">
	
	<%
	
	String sottoTab = "Informazioni";
	
	if (bean.getSmsAttempt()!=null && !bean.getSmsAttempt().equals(""))
		sottoTab = "Test invio";
	
	if (bean.getRicevutaAttempt()!=null && !bean.getRicevutaAttempt().equals(""))
		sottoTab = "Test ricezione";
	
	%>
	
	<liferay-ui:tabs value="<%=sottoTab %>" refresh="false" names="Informazioni,Test invio,Test ricezione">
	
	<liferay-ui:section>
	<div class="row">
			<div class="col-12 form-group">
		<%=bean.getMessaggio1() %>
		</div></div>
		
		<div class="row">
			<div class="col-12 form-group">
			<div class="<%=bean.getColoreRicevute() %>">
		<%=bean.getRicevuta1() %>
		
		<c:if test="<%=bean.getInviiNonRicevuti()>0 %>">

		<liferay-ui:search-container
				searchContainer="<%=invioSC %>"
				curParam="inviiNonRicevuti"
				total="<%=bean.getInviiNonRicevuti() %>">

				<liferay-ui:search-container-results
					results="<%=bean.getInviiNonRicevuti(
							invioSC.getStart(),
							invioSC.getEnd())%>" />

				<liferay-ui:search-container-row
					className="it.eng.allerta.controlpanel.portlet.InvioBean"
					modelVar="ver">

					<liferay-ui:search-container-column-text property="tipo"
						name="tipo" orderable="false"
						orderableProperty="tipo" />
					<liferay-ui:search-container-column-text property="sottotipo"
						name="sottotipo" orderable="false"
						orderableProperty="sottotipo" />
					<liferay-ui:search-container-column-text property="param"
						name="param" orderable="false"
						orderableProperty="param" />
					<liferay-ui:search-container-column-text property="testo"
						name="testo" orderable="false"
						orderableProperty="testo" />
					<liferay-ui:search-container-column-text property="inviati"
						name="inviati" orderable="false"
						orderableProperty="inviati" />
					<liferay-ui:search-container-column-text property="ricevuti"
						name="ricevuti" orderable="false"
						orderableProperty="ricevuti" />
					<liferay-ui:search-container-column-text property="tasso"
						name="tasso" orderable="false"
						orderableProperty="tasso" />
					<liferay-ui:search-container-column-text property="esempi"
						name="esempi" orderable="false"
						orderableProperty="esempi" />
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%=true%>" />

			</liferay-ui:search-container>
		</c:if>	
		</div>
		</div>
		</div>
		
		<div class="row">
			<div class="col-12 form-group">
		<div class="grigio"><%=bean.getMessaggio2() %></div>
		</div></div>
		<div class="row">
			<div class="col-12 form-group">
		<div class="<%=bean.getErrori()>0?"rosso":"verde" %>"><%=bean.getMessaggio3() %>
		<c:if test="<%=bean.getErrori()>0 %>">
		<liferay-ui:search-container
				searchContainer="<%=smsSC %>"
				curParam="erroriSms1"
				total="<%=bean.getErrori() %>">

				<liferay-ui:search-container-results
					results="<%=bean.getErrori(
							smsSC.getStart(),
							smsSC.getEnd())%>" />

				<liferay-ui:search-container-row
					className="it.eng.allerter.model.SMS"
					modelVar="ver">

					<liferay-ui:search-container-column-text property="numero"
						name="numero" orderable="false"
						orderableProperty="numero" />
					<liferay-ui:search-container-column-text property="testo"
						name="testo" orderable="false"
						orderableProperty="testo" />
					<liferay-ui:search-container-column-text property="timestamp"
						name="timestamp" orderable="false"
						orderableProperty="timestamp" />
					<liferay-ui:search-container-column-text property="codiceErrore"
						name="codiceErrore" orderable="false"
						orderableProperty="codiceErrore" />
					<liferay-ui:search-container-column-text property="dataInvio"
						name="dataInvio" orderable="false"
						orderableProperty="dataInvio" />
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%=true%>" />

			</liferay-ui:search-container>
		</c:if>
		</div>
		</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
		<div class="<%=bean.getErrori2()>0?"rosso":"verde" %>"><%=bean.getMessaggio4() %>

		<c:if test="<%=bean.getErrori2()>0 %>">
		<liferay-ui:search-container
				searchContainer="<%=smsSC2 %>"
				curParam="erroriSms2"
				total="<%=bean.getErrori2() %>">

				<liferay-ui:search-container-results
					results="<%=bean.getErrori2(
							smsSC2.getStart(),
							smsSC2.getEnd())%>" />

				<liferay-ui:search-container-row
					className="it.eng.allerter.model.SMS"
					modelVar="ver">

					<liferay-ui:search-container-column-text property="numero"
						name="numero" orderable="false"
						orderableProperty="numero" />
					<liferay-ui:search-container-column-text property="testo"
						name="testo" orderable="false"
						orderableProperty="testo" />
					<liferay-ui:search-container-column-text property="timestamp"
						name="timestamp" orderable="false"
						orderableProperty="timestamp" />
					<liferay-ui:search-container-column-text property="codiceErrore"
						name="codiceErrore" orderable="false"
						orderableProperty="codiceErrore" />
					<liferay-ui:search-container-column-text property="dataInvio"
						name="dataInvio" orderable="false"
						orderableProperty="dataInvio" />
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%=true%>" />

			</liferay-ui:search-container>
		</c:if>
		</div>
		</div>
		</div>
		</liferay-ui:section>
		<liferay-ui:section>
			<c:if test="<%=bean.getSmsError()!=null && !bean.getSmsError().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group rosso">
       		<label  class="control-label">Eccezione durante la connessione:</label><br/>
       		<%=bean.getSmsError() %>
       		</div>
       		</div>
			</c:if>
			
			<c:if test="<%=bean.getSmsCode()!=null && !bean.getSmsCode().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Codice HTTP della risposta:</label><br/>
       		<span style="color:<%="200".equals(bean.getSmsCode())?"green":"red"%>"><%=bean.getSmsCode() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getSmsContent()!=null && !bean.getSmsContent().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Testo completo della risposta:</label><br/>
       		<span><%=bean.getSmsContent() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getSmsResponse()!=null && !bean.getSmsResponse().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Codice applicativo della risposta:</label><br/>
       		<span style="color:<%="OK".equals(bean.getSmsResponse())?"green":"red" %>"><%=bean.getSmsResponse() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getSmsMessage()!=null && !bean.getSmsMessage().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Messaggio associato alla risposta:</label><br/>
       		<span><%=bean.getSmsMessage() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getSmsTimestamp()!=null && !bean.getSmsTimestamp().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Timestamp assegnato a questo SMS:</label><br/>
       		<span style="color:green"><%=bean.getSmsTimestamp() %></span>
       		</div>
       		</div>
       		</c:if>
       		<c:if test="<%=bean.getSmsAttempt()!=null && !bean.getSmsAttempt().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Risultato complessivo della richiesta:</label><br/>
       			<c:if test="<%=bean.getSmsTimestamp()!=null && !bean.getSmsTimestamp().equals("") %>">
       				<span style="color:green">SUCCESSO</span> (puoi usare questo timestamp per verificare la ricevuta nel tab successivo)
       			</c:if>
       			<c:if test="<%=bean.getSmsTimestamp()==null || bean.getSmsTimestamp().equals("") %>">
       				<span style="color:red">FALLIMENTO</span>
       			</c:if>
       		</div>
       		</div>
			</c:if>
			<div class="row">
       		<div class="col-12 form-group">
       		Invia un SMS per visualizzare esplicitamente la risposta del server Telecom. 
       		I messaggi creati con questa interfaccia sono spediti immediatamente e non sono salvati sul portale.
       		</div>
       		</div>
			<div class="row">
       		<div class="col-6 form-group">
			<label class="control-label">Numero (senza spazi)</label>
			<input id="<portlet:namespace/>testInvioNumero" type="text" name="<portlet:namespace/>testInvioNumero" value="" class="form-control">
			</div>
			<div class="col-6 form-group">
			<label class="control-label">Testo</label>
			<input id="<portlet:namespace/>testInvioTesto" type="text" name="<portlet:namespace/>testInvioTesto" value="" class="form-control">
			</div>
       </div>
      <aui:button-row>
       	<button id="inviasms" name="inviasms" type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=compilaUrl.toString()%>')"
				class="btn btn-primary">Invia SMS</button>
      </aui:button-row>
			
		
		
		</liferay-ui:section>
		<liferay-ui:section>
		
		<c:if test="<%=bean.getRicevutaError()!=null && !bean.getRicevutaError().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group rosso">
       		<label  class="control-label">Eccezione durante la connessione:</label><br/>
       		<%=bean.getRicevutaError() %>
       		</div>
       		</div>
			</c:if>
			
			<c:if test="<%=bean.getRicevutaCode()!=null && !bean.getRicevutaCode().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Codice HTTP della risposta:</label><br/>
       		<span style="color:<%="200".equals(bean.getRicevutaCode())?"green":"red"%>"><%=bean.getRicevutaCode() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getRicevutaContent()!=null && !bean.getRicevutaContent().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Testo completo della risposta:</label><br/>
       		<span><%=bean.getRicevutaContent() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getRicevutaResponse()!=null && !bean.getRicevutaResponse().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Codice applicativo della risposta:</label><br/>
       		<span style="color:<%="OK".equals(bean.getRicevutaResponse())?"green":"red" %>"><%=bean.getRicevutaResponse() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getRicevutaMessage()!=null && !bean.getRicevutaMessage().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Messaggio associato alla risposta:</label><br/>
       		<span><%=bean.getRicevutaMessage() %></span>
       		</div>
       		</div>
			</c:if>
			<c:if test="<%=bean.getRicevutaTimestamp()!=null && !bean.getRicevutaTimestamp().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Timestamp assegnato a questo SMS:</label><br/>
       		<span style="color:green"><%=bean.getRicevutaTimestamp() %></span>
       		</div>
       		</div>
       		</c:if>
       		<c:if test="<%=bean.getRicevutaAttempt()!=null && !bean.getRicevutaAttempt().equals("") %>">
				<div class="row">
       		<div class="col-12 form-group">
       		<label  class="control-label">Risultato complessivo della richiesta:</label><br/>
       			<c:if test="<%="OK".equals(bean.getRicevutaResponse()) && bean.getRicevutaData()!=null && !bean.getRicevutaData().equals("n/d") && bean.getRicevutaEsito()!=null && bean.getRicevutaEsito().equals("Ricevuto") %>">
       				<span style="color:green">SUCCESSO COMPLETO</span> (messaggio ricevuto)
       			</c:if>
       			<c:if test="<%="OK".equals(bean.getRicevutaResponse()) && bean.getRicevutaData()!=null && !bean.getRicevutaData().equals("n/d") && bean.getRicevutaEsito()!=null && bean.getRicevutaEsito().equals("Non Ricevuto") %>">
       				<span style="color:orange">SUCCESSO DELLA CHIAMATA MA SMS NON RECAPITATO</span> (la ricevuta esiste e certifica il mancato invio; il cellulare potrebbe essere stato spento o inattivo per tutto il tempo.)
       			</c:if>
       			<c:if test="<%="OK".equals(bean.getRicevutaResponse()) && (bean.getRicevutaData()==null || bean.getRicevutaData().equals("n/d")) && (bean.getRicevutaEsito()!=null && bean.getRicevutaEsito().equals("Non Ricevuto")) %>">
       				<span style="color:orange">SUCCESSO DELLA CHIAMATA MA RICEVUTA NON DISPONIBILE</span> (tentativo di invio ancora in corso, il cellulare potrebbe essere spento o non raggiungibile; Telecom continua a provare.)
       			</c:if>
       			<c:if test="<%="OK".equals(bean.getRicevutaResponse()) && (bean.getRicevutaData()==null || bean.getRicevutaData().equals("n/d")) && (bean.getRicevutaEsito()!=null && !bean.getRicevutaEsito().contains("Ricevuto")) %>">
       				<span style="color:orange">POTENZIALE PROBLEMA</span> (Il messaggio non risulta ne' ricevuto ne' non ricevuto: potenzialmente preso in carico dal server ma non spedito, potrebbe essere indicazione di un problema Telecom.)
       			</c:if>
       			<c:if test="<%=bean.getRicevutaResponse()==null || !bean.getRicevutaResponse().equals("OK") %>">
       				<span style="color:red">FALLIMENTO</span> (codice risposta diverso da OK)
       			</c:if>
       		</div>
       		</div>
			</c:if>
			<div class="row">
       		<div class="col-12 form-group">
       		Chiedi la ricevuta per un SMS precedentemente inviato, inserendo il codice timestamp che Telecom ha assegnato al messaggio.
       		</div>
       		</div>
			<div class="row">
       		<div class="col-6 form-group">
			<label class="control-label">Timestamp</label>
			<input id="<portlet:namespace/>testRicevutaTimestamp" type="text" name="<portlet:namespace/>testRicevutaTimestamp" value="" class="form-control">
			</div>
			
       </div>
      <aui:button-row>
       	<button id="ricevutasms" name="ricevutasms" type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=compilaUrl.toString()%>')"
				class="btn btn-primary">Chiedi ricevuta SMS</button>
      </aui:button-row>
		
		
		</liferay-ui:section>
		</liferay-ui:tabs>
	</c:if>
	

	
</aui:form>

	<c:if test="<%="Deploy".equals(bean.getActivePanel()) %>">
	
		<portlet:actionURL var="submitFileAction" name="/controlpanel/submitFile">
		</portlet:actionURL>
		<form action="<%= submitFileAction %>" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-12 form-group">
				<label class="control-label" for="filex">File da deployare su altro nodo</label>
				<input type="file" id="filex" name='<portlet:namespace />file' size="50" />
			</div>
		</div>
		<div class="row">
			<div class="col-12 form-group">
				<button id="deployfile" name="deployfile" type="submit"
				class="btn btn-primary">Deploy</button>
			</div>
		</div>
		</form>
	
	</c:if>