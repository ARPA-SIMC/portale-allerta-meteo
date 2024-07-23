<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page
	import="it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerter.allerta.utils.MessaggioService"%>
<%@page import="it.eng.allerta.messaggio.sindaco.bean.MessaggioBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page
	import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>

<%
	Map<Long, String> organizationIds = msgService.getOrganizations(sindacoConfiguration.organization());
	
	MessaggioBean messaggioBean = (MessaggioBean)renderRequest.getAttribute("messaggioBean");

	if (messaggioBean.sindaco) {
		organizationIds.clear();
		for (Long sito : messaggioBean.comuneDelSindaco.keySet()) {
			String com = messaggioBean.comuneDelSindaco.get(sito);
			Map<Long, String> cids = msgService.getOrganizations(sito);
			
			for (Long grp : cids.keySet()) {
				organizationIds.put(grp,com+" - "+cids.get(grp));
			}
		}
	}


	String canaleSms = sindacoConfiguration.canaleSms(); //si -  no
	String canaleSmsSindaco = sindacoConfiguration.canaleSmsSindaco(); //si -  no
	
%>

<c:set var="canaleSms" value="<%=canaleSms %>" scope="request" />
<c:set var="canaleSmsSindaco" value="<%=canaleSmsSindaco %>" scope="request" />
<c:set var="organizationIds" value="<%=organizationIds %>" scope="request" />

<div class="row">
	<div class="col-12"></div>
</div>

	<h2>A chi &egrave; diretta la comunicazione ?</h2>
	<style>
	.input-checkbox-wrapper {display:inline}
	</style>
	<div class="row">
		<div class="col-12">
			<ul class="list-group">
			<c:forEach items="<%=organizationIds.keySet() %>" var="key">		
				<li class="list-group-item">
				<aui:input type="checkbox"  value="${key}" cssClass="form-check-input organizzazioni ${messaggioBean.hasOrganization(key)?'addChecked':'' }"
					name="selectedOrganization[]" label=""
					checked="${messaggioBean.hasOrganization(key) }"></aui:input>
					<label class="form-check-label">${organizationIds.get(key)}</label>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>





<liferay-util:include page="/parts/header.jsp" servletContext="<%=getServletContext() %>"></liferay-util:include>


<c:if test="${not messaggioBean.sindaco }">
	<div class="row">
		<div class="col-12">
			<h2>Scrivi l'oggetto della comunicazione</h2>
		</div>
		<div class="col-12">
			<aui:input name="obj_mail" cssClass="form-control" label=""
				value="${messaggioBean.obj_mail }"
				placeholder="Inserisci l'oggetto della comunicazione"></aui:input>
		</div>
	</div>
</c:if>



<div class="row">
	<div class="col-12">
		<h2>Testo del messaggio - Email</h2>
	</div>
	<div class="col-9">
		<aui:input name="mex_pc" type="textarea" cssClass="form-control"
			label="" value="${messaggioBean.mex_pc }" 
			placeholder="Scrivi in modo chiaro e sintetico cosa succede e le azioni da intraprendere..."></aui:input>
	</div>
	<div class="col-3">
		<c:if test="${messaggioBean.sindaco }">
		<p>
			<span class="icon i-add-circle"></span> <b> Scrivi solo cosa sta
				per succedere e quale fase hai attivato/disattivato. </b> <br />
		</p>
		<h4>Esempio</h4>
		<p>
		Attesi temporali fino alle 24 di oggi. Attivata fase di attenzione
		<br/><br/>
		Non inserire il nome del tuo comune (verr&agrave; aggiunto in automatico in 
		modo opportuno in base al canale di comunicazione).		
		</p>
		</c:if>
	</div>
</div>


<c:if test="${( not messaggioBean.sindaco and canaleSms == 'si') or (canaleSms == 'si' and canaleSmsSindaco == 'si') }">

	<div class="row">
		<div class="col-12">
			<h2>Testo del messaggio - SMS (max 160 caratteri)</h2>
		</div>
		<div class="col-9">
		<aui:input name="subject" type="textarea" cssClass="form-control inputSubject"
			label="" value="${messaggioBean.subject }" 
			placeholder="Massimo 160 caratteri. Es. «Attesi forti temporali fino alle 24 di oggi. Attivata fase di attenzione.»"></aui:input>
			<br/>
			<span class="icon i-pencil-square-o"></i> Caratteri rimanenti <label id="inputSubject">160</label>
		</div>
		
		<div class="col-3">
			<i class="icon i-info-circle"></i> Indica l'evento atteso e fino a quando si prevede che durerà.
			Esempio:
			<p>
			Indica cosa fare nella fase (attenzione, pre-allarme, allarme) che stai attivando in 
			base al piano protezione civile del tuo comune.
			<br/>
			<br/>
			Sii chiaro, usa parole semplici e adatte alla situazione. 
			</p>
		</div>
	
	</div>

</c:if>


<c:if test="${messaggioBean.sindaco }">
	<div class="row">
		<div class="col-12">
			<h2>Includi informazioni utili per la situazione di rischio attesa</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<ul class="list-group">
				<c:if test="${not empty tabViewWizardBean.idAllertaSaved}">
					<li class="list-group-item">
						<a href="#" >
							Rimuovi
						</a>								
						<div >
							<a target="_blank"
								href="<%=themeDisplay.getPortalURL() %>/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/${messageBean.idAllertaSaved}">
								<span class="icon i-file-o"></span>${messageBean.titoloAllertaSaved}
							</a>
							
						</div>
					</li>
				</c:if>
				
			</ul>
			
				<ul class="list-group">
					<li class="list-group-item list-info-piene" style="display: ${messaggioBean.hasBooleanInfo('piene') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-piene-fiumi">Cosa fare in caso di piene dei fiumi?</span>
    						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('piene');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
  						</label>
					</li>
					<li class="list-group-item list-info-frane" style="display: ${messaggioBean.hasBooleanInfo('frane') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-frane">Cosa fare in caso di frane?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('frane');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    					</span>
					</li>
					<li class="list-group-item list-info-temporali" style="display: ${messaggioBean.hasBooleanInfo('temporali') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-temporali">Cosa fare in caso di temporali?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('temporali');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-vento" style="display: ${messaggioBean.hasBooleanInfo('vento') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-vento">Cosa fare in caso di vento?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('vento');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-mareggiate" style="display: ${messaggioBean.hasBooleanInfo('mareggiate') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-mareggiate">Cosa fare in caso di mareggiate?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('mareggiate');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-neve" style="display: ${messaggioBean.hasBooleanInfo('neve') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-neve">Cosa fare in caso di neve?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('neve');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-ghiaccio" style="display: ${messaggioBean.hasBooleanInfo('ghiaccio') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-pioggia-gelata">Cosa fare in caso di ghiaccio?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('ghiaccio');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-ondateDiCalore" style="display: ${messaggioBean.hasBooleanInfo('ondateDiCalore') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-thermometer-full">Cosa fare in caso di ondate di calore?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('ondateDiCalore');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-incendi" style="display: ${messaggioBean.hasBooleanInfo('incendi') ? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-incendi">Cosa fare in caso di incendi?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('incendi');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					<li class="list-group-item list-info-terremoto " style="display: ${messaggioBean.hasBooleanInfo('terremoto')? '' : 'none'}">
						<label class="form-check-label" >
    						<span class="icon i-terremoto">Cosa fare in caso di terremoto ?</span>
  						</label>
  						<span class="float-right">
    							<a href="#" onclick="removeBooleanInfo('terremoto');return false">
    								<span class="icon icon i-trash-o"></span>
    							</a>
    						</span>
					</li>
					
				</ul>
		
			<button class="btn btn-primary" data-toggle="modal" data-target="#cosaFareModal"
				onclick="return false;">
				Includi altre informazioni Utili
			</button>
			
			<aui:input name="selectBooleanInfo" type="hidden" cssClass="selectBooleanInfo"
				value="${messaggioBean.booleanInfoToStringView() }"></aui:input>
			
		</div>
	</div>
	
</c:if>

<liferay-util:include page="/parts/fileToUpload.jsp" servletContext="<%=getServletContext() %>"></liferay-util:include>

<!-- Modal -->
<div class="modal fade" tabindex="-1" role="dialog" id="cosaFareModal" 
 	aria-labelledby="cosaFareModal" aria-hidden="true">
 	
  <div class="modal-dialog" role="document">
  	
  	<div class="modal-content">
  	
    	<div class="modal-header">
        	<div class="h5 modal-title" id="detail-modal-title">Includi altre informazioni</div>
           	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
               	<span class="icon i-close1" title="Icona del bottone che chiude la finestra modale"></span> 
        	</button>
		</div>
		
        <div class="modal-body">
        	<ul class="list-group">
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="piene" 
							checked="${messaggioBean.hasBooleanInfo('piene') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-piene-fiumi">Cosa fare in caso di piene dei fiumi?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="frane" 
							checked="${messaggioBean.hasBooleanInfo('frane') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-frane">Cosa fare in caso di frane?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="temporali" 
							checked="${messaggioBean.hasBooleanInfo('temporali') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-temporali">Cosa fare in caso di temporali?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true" 
							cssClass="form-check-input selectBooleanInfoCheck" value="vento" 
							checked="${messaggioBean.hasBooleanInfo('vento') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-vento">Cosa fare in caso di vento?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="mareggiate" 
							checked="${messaggioBean.hasBooleanInfo('mareggiate') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-mareggiate">Cosa fare in caso di mareggiate?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="neve" 
							checked="${messaggioBean.hasBooleanInfo('neve') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-neve">Cosa fare in caso di neve?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="ghiaccio" 
							checked="${messaggioBean.hasBooleanInfo('ghiaccio') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-pioggia-gelata">Cosa fare in caso di ghiaccio?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="ondateDiCalore" 
							checked="${messaggioBean.hasBooleanInfo('ondateDiCalore')}"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-thermometer-full">Cosa fare in caso di ondate di calore?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="incendi" 
							checked="${messaggioBean.hasBooleanInfo('incendi')}"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-incendi">Cosa fare in caso di incendi?</span>
  						</label>
  					</div>
        		</li>
        		
        		<li class="list-group-item">
        			<div class="form-check">
  						<aui:input name="selectBooleanInfoCheck[]" type="checkbox" label="" wrappedField="true"
							cssClass="form-check-input selectBooleanInfoCheck" value="terremoto" 
							checked="${messaggioBean.hasBooleanInfo('terremoto ') }"></aui:input>
  						<label class="form-check-label" >
    						<span class="icon i-terremoto">Cosa fare in caso di terremoto?</span>
  						</label>
  					</div>
        		</li>
        		
        		
        	</ul>
        	<br/>
			<p>
			Questi appariranno opportunamente (come testo o link) in base al canale con cui viene ricevuto il messaggio.
			</p>
			
		</div>
        <div class="modal-footer d-flex justify-content-end">
        	<button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
	    </div>
	</div>
  </div>
</div>

<script type="text/javascript">



</script>
