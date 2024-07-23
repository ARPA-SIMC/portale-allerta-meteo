<%@page import="it.eng.allerter.model.Allerta"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="allerta.verifica.model.UtenteLavoro"%>
<%@page import="allerta.catasto.model.Segnalazione"%>
<%@page import="allerta.verifica.web.bean.GiornoFenomenoRiga"%>
<%@page import="allerta.verifica.web.bean.GiornoFenomeno"%>
<%@page import="allerta.verifica.web.constants.CostantiVerificaAllerte"%>
<%@page import="allerta.verifica.web.bean.CostruttoreVerificaDato"%>
<%@page import="allerta.verifica.web.bean.RigaPrecipitazioni"%>
<%@page import="allerta.verifica.web.bean.GiornoPrecipitazioni"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchHelper"%>
<%@page import="allerta.verifica.web.bean.VerificaDisplayTerms"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchContainer"%>
<%@page import="allerta.verifica.web.bean.VerificaAllertaBean"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>

<%

long allertaId = ParamUtil.getLong(request, "id");
VerificaAllertaBean bean = new VerificaAllertaBean(allertaId,request);

Allerta aaa = AllertaLocalServiceUtil.fetchAllerta(allertaId);

String fenom = "";
if (aaa!=null) fenom = aaa.getTitolo();
if (fenom!=null) {
	if (fenom.endsWith(".")) fenom = fenom.substring(0, fenom.length()-1);
	int indd = fenom.lastIndexOf(":");
	if (indd>0) {
		fenom = fenom.substring(indd+1);
		fenom = fenom.trim();
	}
} else fenom = "";

User u = PortalUtil.getUser(request);
long[] rol = u.getRoleIds();
boolean modifica = false;
int k;
if (rol!=null) {
	for (k=0; k<rol.length; k++)
		if (rol[k]==1993255 || rol[k]==20161 || rol[k]==168321) modifica=true;
}

String disabled = bean.getVerifica().getStato()==1 || !modifica?" disabled ":"";
boolean readonly = bean.getVerifica().getStato()==1 || !modifica;

SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

%>

<style>
	.tooltip2 {
    	position: relative;
    	display: inline-block;
    	font-size: x-large;
    	padding: 5px;
	}
	
	.tooltip2 .tooltiptext {
	    visibility: hidden;
	    width: 240px;
	    background-color: #555;
	    color: #fff;
	    text-align: center;
	    border-radius: 6px;
	    padding: 5px 0;
	    position: absolute;
	    z-index: 1;
	    bottom: 125%;
	    left: 50%;
	    margin-left: -120px;
	    opacity: 0;
	    transition: opacity 0.3s;
	    font-size: initial;
	    font-family:"Titillium Web";
	}
	
	.tooltip2:hover {
		color:#0C6AAF;
	}
	
	.tooltip2:hover .tooltiptext {
	    visibility: visible;
	    opacity: 1;
	}
	
	.datocontainer {
		display:flex;
	}
	
	.ripristina {
		font-weight:bold;
	}

</style>

<c:set value="<%=bean%>" var="bean" scope="request"></c:set>
<portlet:actionURL var="salvaURL" name="/allertaer/verifica/salva">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
		<portlet:param name="direzione" value=""/>	
	</portlet:actionURL>
	<portlet:actionURL var="salvaIndietroURL" name="/allertaer/verifica/salva">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>	
		<portlet:param name="direzione" value="indietro"/>		
	</portlet:actionURL>
	<portlet:actionURL var="salvaAvantiURL" name="/allertaer/verifica/salva">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>	
		<portlet:param name="direzione" value="avanti"/>		
	</portlet:actionURL>
	<portlet:actionURL var="consolidaURL" name="/allertaer/verifica/consolida">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>
	<portlet:actionURL var="sbloccaURL" name="/allertaer/verifica/sblocca">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>

<div class="row">
<div class="col-6 form-group">
<h3><%=bean.getVerifica().getTitolo() %></h3>
</div>
<div class="col-2 form-group">
<button type="button" <%=(bean.isFirst()?"disabled":"") %> onclick="<portlet:namespace/>submitAllertaForm('<%=salvaIndietroURL.toString()%>')"
				class="btn btn-primary">Precedente</button>
</div>
<div class="col-2 form-group">
<button type="button" <%=(bean.isLast()?"disabled":"") %> onclick="<portlet:namespace/>submitAllertaForm('<%=salvaAvantiURL.toString()%>')"
				class="btn btn-primary">Successivo</button>
</div>
<div class="col-2 form-group">
<button type="button" onclick="window.open('/o/report/verifica-settimana?datada=<%=bean.getDataInizioSettimana() %>','_blank')"
				class="btn btn-primary">Report settimanale</button>
</div>
</div>

<aui:form method="post" name="fmCompila" id="fmCompila" cssClass="verifica-form">

<input type="hidden" name="id" value="<%=allertaId%>">

<% if (!bean.getAltriWrite().isEmpty()) { %>
Attivit&agrave; recente in scrittura: 

<%
	for (UtenteLavoro ull : bean.getAltriWrite()) {
		%><%="<b>"+ull.getUtente()+"</b> alle "+sdf.format(ull.getTs())+"; " %><%
	} 

	%><br/><br/><%

} %>

<% if (!bean.getAltriRead().isEmpty()) { %>
Attivit&agrave; recente in lettura: 

<%
	for (UtenteLavoro ull : bean.getAltriRead()) {
		%><%="<b>"+ull.getUtente()+"</b> alle "+sdf.format(ull.getTs())+"; " %><%
	} 

	%><br/><br/><%

} %>

<liferay-ui:tabs value="Generale" refresh="false" names="Generale,Precipitazioni,Fenomeni,Valutazione">
	<liferay-ui:section>
	  <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Fenomeni</label>
			<input disabled id="fenomRO" type="text" name="fenomRO" value="<%=fenom %>" class="form-control">
			</div>
       </div>
	<% for (GiornoPrecipitazioni gf : bean.getGiornoPrecipitazioni()) { %>
       <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Fenomeni <%=new SimpleDateFormat("dd/MM/yyyy").format(gf.getGiorno()) %></label>
			<%=CostruttoreVerificaDato.getDataRepresentation(gf.getFenomeniGiorno(), readonly, true) %>
			</div>
		
       </div>
    <% } %>
    	<div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Descrizione meteo</label>
			<div><%=bean.getDescrizioneMeteo() %></div>
			</div>
		
       </div>
       <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Fenomeni descritti</label>
			<input <%=disabled%> id="fenomeniDescritti" type="text" name="fenomeniDescritti" value="${bean.verifica.fenomeniDescritti}" class="form-control">
			</div>
		
       </div>
       <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Note</label>
			<textarea <%=disabled%> id="note" style="height: 100px" name="note" class="form-control" >${bean.verifica.note}</textarea>
			</div>
		
       </div>
    </liferay-ui:section>
    <liferay-ui:section>
        <% for (GiornoPrecipitazioni gp : bean.getGiornoPrecipitazioni()) {
        	Date d = gp.getGiorno();
        	%>
        
        <h5><%=new SimpleDateFormat("dd/MM/yyyy").format(d) %></h5>
        
        <table class="table table-bordered table-striped table-hover">
        	<thead class="table-columns">
        		<tr>
        			<th class="table-first-header">Zona</th>
        			<th>Osservate 24h</th>
        			<th>Previste 24h</th>
        			<th>Note</th>
        		</tr>
        	</thead>
        	
        	<tbody class="table-data">
        	
        		<% for (RigaPrecipitazioni rp : gp.getPrecipitazioni()) { %>
        		
        			<tr>
        				<td class="table-cell first">
        					<%=rp.getZona() %>
        				</td>
        				<td class="table-cell">
        					<%=CostruttoreVerificaDato.getSelect(rp.getOsservate(), CostantiVerificaAllerte.PRECIPITAZIONI, CostantiVerificaAllerte.PRECIPITAZIONI, readonly, true) %>
        				</td>
        				<td class="table-cell">
        					<%=CostruttoreVerificaDato.getSelect(rp.getPreviste(),CostantiVerificaAllerte.PRECIPITAZIONI, CostantiVerificaAllerte.PRECIPITAZIONI, readonly, true) %>
        				</td>
        				<td class="table-cell">
        					<%=CostruttoreVerificaDato.getInputText(rp.getNote(), readonly, true) %>
        				</td>
        			</tr>
        		
        		<% } %>
        	
        	</tbody>
        </table>
        <br/><br/>
        
        <% } %>
    </liferay-ui:section>
    <liferay-ui:section>
    <div class="row">
       	<div class="col-3 form-group">
   		 <label class="control-label">Fenomeno selezionato</label>
    	<%=CostruttoreVerificaDato.getEventoMenu(bean.getTuttiDati(), "menuEvento1", bean.getEventoSelezionato1(), "cambiaMenu(this)") %>
        </div>
      </div>
        <br/><br/>
        <%
         for (GiornoFenomeno gf : bean.getGiornoFenomeni()) {
        	 
        	 String colonneCustom[] = CostantiVerificaAllerte.EVENTI_COLONNE.get(""+gf.getEvento());
        	 boolean visibile = gf.getEvento()==bean.getEventoSelezionato1();
        	 
        	 %>
        	 <div style="<%=visibile?"":"display:none" %>" class="evento-base evento-<%=gf.getEvento() %>">
        	 <h5><%=new SimpleDateFormat("dd/MM/yyyy").format(gf.getGiorno()) %> dalle ore <%=new SimpleDateFormat("HH:mm").format(gf.getGiorno()) %></h5>
        	 <table  class="table table-bordered table-striped table-hover ">
        	<thead class="table-columns">
        		<tr>
        			<th class="table-first-header">Zona</th>
        			<th>Colore</th>
        			
        			<% for (String col : colonneCustom) { %>
        			
        				<th><%=CostantiVerificaAllerte.NOMI_COLONNE.get(col) %></th>
        			
        			<% } %>
        			<th><a target="_blank" href="/web/guest/catasto-segnalazioni">Catasto segnalazioni</a></th>
        			<th>Colore post <c:if test="<%=!readonly %>">(<a href="javascript:void(0);" onclick="riempiVerde('verificadato_<%=CostruttoreVerificaDato.sdf.format(gf.getGiorno())%>_<%=gf.getEvento() %>');">Riempi i vuoti di verde</a>)</c:if></th>
        			<th>Note</th>
        		</tr>
        	</thead>
        	
        	<tbody class="table-data">
        	
        		<% 
        			
        			for (GiornoFenomenoRiga gr : gf.getRighe()) {
        				
        				int index = 0;
        				for (int kkk=0; kkk<CostantiVerificaAllerte.SOTTOZONE.length; kkk++) 
        					if (CostantiVerificaAllerte.SOTTOZONE[kkk].equals(gr.getZona()))
        						index = kkk;
        				
        				%>
        				
        			<tr>
        				<td class="table-cell first">
        					<%=gr.getZona() %>
        				</td>
        				<td class="table-cell">
        				<span id="datoprev-<%=CostruttoreVerificaDato.sdf.format(gr.getGiorno())%>-<%=gr.getEvento() %>-<%=index %>"><%=CostruttoreVerificaDato.getDato(gr.getDato("colore_pre")) %></span>
        				</td>
        				
        				
        				<% for (String col : colonneCustom) { %>
        			
        				<td>
        				<%=CostruttoreVerificaDato.getDataRepresentation(gr.getDato(col), readonly, true) %>
        				</td>
        			
        				<% } %>
        				
        				<td class="table-cell">
        				
        				<% for (Segnalazione seg : gr.getSegnalazioni()) { %>
        			
        				<a target="_blank" 
        				href="/web/guest/catasto-segnalazioni?p_p_id=allerta_catasto_web_AllertaCatastoWebPortlet&p_p_lifecycle=0&_allerta_catasto_web_AllertaCatastoWebPortlet_mvcRenderCommandName=%2Fallertaer%2Fcatasto%2Fcompila&_allerta_catasto_web_AllertaCatastoWebPortlet_id=<%=seg.getId() %>">#<%=seg.getId()+": "+seg.getComune() %></a>
        			
        				<% } %>
        				
        				</td>
        				<td class="table-cell">
        					<%=CostruttoreVerificaDato.getSelect(gr.getDato("colore_post"),CostantiVerificaAllerte.COLORI, CostantiVerificaAllerte.COLORI,"aggiornaImmagini()", readonly, true) %>
        				</td>
        				<td class="table-cell">
        					<%=CostruttoreVerificaDato.getInputTextArea(gr.getDato("note"), readonly, true) %>
        				</td>
        				
        			</tr>
        		
        		<% } %>
        	
        	</tbody>
        </table>
        <br/><br/>
        </div>
        
        	 
        	 <%
        	 
         }
        %>
    </liferay-ui:section>
    <liferay-ui:section>
     <div class="row">
       	<div class="col-3 form-group">
   		 <label class="control-label">Fenomeno selezionato</label>
    	<%=CostruttoreVerificaDato.getEventoMenu(bean.getTuttiDati(), "menuEvento2", bean.getEventoSelezionato2(), "cambiaMenu2(this)") %>
        </div>
      </div>
        <br/><br/>
       <%
         for (GiornoFenomeno gf : bean.getGiornoFenomeni()) {
        	 
        	 boolean visibile = gf.getEvento()==bean.getEventoSelezionato2();
        	 %>
        	 <div style="<%=visibile?"":"display:none" %>" class="valutazione eventovalutazione-<%=gf.getEvento() %>">
        	 
        	 <h5><%=new SimpleDateFormat("dd/MM/yyyy").format(gf.getGiorno()) %> dalle ore <%=new SimpleDateFormat("HH:mm").format(gf.getGiorno()) %></h5>
        	 
        	 <div class="row">
        	 	<div class="col-6 form-group" style="text-align:center">
       				<h5>Previsto</h5>
       				<img style="width:434px;height:250px" class="imgval" id="imgval-prev-<%=CostruttoreVerificaDato.sdf.format(gf.getGiorno()) %>-<%=gf.getEvento() %>"></img>
       			</div>
       			<div class="col-6 form-group" style="text-align:center">
       				<h5>Osservato</h5>
       				<img style="width:434px;height:250px" class="imgval" id="imgval-oss-<%=CostruttoreVerificaDato.sdf.format(gf.getGiorno()) %>-<%=gf.getEvento() %>"></img>
       			</div>
       			
       		</div>
        	 
        	 <div class="row">
       			<div class="col-3 form-group">
				<label class="control-label">Correttezza</label>
      	  	 	<%=CostruttoreVerificaDato.getSelect(gf.getDato("correttezza"), CostantiVerificaAllerte.CORRETTEZZA, CostantiVerificaAllerte.CORRETTEZZA, readonly, true) %>
				</div>
       		 
       			<div class="col-3 form-group">
				<label class="control-label">Magnitudo</label>
         	 <%=CostruttoreVerificaDato.getSelect(gf.getDato("magnitudo"), CostantiVerificaAllerte.MAGNITUDO, CostantiVerificaAllerte.MAGNITUDO, readonly, true) %>
				</div>
       		
       			<div class="col-3 form-group">
				<label class="control-label">Localizzazione</label>
 			<%=CostruttoreVerificaDato.getSelect(gf.getDato("localizzazione"), CostantiVerificaAllerte.LOCALIZZAZIONE, CostantiVerificaAllerte.LOCALIZZAZIONE, readonly, true) %>
				</div>
       		
       			<div class="col-3 form-group">
				<label class="control-label">Cause</label>
 			 <%=CostruttoreVerificaDato.getSelect(gf.getDato("cause"), CostantiVerificaAllerte.CAUSE, CostantiVerificaAllerte.CAUSE, readonly, true) %>
				</div>
       		</div>
       		 <div class="row">
       			<div class="col-12 form-group">
				<label class="control-label">Valutazione descrittiva</label>
 			<%=CostruttoreVerificaDato.getInputTextArea(gf.getDato("valutazione_descrittiva"), readonly, false) %>
				</div>
       		 </div>
       		 <div class="row">
       			<div class="col-12 form-group">
				<label class="control-label">Segnalazioni dal territorio</label>
 				<%=CostruttoreVerificaDato.getInputTextArea(gf.getDato("note_valutazione"), readonly, false) %>
				</div>
       		 </div>
 			<br/><br/>
        	 </div>
        
        	 
        	 <%
        	 
         }
        %>
    </liferay-ui:section>

</liferay-ui:tabs>

<aui:button-row>
	
		
		<c:if test="<%=!readonly %>">

			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=salvaURL.toString()%>')"
				class="btn btn-primary">Salva</button>
				
			<button type="button" onclick="if (confirm('Vuoi davvero consolidare questa verifica?')) { <portlet:namespace/>submitAllertaForm('<%=consolidaURL.toString()%>') } "
				class="btn btn-primary">Consolida</button>
			
		</c:if>
		
		<c:if test="<%=readonly %>">
				
			<button type="button" onclick="if (confirm('Vuoi davvero riaprire questa verifica?')) { <portlet:namespace/>submitAllertaForm('<%=sbloccaURL.toString()%>') } "
				class="btn btn-primary">Riapri</button>
			
		</c:if>
		
		<button type="button" onclick="window.location.href='/web/guest/verifica'"
				class="btn btn-primary">Torna alla lista</button>
				
				
		<script type="text/javascript">
			function <portlet:namespace/>submitAllertaForm(actionUrl) {
			document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
			document.forms.<portlet:namespace/>fmCompila.submit();
	          
			}
			
			function riempiVerde(e) {
				$("select[name^='"+e+"']").each(function() { 
					if (this.name.includes('colore_post') && (this.value==" " || !this.value)) {
						this.value="VERDE"; console.log(this.id); }
				});
			}
			
			function cambiaMenu(e) {
				$(".evento-base").css('display','none')
				$(".evento-"+e.value).css('display','initial')
			}
			
			function cambiaMenu2(e) {
				$(".valutazione").css('display','none')
				$(".eventovalutazione-"+e.value).css('display','initial')
			}
			
			function ripristina(campo,valore) {
				if (confirm('Vuoi ripristinare il valore "'+valore+"' in questo campo?")) {
					$("#"+campo).val(valore);
				}
			}
			
			function aggiornaImmagini() {
				var imgs = $('.imgval').get()
				var zn = ['A1','A2','B1','B2','C1','C2','D1','D2','D3','E1','E2','F1','F2','F3','G1','G2','H1','H2',]
				for (var i of imgs) {
					var id = i.id
					console.log('devo riempire '+id)
					var parts = id.split('-')
					var out = ""
					if (parts[1]=='prev') {
						for (var k=0; k<18; k++) {
							console.log('cerco '+"#datoprev-"+parts[2]+"-"+parts[3]+"-"+k)
							var el = $("#datoprev-"+parts[2]+"-"+parts[3]+"-"+k)
							if (el && el.text()) {
								console.log('trovato '+el.text())
								out+=el.text().substring(0,1)
							}
							else out+="X"
						}
						
					} else {
						for (var k=0; k<18; k++) {
							console.log('cerco '+"#verificadato_"+parts[2]+"_"+parts[3]+"_"+zn[k]+"_colore_post_1")
							var el = $("#verificadato_"+parts[2]+"_"+parts[3]+"_"+zn[k]+"_colore_post_1")
							if (el) {
								console.log('trovato '+el.val())
								if (el.val()) out+=el.val().substring(0,1)
								else out+="X"
							}
							else out+="X"
						}
					}
					var current = $('#imgval-'+parts[1]+'-'+parts[2]+'-'+parts[3]).attr('src')
					var updated = '/o/allerta-img?tipo=zoneNomi&param='+out+'&w=868&h=500'
					if (current!=updated)
						$('#imgval-'+parts[1]+'-'+parts[2]+'-'+parts[3]).attr('src',updated)
				}
			}
	
		</script>

	</aui:button-row>

</aui:form>

<script type="text/javascript">
   Liferay.on('allPortletsReady', function(event) {
	   
	   aggiornaImmagini();
	   
	   console.log('Creo timer heartbeat')
   		if (!window.verificaTimer) window.verificaTimer = setInterval(function() {
   			
   		      console.log("Attivazione timer heartbeat verifica");
   		      if (window.location.href.lastIndexOf("verifica")!=-1) {
   		    	console.log("Mando heartbeat");
   		    	$.ajax({
  			      url: '/o/api/heartbeat/'+new Date().getTime(),
  			      method: 'GET',
  			    }).then(function (resp) {
			   
  			    	console.log("Heartbeat ricevuto");
			      	
			    })
   		      }
   		     if (window.location.href.lastIndexOf("verifica")==-1) {
   			  console.log("Cancellazione timer heartbeat");
   			  clearInterval(window.verificaTimer);
   			  window.verificaTimer=null;
   		   }
   		      	
   		   
   		}, 10000);
   
   });
  
		
	</script>