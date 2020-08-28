<%@ include file="../init.jsp"%>

<%
%>



<!-- # sezioni/navigazione/wizard-bar -->
<div class="wizard-bar">

  <div class="wizard-bar__summary">
    Passo ${messaggioBean.step } di 4
  </div>

  <ul class="nav flex-row" role="tablist">

        <li role="presentation" class="nav-item ${messaggioBean.step == 1 ? 'active current' : '' }" data-target="#step-body-1">
          <span class="nav-span" data-id="#step-1">
            <span class="circle">1</span> <span class="step-label">Prepara il contenuto</span>
          </span>
        </li>
        <li role="presentation" class="nav-item ${messaggioBean.step == 2 ? 'active current' : '' }" data-target="#step-body-2">
          <span class="nav-span" data-id="#step-2">
            <span class="circle">2</span> <span class="step-label">Scegli il canale</span>
          </span>
        </li>
        <li role="presentation" class="nav-item ${messaggioBean.step == 3 ? 'active current' : '' } " data-target="#step-body-3">
          <span class="nav-span" data-id="#step-3">
            <span class="circle">3</span> <span class="step-label">Conferma ed invia</span>
          </span>
        </li>
        <li role="presentation" class="nav-item  ${messaggioBean.step == 4 ? 'active current' : '' }" data-target="#step-body-4">
          <span class="nav-span" data-id="#step-4">
            <span class="circle">4</span> <span class="step-label">Fine</span>
          </span>
        </li>

  </ul>
</div><!-- / sezioni/navigazione/wizard-bar -->

<div class="row">
	<div class="col-12">
		<liferay-util:include page="/parts/step${messaggioBean.step}.jsp" servletContext="<%=getServletContext() %>"></liferay-util:include>
	
	</div>
</div>

