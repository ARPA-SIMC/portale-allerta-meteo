<%@page import="it.eng.allerter.allerta.ListaStazioniAttiveBean"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="../init.jsp" %>

<%
ListaStazioniAttiveBean stazioni = (ListaStazioniAttiveBean) request.getAttribute("stazioni");
%>

<c:set value="<%=stazioni%>" var="stazioni" scope="request"></c:set>

<portlet:actionURL var="salvaURL" name="/allertaer/preferenze-monitoraggio/salva">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<main class="page main" id="main-content">

	<div class="container page__body" >

		<aui:form method="post" name="fmStazioni" action="<%= salvaURL.toString()%>">
		
		
			<div class="row">
			
				<div class="col-12">
			
					<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
				 		<div class="alert alert-danger" role="alert">
			    			<span class="icon i-error"></span> 
			    			<span><%= SessionErrors.get(request, Exception.class)%></span>
			  			</div>
					</c:if>		
					
					<div class="col-12">
				
						<h2 class="h2">Monitoraggio</h2>
					
						<div class="rf-cp rf-tgp bacini">
						
							<div class="rf-cp-b" style="display: block">
			
								<table class="table table-hover">
									<thead>
										<tr>
											<th></th>
											<th>Inclusa</th>
											<th >Id</th>
											<th >Nome</th>
											<th >Bacino di appartenenza</th>
										</tr>
		
									</thead>
									<c:forEach var="stazione" items="${stazioni.stazioni}">
									<tbody>
										<tr>
											<td>
												<c:set var="sid" value="${fn:replace(fn:replace(stazione.stazione.id, '/', ''), ',', '')}"/>
											
												<input 
													type="checkbox" ${stazione.incluso ? 'checked' : ''}
													id= "${sid}"
													name="<portlet:namespace/>stazionesel_${stazione.stazione.id }"
													class="stazionecbx">
												
											</td>
											<td>${stazione.stazione.id}</td>
											<td colspan="2">${stazione.stazione.name}</td>
											<td>
												${stazione.stazione.nameBasin}
											</td>									
										</tr>
									</tbody>
									</c:forEach>
									
								</table>
								
							</div>
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="row">
			
					<div class="col-2">
							<button 
								type="submit" 
								class="btn btn-primary">Salva Preferenze
							</button>
						</div>
						<div class="col-2">
							<a href="/" class="btn btn-primary">Annulla</a>
						</div>
			
			</div>
		</aui:form>
	</div>
</main>