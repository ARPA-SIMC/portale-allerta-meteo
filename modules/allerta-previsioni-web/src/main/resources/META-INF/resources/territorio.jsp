<%@page import="java.util.List"%>
<%@ include file="./init.jsp"%>

<%
	GestioneBean gestioneBean = (GestioneBean) renderRequest.getAttribute("GestioneBean");
	Previsioni previsioni = (Previsioni) renderRequest.getAttribute("PrevisioniBean");
	String provincia = (String) renderRequest.getAttribute("Provincia");
	List<String> previsioniDetails = previsioni.getMeteoProv(provincia);
%>


<c:set 	var="previsioniDetails"
	   	value="<%=previsioniDetails %>" 
	   	scope="request" />
	   	
<c:set 	var="tabellaDati" 
		value="<%=previsioni.getStorici() %>"
		scope="request" />

<main class="page main page--previsioni" id="main-content">

	<div class="page__head">
                
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12" >Previsioni regionali</h1>
                
                <p class="col-12 lead">
                    
                </p>
            </div>

            
        </div>
        <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="Hai percorso">
                    <ol class="breadcrumb">
        
                       <li class="breadcrumb-item">
                           <a href="/">Home</a>
                       </li>
       
                       <li class="breadcrumb-item active" aria-current="page">Previsioni regionali</li>
        
                    </ol>
                </nav>
            </div>
        </div>
   </div>

 <div class="container page__body">
 
	<div class="row"> 
	
      	<div class="col-12 page__content" id="page-content">
          <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item" role="presentation">
                  <a class="nav-link active" href="#previsioni-tab-oggi" aria-controls="previsioni-tab-oggi" role="tab" data-toggle="tab">
                  	<%=((Giorno) gestioneBean.getPrevisioni().get("oggi")).getNome()%>
                  </a>
              </li>
              <li class="nav-item" role="presentation">
                  <a class="nav-link " href="#previsioni-tab-domani" aria-controls="previsioni-tab-domani" role="tab" data-toggle="tab">
                  	<%=((Giorno) gestioneBean.getPrevisioni().get("domani")).getNome()%>
                  </a>
              </li>
              <li class="nav-item" role="presentation">
                  <a class="nav-link " href="#previsioni-tab-dopodomani" aria-controls="previsioni-tab-dopodomani" role="tab" data-toggle="tab">
                  	<%=((Giorno) gestioneBean.getPrevisioni().get("dopodomani")).getNome()%>
                  </a>
              </li>
          </ul> <!-- /.nav-tabs -->
	  	</div>
		
		
		<div class="col-12">
		
          <div class="tab-content">
          
          	 <div role="tabpanel" class="tab-pane active" id="previsioni-tab-oggi">

            	<div class="row">
                	<div class="col-12 col-md-6 pb-3">
                	
                      	<ul class="nav nav-tabs nav-tabs--sm" role="tablist">
                          <li class="nav-item" role="presentation">
                              <a class="nav-link active" href="#previsioni-tab-oggi__mattina" aria-controls="previsioni-tab-oggi__mattina" role="tab" data-toggle="tab">
                              	Mattina
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-oggi__pomeriggio" aria-controls="previsioni-tab-oggi__pomeriggio" role="tab" data-toggle="tab">
                              	Pomeriggio
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-oggi__seranotte" aria-controls="previsioni-tab-oggi__seranotte" role="tab" data-toggle="tab">
                              	Sera e notte
                              </a>
                          </li>
                      	</ul> <!-- /.nav-tabs -->
                      
                      	<div class="tab-content">
                          <div class="tab-pane active" role="tabpanel" id="previsioni-tab-oggi__mattina">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("mattina", "oggi", provincia)%>" alt="Previsioni di Oggi Mattina"> 
                          </div>
                          <div class="tab-pane " role="tabpanel" id="previsioni-tab-oggi__pomeriggio">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("pomeriggio", "oggi", provincia)%>" alt="Previsioni di Oggi Pomeriggio">
                               
                          </div>
                          <div class="tab-pane" role="tabpanel" id="previsioni-tab-oggi__seranotte">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("sera_notte", "oggi", provincia)%>" alt="Previsioni di Oggi Sera-Notte">
                          </div>
                      	</div>

                    </div>
                    <div class="col-12 col-md-6">
                        <c:if test="<%=provincia.equals("ND") %>">
	                    	<span style="font-weight: bold;">Stato del tempo: </span>
							<%=previsioni.readXmlBollettino("oggi").get(0)%>
	
							<br /> <span style="font-weight: bold;">Temperature: </span>
							<%=previsioni.readXmlBollettino("oggi").get(1)%>
	
							<br /> <span style="font-weight: bold;">Venti: </span><br />
							<%=previsioni.readXmlBollettino("oggi").get(2)%>
	
							<br /> <span style="font-weight: bold;">Mare:</span><br />
							<%=previsioni.readXmlBollettino("oggi").get(3)%>
						</c:if>
						<c:if test="<%=!provincia.equals("ND") %>">
							<%=previsioniDetails.get(0)%>
						</c:if>
						
						<c:if test="<%=!provincia.equals("ND") %>">
						
							<div class="table table table-striped table--previsioni">
							
	                           <table>
	                           
	                               <thead>
	                                   <tr>
	                                   
	                                   	 <th scope="col" id="dato" aria-hidden="true"><span class="sr-only">Dato di riferimento</span></th>
	                                  	 <c:out value = "${tabellaDati.get(0).getHeader()}" escapeXml="false" />
	                                  	 <th scope="col" id="unita"><span class="sr-only">Unità di misura</span></th>
	                                  
	                                   </tr>
	                               </thead>
	                               
	                               <tbody>
	                               		<tr>
											<th>
												<abbr title="Temperatura minima: valori medi previsti nell'area">T min</abbr>
											</th> 
											<c:out value = "${tabellaDati.get(0).gettMin()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Temperatura massima: valori medi previsti nell'area">T	max</abbr>
												<c:out value = "${tabellaDati.get(0).gettMax()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Precipitazioni: valori minimi e massimi previsti nell'area">Prec</abbr>
											</th>
											<c:out value = "${tabellaDati.get(0).getPrecipitazioni()}" escapeXml="false" />									
										</tr>
										<tr>
											<th>
												<acronym title="Vento massimo: valori massimi previsti nell'area">V	max</acronym> 
											</th>
											<c:out value = "${tabellaDati.get(0).getVento()}" escapeXml="false" />		
										</tr>
										
	                                 
	                               </tbody>
	                           </table>
	                           <p class="pt-3"> <small>I dati fra parentesi si riferiscono ai valori medi climatologici 1991-2010 </small> </p>
	                           
	                        </div>
	                        
						</c:if>

                    </div>
               	</div>
               	
             </div>
               
             <div role="tabpanel" class="tab-pane" id="previsioni-tab-domani">
                <div class="row">
                	<div class="col-12 col-md-6 pb-3">
                	
                      	<ul class="nav nav-tabs nav-tabs--sm" role="tablist">
                          <li class="nav-item" role="presentation">
                              <a class="nav-link active" href="#previsioni-tab-domani__mattina" aria-controls="previsioni-tab-domani__mattina" role="tab" data-toggle="tab">
                              	Mattina
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-domani__pomeriggio" aria-controls="previsioni-tab-domani__pomeriggio" role="tab" data-toggle="tab">
                              	Pomeriggio
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-domani__seranotte" aria-controls="previsioni-tab-domani__seranotte" role="tab" data-toggle="tab">
                              	Sera e notte
                              </a>
                          </li>
                      	</ul> <!-- /.nav-tabs -->
                      
                      	<div class="tab-content">
                          <div class="tab-pane active" role="tabpanel" id="previsioni-tab-domani__mattina">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("mattina", "domani", provincia)%>" alt="Previsioni di Domani Mattina"> 
                          </div>
                          <div class="tab-pane " role="tabpanel" id="previsioni-tab-domani__pomeriggio">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("pomeriggio", "domani", provincia)%>" alt="Previsioni di Domani Pomeriggio">
                               
                          </div>
                          <div class="tab-pane" role="tabpanel" id="previsioni-tab-domani__seranotte">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("sera_notte", "domani", provincia)%>" alt="Previsioni di Domani Sera-Notte">
                          </div>
                      	</div>

                    </div>
                    <div class="col-12 col-md-6">
                         <c:if test="<%=provincia.equals("ND") %>">  
	                    	<span style="font-weight: bold;">Stato del tempo: </span>
							<%=previsioni.readXmlBollettino("domani").get(0)%>
	
							<br /> <span style="font-weight: bold;">Temperature: </span>
							<%=previsioni.readXmlBollettino("domani").get(1)%>
	
							<br /> <span style="font-weight: bold;">Venti: </span><br />
							<%=previsioni.readXmlBollettino("domani").get(2)%>
	
							<br /> <span style="font-weight: bold;">Mare:</span><br />
							<%=previsioni.readXmlBollettino("domani").get(3)%>
						</c:if>
						<c:if test="<%=!provincia.equals("ND") %>">
							<%=previsioniDetails.get(1)%>
						</c:if>
						
						<c:if test="<%=!provincia.equals("ND") %>">
						
							<div class="table table table-striped table--previsioni">
							
	                           <table>
	                           
	                               <thead>
	                                   <tr>
	                                   
	                                   	 <th scope="col" id="dato" aria-hidden="true"><span class="sr-only">Dato di riferimento</span></th>
	                                  	 <c:out value = "${tabellaDati.get(1).getHeader()}" escapeXml="false" />
	                                  	 <th scope="col" id="unita"><span class="sr-only">Unità di misura</span></th>
	                                  
	                                   </tr>
	                               </thead>
	                               
	                               <tbody>
	                               		<tr>
											<th>
												<abbr title="Temperatura minima: valori medi previsti nell'area">T min</abbr>
											</th> 
											<c:out value = "${tabellaDati.get(1).gettMin()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Temperatura massima: valori medi previsti nell'area">T	max</abbr>
												<c:out value = "${tabellaDati.get(1).gettMax()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Precipitazioni: valori minimi e massimi previsti nell'area">Prec</abbr>
											</th>
											<c:out value = "${tabellaDati.get(1).getPrecipitazioni()}" escapeXml="false" />									
										</tr>
										<tr>
											<th>
												<acronym title="Vento massimo: valori massimi previsti nell'area">V	max</acronym> 
											</th>
											<c:out value = "${tabellaDati.get(1).getVento()}" escapeXml="false" />		
										</tr>
										
	                                 
	                               </tbody>
	                           </table>
	                           <p class="pt-3"> <small>I dati fra parentesi si riferiscono ai valori medi climatologici 1991-2010 </small> </p>
	                           
	                        </div>
	                        
						</c:if>


                    </div>
               	</div>
             </div>
               
               
             <div role="tabpanel" class="tab-pane" id="previsioni-tab-dopodomani">
                 <div class="row">
                	<div class="col-12 col-md-6 pb-3">
                	
                      	<ul class="nav nav-tabs nav-tabs--sm" role="tablist">
                          <li class="nav-item" role="presentation">
                              <a class="nav-link active" href="#previsioni-tab-dopodomani__mattina" aria-controls="previsioni-tab-dopodomani__mattina" role="tab" data-toggle="tab">
                              	Mattina
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-dopodomani__pomeriggio" aria-controls="previsioni-tab-dopodomani__pomeriggio" role="tab" data-toggle="tab">
                              	Pomeriggio
                              </a>
                          </li>
                          <li class="nav-item" role="presentation">
                              <a class="nav-link" href="#previsioni-tab-dopodomani__seranotte" aria-controls="previsioni-tab-dopodomani__seranotte" role="tab" data-toggle="tab">
                              	Sera e notte
                              </a>
                          </li>
                      	</ul> <!-- /.nav-tabs -->
                      
                      	<div class="tab-content">
                          <div class="tab-pane active" role="tabpanel" id="previsioni-tab-dopodomani__mattina">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("mattina", "dopodomani", provincia)%>" alt="Previsioni di Dopodomani Mattina"> 
                          </div>
                          <div class="tab-pane " role="tabpanel" id="previsioni-tab-dopodomani__pomeriggio">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("pomeriggio", "dopodomani", provincia)%>" alt="Previsioni di Dopodomani Pomeriggio">
                               
                          </div>
                          <div class="tab-pane" role="tabpanel" id="previsioni-tab-dopodomani__seranotte">
                              <img class="u-img-fit-x" src="data:image/jpg;base64,<%=previsioni.getImg("sera_notte", "dopodomani", provincia)%>" alt="Previsioni di Dopodomani Sera-Notte">
                          </div>
                      	</div>

                    </div>
                    <div class="col-12 col-md-6">
                          
                        <c:if test="<%=provincia.equals("ND") %>">
	                    	<span style="font-weight: bold;">Stato del tempo: </span>
							<%=previsioni.readXmlBollettino("dopodomani").get(0)%>
	
							<br /> <span style="font-weight: bold;">Temperature: </span>
							<%=previsioni.readXmlBollettino("dopodomani").get(1)%>
	
							<br /> <span style="font-weight: bold;">Venti: </span><br />
							<%=previsioni.readXmlBollettino("dopodomani").get(2)%>
	
							<br /> <span style="font-weight: bold;">Mare:</span><br />
							<%=previsioni.readXmlBollettino("dopodomani").get(3)%>
						</c:if>
						
						
						<c:if test="<%=!provincia.equals("ND") %>">
							<%=previsioniDetails.get(2)%>
						</c:if>
						
						<c:if test="<%=!provincia.equals("ND") %>">
						
							<div class="table table table-striped table--previsioni">
							
	                           <table>
	                           
	                               <thead>
	                                   <tr>
	                                   
	                                   	 <th scope="col" id="dato" aria-hidden="true"><span class="sr-only">Dato di riferimento</span></th>
	                                  	 <c:out value = "${tabellaDati.get(2).getHeader()}" escapeXml="false" />
	                                  	 <th scope="col" id="unita"><span class="sr-only">Unità di misura</span></th>
	                                  
	                                   </tr>
	                               </thead>
	                               
	                               <tbody>
	                               		<tr>
											<th>
												<abbr title="Temperatura minima: valori medi previsti nell'area">T min</abbr>
											</th> 
											<c:out value = "${tabellaDati.get(2).gettMin()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Temperatura massima: valori medi previsti nell'area">T	max</abbr>
												<c:out value = "${tabellaDati.get(2).gettMax()}" escapeXml="false" />
										</tr>
										<tr>
											<th>
												<abbr title="Precipitazioni: valori minimi e massimi previsti nell'area">Prec</abbr>
											</th>
											<c:out value = "${tabellaDati.get(2).getPrecipitazioni()}" escapeXml="false" />									
										</tr>
										<tr>
											<th>
												<acronym title="Vento massimo: valori massimi previsti nell'area">V	max</acronym> 
											</th>
											<c:out value = "${tabellaDati.get(2).getVento()}" escapeXml="false" />		
										</tr>
										
	                                 
	                               </tbody>
	                           </table>
	                           <p class="pt-3"> <small>I dati fra parentesi si riferiscono ai valori medi climatologici 1991-2010 </small> </p>
	                           
	                        </div>
	                        
						</c:if>

                    </div>
               	</div>
             </div>
               
               
           </div>
		</div>   
		
		<div class="col-12">
		
            <hr class="pb-3">
            
            <h2>Previsioni per provincia</h2>
            
            <portlet:renderURL var="meteoBO">
				<portlet:param name="prov" value="BO" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoFE">
				<portlet:param name="prov" value="FE" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoFC">
				<portlet:param name="prov" value="FC" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoMO">
				<portlet:param name="prov" value="MO" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoPC">
				<portlet:param name="prov" value="PC" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoPR">
				<portlet:param name="prov" value="PR" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoRA">
				<portlet:param name="prov" value="RA" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoRE">
				<portlet:param name="prov" value="RE" />
			</portlet:renderURL>
			
			<portlet:renderURL var="meteoRN">
				<portlet:param name="prov" value="RN" />
			</portlet:renderURL>
            
            <ul class="link-list flex-column flex-sm-row flex-sm-wrap page--previsioni__province">
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoBO%>">
                        <span class="link-list__item-label">Bologna</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoFE%>">
                        <span class="link-list__item-label">Ferrara</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoFC%>">
                        <span class="link-list__item-label">Forlì - Cesena</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoMO%>">
                        <span class="link-list__item-label">Modena</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoPR%>">
                        <span class="link-list__item-label">Parma</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoPC%>">
                        <span class="link-list__item-label">Piacenza</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoRA%>">
                        <span class="link-list__item-label">Ravenna</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoRE%>">
                        <span class="link-list__item-label">Reggio-Emilia</span>
                    </a>
                </li>
                <li class="link-list-item">
                    <a class="link-list-link" href="<%= meteoRN%>">
                        <span class="link-list__item-label">Rimini</span>
                    </a>
                </li>
            </ul>
         
        </div>                        
		
	</div>

 </div>

</main>
