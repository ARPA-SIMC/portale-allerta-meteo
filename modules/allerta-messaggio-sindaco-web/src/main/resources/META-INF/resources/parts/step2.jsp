<%@ include file="../init.jsp"%>

<%
String canaleTelefonico = sindacoConfiguration.canaleTelefonico();
String canaleSms = sindacoConfiguration.canaleSms();
String canaleMail = sindacoConfiguration.canaleMail();
String canaleSocial = sindacoConfiguration.canaleSocial();
String canalePortale = sindacoConfiguration.canalePortale();

%>
<div class="row">
	<div class="col-12">
		<h2>Scegli con quale canale inviare il messaggio</h2>
		<ul class="list-group">
			<c:if test="<%=canaleTelefonico.equals("si") %>">
				<li class="list-group-item">
				<div class="form-check">
  					<aui:input name="selectBooleanChannel[]" type="checkbox" label="" wrappedField="true"
						cssClass="form-check-input" value="telefono" checked="${messaggioBean.telefono == 'si' }"></aui:input>
  					<label class="form-check-label" >
    					<span class="icon i-phone">Telefonata</span>
  					</label>
  					<div style="font-size: 0.9em;">Verrà effettuata una chiamata ed inviato un sms.</div>
				</div>
				</li>
			</c:if>
			<c:if test="<%=canaleSms.equals("si") %>">
				<li class="list-group-item">
				<div class="form-check">
					<aui:input name="selectBooleanChannel[]" type="checkbox" label="" wrappedField="true"
						cssClass="form-check-input" value="sms" checked="${messaggioBean.sms == 'si' }"></aui:input>
  					<label class="form-check-label" >
    					<span class="icon i-envelope">SMS</span>
  					</label>
  					<div style="font-size: 0.9em;">Verrà inviato un sms.</div>
				</div>
				</li>
			</c:if>
			<c:if test="<%=canaleMail.equals("si") %>">
				<li class="list-group-item">
				<div class="form-check"> 
  					<aui:input name="selectBooleanChannel[]" type="checkbox" label="" wrappedField="true"
						cssClass="form-check-input" value="mail" checked="${messaggioBean.mail == 'si' }"></aui:input>
  					<label class="form-check-label" >
    					<span class="icon i-envelope-o">Email</span>
  					</label>
  					<div style="font-size: 0.9em;">Verrà inviata una email.</div>
				</div>
				</li>
			</c:if>
			<c:if test="<%=canaleSocial.equals("si") %>">
				<li class="list-group-item">
				<div class="form-check">
  					<aui:input name="selectBooleanChannel[]" type="checkbox" label="" wrappedField="true"
						cssClass="form-check-input" value="social" checked="${messaggioBean.social == 'si' }"></aui:input>
  					<label class="form-check-label" >
    					<span class="icon i-share-alt">Social Media</span>
  					</label>
  					<div style="font-size: 0.9em;">Verrà inviato su Facebook</div>
				</div>
				</li>
			</c:if>
			<c:if test="<%=canalePortale.equals("si") %>">
				<li class="list-group-item">
				<div class="form-check">
  					<aui:input name="selectBooleanChannel[]" type="checkbox" label="" wrappedField="true"
						cssClass="form-check-input" value="portale" checked="${messaggioBean.portale == 'si' }"></aui:input>
  					<label class="form-check-label" >
    					<span class="icon i-bell-o">Avviso su portale</span>
  					</label>
  					<div style="font-size: 0.9em;">Verrà aggiunto un avviso
									all'interno del portale</div>
				</div>
				</li>
			</c:if>
		</ul>
		<p>
		<span class="icon i-question-circle"></span> 
		Usa il canale opportuno
		</p>
	</div>
</div>

