<%@ include file="./init.jsp"%>

<%
	GestioneBean gestioneBean = (GestioneBean) renderRequest.getAttribute("GestioneBean");
%>

<c:set 
	var="tendenza" 
	value="<%=gestioneBean.getTendenza() %>" 
	scope="request">
</c:set>


<main class="page main page--previsioni-medio-termine" id="main-content">

    <div class="page__head" >
        
        <div class="container d-flex">
        
            <div class="row w-100 justify-content-between">
            
                <h1 class="col-12 col-lg-12">Previsioni a medio termine</h1>
                
                <p class="col-12 lead"></p>
            </div>            
        </div>
        
        <div class="breadcrumb-container">
        
            <div class="container d-flex">
            
                <nav class="row" aria-label="Hai percorso">
                
                    <ol class="breadcrumb">
        
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
        
                        <li class="breadcrumb-item active" aria-current="page">Previsioni a medio termine</li>
        
                    </ol>
                </nav>
            </div>
    	</div>
    	
    </div>
    
     <div class="container page__body">
		<div class="row"> 
        	<div class="col-12 page__content" id="page-content">
        		<p><c:out value = "${tendenza.get('previsione')}" escapeXml="false" /></p>
        		
				<div class="row py-3">
                	<div class="col-12 col-lg-3 pb-3 d-flex flex-column align-items-center">
						<h2><c:out value = "${tendenza.get('1')}" escapeXml="false" /></h2>
						<div class="pt-2">
							<img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_meteo_1')}" escapeXml="false" />" alt="" title="" />
                        </div>
                        <div class="pt-2">
                            <img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_temp_1')}" escapeXml="false" />" alt="" title="" />
                        </div>
                     </div>
					<div class="col-12 col-lg-3 pb-3 d-flex flex-column align-items-center">
						<h2><c:out value = "${tendenza.get('2')}" escapeXml="false" /></h2>
						<div class="pt-2">
							<img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_meteo_2')}" escapeXml="false" />" alt="" title="" />
                        </div>
                        <div class="pt-2">
                            <img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_temp_2')}" escapeXml="false" />" alt="" title="" />
                        </div>
                     </div>    
                     <div class="col-12 col-lg-3 pb-3 d-flex flex-column align-items-center">
						<h2><c:out value = "${tendenza.get('3')}" escapeXml="false" /></h2>
						<div class="pt-2">
							<img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_meteo_3')}" escapeXml="false" />" alt="" title="" />
                        </div>
                        <div class="pt-2">
                            <img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_temp_3')}" escapeXml="false" />" alt="" title="" />
                        </div>
                     </div>    
                     <div class="col-12 col-lg-3 pb-3 d-flex flex-column align-items-center">
						<h2><c:out value = "${tendenza.get('4')}" escapeXml="false" /></h2>
						<div class="pt-2">
							<img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_meteo_4')}" escapeXml="false" />" alt="" title="" />
                        </div>
                        <div class="pt-2">
                            <img src="data:image/jpg;base64,<c:out value = "${tendenza.get('tend_temp_4')}" escapeXml="false" />" alt="" title="" />
                        </div>
                     </div>               
                             
                </div>
				<p> <em><%=gestioneBean.getEmissione() %></em></p>
             </div>
        </div>
     </div>    
                        
</main>                