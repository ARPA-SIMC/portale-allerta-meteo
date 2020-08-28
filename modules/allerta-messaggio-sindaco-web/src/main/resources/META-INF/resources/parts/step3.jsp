<%@ include file="../init.jsp"%>

<%

%>

<div class="row">
	<div class="col-12">
		<h2>Riepilogo del messaggio che verrà inviato</h2>
		
	</div>
</div>

<liferay-util:include page="/parts/header.jsp" servletContext="<%=getServletContext() %>"></liferay-util:include>


<div class="row">
	<div class="col-12">
<c:if test="${messaggioBean.sindaco}">
	<h3> Oggetto</h3>
	<p>
		${messaggioBean.obj_mail}
	</p>	
</c:if>
	</div>
</div>

<div class="row">
	<div class="col-12">

	<h3>Motivo del messaggio</h3>
	<p>
	${messaggioBean.mex_pc}
	</p>
	
	</div>
</div>


<div class="row">
	<div class="col-12">
	<h3>Testo SMS</h3>
	<p>
	${messaggioBean.subject}
	</p>
	</div>
</div>

<c:if test="${messaggioBean.sindaco}">
	<h3>Informazioni utili incluse</h3>
	
	<ul id="notify-general-information" class="clear-ul">
		<c:if test="${not empty messaggioBean.idAllertaSaved and not empty tabViewWizardBean.titoloAllertaSave}">
			<li class="done">
				<div class="getready-entry getready-entry-document">
					<div class="getready-entry-icon">
						<i class="fa fa-file-o"></i>
					</div>
				<div class="getready-entry-body">
					<a target="_blank" href="${themeDisplay.getPortalURL()}/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/${messaggioBean.idAllertaSaved}">${messaggioBean.titoloAllertaSaved} </a>
				</div>
			
			</div>
			</li>
			
		</c:if>
						
	</ul>

</c:if>

<c:if test="${messaggioBean.sindaco}">

	<ul>
		<c:if test="${messaggioBean.hasBooleanInfo('piene')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-piene">Cosa fare in caso di piene dei fiumi</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('frane')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-frane">Cosa fare in caso di frane</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('temporali')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-temporali">Cosa fare in caso di temporali</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('vento')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-vento">Cosa fare in caso di vento</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('mareggiate')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-mareggiate">Cosa fare in caso di mareggiate</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('ghiaccio')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-ghiaccio">Cosa fare in caso di ghiaccio</a>
				</div>
			</li>
		</c:if>
				
		<c:if test="${messaggioBean.hasBooleanInfo('neve')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-neve">Cosa fare in caso di neve</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('ondateDiCalore')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-ondate-di-calore">Cosa fare in caso di ondate di calore</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('incendi')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-incendi">Cosa fare in caso di incendi</a>
				</div>
			</li>
		</c:if>
		
		<c:if test="${messaggioBean.hasBooleanInfo('terremoto')  }">
			<li class="done">
				<div >
					<a target="_blank"  href="<%=themeDisplay.getPortalURL() %>/cosa-fare-in-caso-di-terremoto">Cosa fare in caso di terremoto</a>
				</div>
			</li>
		</c:if>
		
	</ul>				
</c:if>



<h3 >Canale di invio</h3>
<ul class="list-group">
	<c:if test="${messaggioBean.telefono == 'si' }">
		<li class="list-group-item">
			<label class="form-check-label" >
    				<span class="icon i-phone">Telefonata</span>
  			</label>
  					
		</li>
	</c:if>
	
	<c:if test="${messaggioBean.sms == 'si' }">
		<li class="list-group-item">
			<label class="form-check-label" >
    				<span class="icon i-envelope">SMS</span>
  			</label>
  					
		</li>
	</c:if>
	
	<c:if test="${messaggioBean.mail == 'si' }">
		<li class="list-group-item">
			<label class="form-check-label" >
    				<span class="icon i-envelope-o">Email</span>
  			</label>
  					
		</li>
	</c:if>
	
	<c:if test="${messaggioBean.social == 'si' }">
		<li class="list-group-item">
			<label class="form-check-label" >
    				<span class="icon i-share-alt">Social</span>
  			</label>
  					
		</li>
	</c:if>
	
	<c:if test="${messaggioBean.portale == 'si' }">
		<li class="list-group-item">
			<label class="form-check-label" >
    				<span class="icon i-bell-o">Portale</span>
  			</label>
  					
		</li>
	</c:if>
	
</ul>

