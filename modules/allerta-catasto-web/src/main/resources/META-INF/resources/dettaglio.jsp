
<%@page import="allerta.catasto.model.EffettiSub"%>
<%@page import="allerta.catasto.model.Effetti"%>
<%@page import="allerta.catasto.model.Sottocategoria"%>
<%@page import="allerta.catasto.bean.CatastoBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>

<%

long catastoId = ParamUtil.getLong(request, "id");
CatastoBean bean = new CatastoBean(catastoId,request);


boolean readonly = bean.isReadonly();
String disabled = readonly?" disabled ":"";

%>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
<script src = "//cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>

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
<portlet:actionURL var="salvaURL" name="/allertaer/catasto/salva">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>

<div class="row">
<div class="col-8 form-group">
<h3><%=bean.getTitolo() %></h3>
</div>

</div>

<aui:form method="post" name="fmCompila" id="fmCompila" cssClass="verifica-form">

<input type="hidden" name="id" value="<%=catastoId%>">



<liferay-ui:tabs onClick="invali" value="Generale" refresh="false" names="Generale,Localizzazione">
	<liferay-ui:section>
      
    	<div class="row">
    	
    		<div class="col-4 form-group">

				<label class="control-label" for="datetimepicker1"> Data evento</label>

				<div class='input-group date input-group--date-picker' id="datetimepicker1">
		            <input <%=readonly?"disabled":"" %>
						type="text" 
						class="form-control" 
						name="dataInizio"
						value="${bean.dataEvento}" 
						placeholder="gg/mm/aaaa" />
	                <span class="input-group-addon">
	                   <i class="far fa-calendar-minus"></i>
	                </span>
	             </div>
				                
	  
	             <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({
		                	<%if( catastoId <=0) {%>
		                	useCurrent: false,
		                	date: moment().startOf('day').toDate(),
		                	<%}%>
		                	format: 'DD/MM/YYYY',
		                	 icons: {
		                         time: "far fa-clock",
		                         date: "far fa-calendar-minus",
		                         up: "fa fa-arrow-up",
		                         down: "fa fa-arrow-down"
		                     }
		                });
		            });
		        </script>
	  	 	</div> 
	  	 	
	  	 	<div class="col-2 form-group">
	  	 	<label class="control-label">Tipo documento</label>
	  	 	<select <%=disabled %> id="tipodoc"
				 name="tipodoc" class="form-control">
				 <option <%="".equals(bean.getTipoDocumentoCollegato())?"selected":"" %> value="">N.D.</option>
				 <option <%="A".equals(bean.getTipoDocumentoCollegato())?"selected":"" %> value="A">Allerta</option>
				 <option <%="B".equals(bean.getTipoDocumentoCollegato())?"selected":"" %> value="B">Bollettino</option>

			</select>
	  	 	</div>
	  	 	
	  	 	<div class="col-2 form-group"> 
	  	 	<label class="control-label">Numero documento</label>
	  	 	<input maxlength="8" <%=disabled%> id="numerodoc" type="text" name="numerodoc" value="${bean.numeroDocumentoCollegato}" class="form-control">
	  	 	</div>
	  	 	
	  	 	<div class="col-4 form-group">
			<label class="control-label">Ente segnalante</label>
			<input <%=disabled%> id="ente" type="text" name="ente" value="${bean.ente}" class="form-control">
			</div>
      </div>
      
      <div class="row">
    	
    		<div class="col-6 form-group">
    		<label class="control-label">Fenomeno</label>
    		<select <%=disabled %> id="categoria"
				 name="categoria" class="form-control">
				 <% for (Sottocategoria sc : bean.getSottocategorie()) { %>
				 	<option <%=bean.getSottocategoria()==sc.getId()?"selected":"" %> value="<%=sc.getId()%>"><%=sc.getDescrizione()%></option>
				 <% } %>
				 
			</select>
    		</div>
    		
    		<div class="col-6 form-group">
    		<label class="control-label">Fonte</label>
    		<select <%=disabled %> id="fonte"
				 name="fonte" class="form-control">
				 <option <%=bean.getFonte()==0?"selected":"" %> value="0">N.D.</option>
				 <option <%=bean.getFonte()==1?"selected":"" %> value="1">Stampa</option>
				 <option <%=bean.getFonte()==2?"selected":"" %> value="2">Web</option>
				 <option <%=bean.getFonte()==3?"selected":"" %> value="3">Social media</option>
				 <option <%=bean.getFonte()==4?"selected":"" %> value="4">VVF</option>
				 <option <%=bean.getFonte()==5?"selected":"" %> value="5">DB segnalazione danno</option>

			</select>
    		</div>
    </div>
    
    <div class="row">
    	
    		<div class="col-6 form-group">
    		<label class="control-label">Macrocategoria effetti/danni</label>
    		<select <%=disabled %> id="effetti"
				 name="effetti" class="form-control" onchange="rebuildEffettiSub()" >
				 <% for (Effetti sc : bean.getEffetti()) { %>
				 	<option <%=bean.getEff()==sc.getId()?"selected":"" %> value="<%=sc.getId()%>"><%=sc.getDescrizione()%></option>
				 <% } %>
				 
			</select>
    		</div>
    		
    		<div class="col-6 form-group">
    		<label class="control-label">Effetti/danni</label>
    		<select <%=disabled %> id="effettiSub"
				 name="effettiSub" class="form-control">
				<% for (EffettiSub sc : bean.getEffettiSub()) { %>
				 	<option <%=bean.getEffSub()==sc.getId()?"selected":"" %> cat="<%=sc.getIdEffetti() %>" value="<%=sc.getId()%>"><%=sc.getDescrizione()%></option>
				 <% } %>
			</select>
    		</div>
    </div>
      
      <div class="row">
       		<div class="col-12 form-group">
       		<label class="control-label">Utente</label>
       		<input disabled id="username" type="text" name="username" value="${bean.username}" class="form-control">
       		
       		</div>
       	</div>
       <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Descrizione</label>
			<textarea <%=disabled%> id="note" style="height: 100px" name="descrizione" class="form-control" >${bean.descrizione}</textarea>
			</div>
		
       </div>
       <div class="row">
       		<div class="col-12 form-group">
			<label class="control-label">Note</label>
			<textarea <%=disabled%> id="note" style="height: 100px" name="note" class="form-control" >${bean.note}</textarea>
			</div>
		
       </div>
    </liferay-ui:section>
    <liferay-ui:section>
        <div class="row">
        	<div class="col-2 form-group">
			<label class="control-label">Provincia</label>
			<select <%=disabled %> id="provincia"
				 name="provincia" class="form-control" onchange="rebuildComune()">
				 <option  value="">N.D.</option>
				 <option <%=("BO".equals(bean.getProvincia())?"selected":"") %> value="BO">BO</option>
				 <option <%=("FC".equals(bean.getProvincia())?"selected":"") %> value="FC">FC</option>
				 <option <%=("FE".equals(bean.getProvincia())?"selected":"") %> value="FE">FE</option>
				 <option <%=("MO".equals(bean.getProvincia())?"selected":"") %> value="MO">MO</option>
				 <option <%=("PC".equals(bean.getProvincia())?"selected":"") %> value="PC">PC</option>
				 <option <%=("PR".equals(bean.getProvincia())?"selected":"") %> value="PR">PR</option>
				 <option <%=("RA".equals(bean.getProvincia())?"selected":"") %> value="RA">RA</option>
				 <option <%=("RE".equals(bean.getProvincia())?"selected":"") %> value="RE">RE</option>
				 <option <%=("RN".equals(bean.getProvincia())?"selected":"") %> value="RN">RN</option>


			</select>
			</div>
			<div class="col-4 form-group">
			<label class="control-label">Comune</label>
			<select <%=disabled %> id="comune"
				 name="comune" class="form-control">
				 


			</select>
			</div>
        </div>
        <div class="row">
       		<div class="col-3 form-group">
       		<label class="control-label">Indirizzo</label>
       		<input <%=disabled%> id="indirizzo" type="text" name="indirizzo" value="${bean.indirizzo}" class="form-control">
       		
       		</div>
       		<div class="col-1 form-group">
       		<label class="control-label">Civico</label>
       		<input <%=disabled%> id="civico" type="text" name="civico" value="${bean.civico}" class="form-control">
       		
       		</div>
       		
       		<div class="col-2 form-group" style="display:flex">
       	
			<button type="button" onclick="geolocalizza()" style="align-self: end;"
				class="btn btn-primary">Geolocalizza</button>		
       		</div>
       	</div>
       	<div class="row">
       		<div class="col-3 form-group">
       		<label class="control-label">Latitudine</label>
       		<input onblur="aggiornaMarker()" <%=disabled%> id="lati" type="text" name="lati" value="${bean.latVera}" class="form-control">
       		
       		</div>
       		<div class="col-3 form-group">
       		<label class="control-label">Longitudine</label>
       		<input onblur="aggiornaMarker()" <%=disabled%> id="longi" type="text" name="longi" value="${bean.lonVera}" class="form-control">
       		
       		</div>

       	</div>
       	<div id="mappa" class="row" style="display:none">
       		      <div id = "map" class="col-6 form-group" style = "width:100%;height:500px"></div>
       			<div id="geo" class="col-6 form-group">
       			</div>
       	</div>
    </liferay-ui:section>
   

</liferay-ui:tabs>

<aui:button-row>
	
		
		<c:if test="<%=!readonly %>">

			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=salvaURL.toString()%>')"
				class="btn btn-primary">Salva</button>
				
	
			
		</c:if>
		
		<button type="button" onclick="window.location.href='/web/guest/catasto-segnalazioni'"
				class="btn btn-primary">Torna alla lista</button>
				
				
		<script type="text/javascript">
			function <portlet:namespace/>submitAllertaForm(actionUrl) {
			document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
			document.forms.<portlet:namespace/>fmCompila.submit();
	          
			}
			
			
			
			
		</script>

	</aui:button-row>

</aui:form>

<script type="text/javascript">

function rebuildComune() {
	
	var opts = [
			
		<% for (Object[] o : bean.getComuni()) { %>
		<%="{\"comune\":\""+o[0].toString()+"\", \"provincia\":\""+o[2].toString()+"\"}," %>
		<% } %>
	]
	
	var prov = $("#provincia").val()
	var comune = $("#comune");
	
	comune.empty();
	comune.append($("<option />").val("").text(""));
	for (const o of opts) {
		if (o.provincia==prov) {
			comune.append($("<option />").val(o.comune).text(o.comune));
		}
	}
}

function invali() {
	window.tm=setTimeout(invalidaMappa, 300);
}

function invalidaMappa() {
	window.map.invalidateSize()
	clearTimeout(window.tm)
}

function geolocalizza() {
	var prov = $("#provincia").val()
	var comune = $("#comune").val()
	var indirizzo = $("#indirizzo").val()
	var civico = $("#civico").val()
	var xurl = "/o/geolocator?provincia="+prov+"&comune="+comune+"&indirizzo="+indirizzo+"&civico="+civico
			
	$.ajax({
	      url: xurl,
	      method: 'GET',
	      dataType: 'json'
	    }).then(function (resp) {
	    	var r = resp.records
	    	var txt = "<tr><td>DUG</td><td>DEN</td><td>CIV</td><td>COM</td><td>VAI</td></tr>"
	    	var elem = ""
	    	$("#geo").empty()
	    	for (var k=0; k<r; k++) {
	    		var xxx = txt
	    		xxx = xxx.replace("DUG",resp["dug"+k])
	    		xxx = xxx.replace("DEN",resp["denominazione"+k])
	    		xxx = xxx.replace("CIV",resp["civico"+k])
	    		xxx = xxx.replace("COM",resp["comune"+k]+" ("+resp["provincia"+k]+")")
	    		var vai = "<button type='button' class='btn btn-primary' onclick='event.stopPropagation();marca(LAT,LON)'>Vai</button>"
	    		vai = vai.replace("LAT",resp["lat"+k] || ((resp["minlat"+k]+resp["maxlat"+k])/2.0))
	    		vai = vai.replace("LON",resp["lon"+k] || ((resp["minlon"+k]+resp["maxlon"+k])/2.0))
	    		xxx = xxx.replace("VAI",vai)
	    		elem = elem + xxx
	    		
	    	}
	    	$("#geo").append("<table style='width:100%'><tr><th>DUG</th><th>Denominazione</th><th>Civico</th><th>Comune</th><th></th></tr>"+elem+"</table>")
	   		
	      	
	    }).fail(function (resp) {
	      	console.log('fail');
	      	console.log(resp);
	});
}

function aggiornaMarker() {
	if (!window.marker) return;
	
	var lat = parseFloat($('#lati').val().replace(',','.'));
    var lng = parseFloat($('#longi').val().replace(',','.'));
    var newLatLng = new L.LatLng(lat, lng);
    window.marker.setLatLng(newLatLng); 
    window.map.panTo(newLatLng)
}

function marca(lat,lon) {
	if (!window.marker) {
		window.marker = L.marker([lat,lon],{draggable:true})
		window.marker.on('dragend', function (e) {
    			$('#lati').val(window.marker.getLatLng().lat);
    			$('#longi').val(window.marker.getLatLng().lng);
			});
 		window.marker.addTo(window.map);
	} else {
		var newLatLng = new L.LatLng(lat, lon);
    	window.marker.setLatLng(newLatLng); 
	}
	$('#lati').val(lat);
	$('#longi').val(lon);
	window.map.panTo(new L.LatLng(lat, lon))
}

function rebuildEffettiSub() {
	
	var eff = $("#effetti").val()
	var newsel = null
	var change = false
	
	$("#effettiSub option").each(function()
			{
			 if ($(this).attr("cat")==eff) {
				 $(this).show()
				 if (!newsel) newsel = $(this).val()
			 }
			 else {
				 $(this).hide()
				 if ($(this).val()==$("#effettiSub").val()) change=true;
			 }
			});
	
	if (change && newsel) $("#effettiSub").val(newsel)
}


   Liferay.on('allPortletsReady', function(event) {
	   rebuildComune();
	   rebuildEffettiSub();
	   $("#comune").val("<%=bean.getComune() %>")
	   
	   
	   var mapOptions = {
            center: [44.494887, 11.3426163],
            zoom: 15
         }
         // Creating a map object
         var map = new L.map('map', mapOptions);
	     window.map = map
         
         // Creating a Layer object
         var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
         
         // Adding layer to the map
         map.addLayer(layer);
         
         // Creating a marker
         window.marker = null
         
         // Adding marker to the map
         <% if (bean.getLat()!=null && bean.getLon()!=null) { %>
        	window.marker = L.marker([<%=bean.getLat() %>, <%=bean.getLon() %>],{draggable:true})
        	window.marker.on('dragend', function (e) {
        		$('#lati').val(window.marker.getLatLng().lat);
    			$('#longi').val(window.marker.getLatLng().lng);
			});
         	window.marker.addTo(map);
         	window.map.panTo(new L.LatLng(<%=bean.getLat() %>,  <%=bean.getLon() %>))
         <% } %>
         
         $('#mappa').show()
         map.invalidateSize()
         
         setTimeout(function () {
        	    map.invalidateSize();
        	}, 0);
	   
	   console.log('Creo timer heartbeat')
   		if (!window.catastoTimer) window.catastoTimer = setInterval(function() {
   			

   			
   		      console.log("Attivazione timer heartbeat verifica");
   		      if (window.location.href.lastIndexOf("catasto")!=-1) {
   		    	console.log("Mando heartbeat");
   		    	$.ajax({
  			      url: '/o/api/heartbeat/'+new Date().getTime(),
  			      method: 'GET',
  			    }).then(function (resp) {
			   
  			    	console.log("Heartbeat ricevuto");
			      	
			    })
   		      }
   		     if (window.location.href.lastIndexOf("catasto")==-1) {
   			  console.log("Cancellazione timer heartbeat");
   			  clearInterval(window.catastoTimer);
   			  window.catastoTimer=null;
   		   }
   		      	
   		   
   		}, 10000);
   
   });
  
		
	</script>