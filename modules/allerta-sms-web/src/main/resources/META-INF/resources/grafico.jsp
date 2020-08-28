<%@page import="it.eng.sms.bean.SMSGrafico"%>
<%@ include file="/init.jsp" %>

<%
 SMSGrafico g = new SMSGrafico();
%>
<script type="text/javascript">
	var data = <%= g.getLastMonthSms()%>; 
</script>


<div class="row text-center">
	<div class="col-md-6">
		
		SMS inviati totale <%=g.getTotalSMS()%>
	</div>
	<div class="col-md-6">
		SMS inviati oggi <%=g.getDaySMS() %>
	</div>
</div>
	
<div class="row text-center">	
	<div class="chart-container">
		<canvas id="myChart" style="background-color: white !important;"></canvas>
	</div>
</div>