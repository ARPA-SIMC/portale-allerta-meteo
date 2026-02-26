<%@ include file="./init.jsp"%>

<h3 class="mt-2 mb-3"><span class="icon i-previsioni-dati" aria-hidden="true"></span> <liferay-ui:message key="allertacomuneweb.p1" /> </h3>
<nav role="navigation" class="nav-vertical nav-vertical--icon-on-each ">
    <ul class="nav flex-column">

		<li class="nav-item">
			<a class="nav-link " href="/previsioni-regionali">
               <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p2" /></span>
           	</a>
		</li>
		
		<li class="nav-item">

            <a class="nav-link collapsed" href="#previsioni-e-dati__sub" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="previsioni-e-dati__sub">
                <span class="icon i-plus-square-o" title="Espandi/richiudi"></span>
                <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p3" /></span>
            </a>    
            
            <ul class="list-unstyled collapse" id="previsioni-e-dati__sub" style="">
               <li class="nav-item">
	               <a class="nav-link " href="/precipitazioni">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p11" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/livello-idrometrico">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p12" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/temperature">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p13" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/vento">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p14" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/umidita">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p15" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/pressione">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p16" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/cumulativa-6">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p17" /></span>
	               </a>    
               </li>
               <li class="nav-item">
	               <a class="nav-link " href="/cumulativa-48">
	                   <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p18" /></span>
	               </a>    
               </li>
           </ul>
       </li>
       
       <li class="nav-item">
         <a class="nav-link " href="/radar-meteo">
             <span class="nav-vertical__item-label"><liferay-ui:message key="allertacomuneweb.p4" /></span>
         </a>    
       </li>
    </ul>
</nav>
