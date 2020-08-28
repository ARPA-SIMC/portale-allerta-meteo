<%@page import="it.eng.allerta.animazione.bean.RadarBean"%>
<%@ include file="./init.jsp" %>
<%
RadarBean graficoBean = (RadarBean) renderRequest.getAttribute("GraficoBean");
%>

<script type="text/javascript">
	var  data = <%=graficoBean.graficoData()%>;
	var theService = location.protocol + "//" + location.hostname + ":"+location.port+"/o/api/allerta/";
	
</script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/grafico.css" />

<script src="<%=request.getContextPath()%>/js/d3.v3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jstorage.js?v=0.1c"></script>
<script src='<%=request.getContextPath()%>/js/common.js'></script>
<script src='<%=request.getContextPath()%>/js/grafico.js?v=0.1'></script>


<table id='infoMinime'>
	<tr>
		<td>ultimo dato:<span class='ultDato'></span></td>
		<td class='cellaDX'>bacino:<span class='basin'></span></td>
	</tr>
	<tr>
		<td>ore: <span class='ultOre'></span></td>
		<td class='cellaDX subba'>sottobacino: <span class='subbasin'></span></td>
	</tr>
	<tr>
		<td>di: <span class='ultGiorno'></span></td>
		<td class='cellaDX'>quota sensore: <span class='quota'></span>
			m s.l.m.
		</td>
	</tr>
</table>
<div class='progressBarCont'></div>
<div id='container'></div>
<div id='anag'></div>
<div class='attendere'>attendere</div>
<div id='frm_dexter'></div>