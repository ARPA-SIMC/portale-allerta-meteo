<%@page import="java.util.Date"%>
<%
	long ts = new Date().getTime();
%>
<!-- assets 	-->
<script src="/o/allerta-frontend-js/js/moment.min.js"></script>
<script src="/o/allerta-frontend-js/js/moment-locale-it.js"></script>

<script src="/o/allerta-frontend-js/js/swiper.min.js"></script>
<script src="/o/allerta-frontend-js/js/am.theme.js?v=0.8"></script>

<script src="/o/allerta-frontend-js/js/leaflet.js"></script>
<script src="/o/allerta-frontend-js/js/leaflet-search.src.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/bootstrap-datetimepicker.js"></script>

<script src="/o/allerta-frontend-js/js/am.data.aree-idro.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.comuni.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.regione.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.bacini.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.reticolo.js"></script>

<script src="/o/allerta-frontend-js/js/am.aria.bootstrap-datetimepicker.js"></script>

<script src="/o/allerta-frontend-js/js/am.map-config.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/am.leaflet-controls.js?ts=<%=ts%>"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-server.js?v=0.1g"></script>

<script src="/o/allerta-frontend-js/js/am.map-data-scenario.js?v=0.8"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-sensore.js?v=0.9"></script>
<script	src="/o/allerta-frontend-js/js/am.map-data-scenario-precipitazioni.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-pressione.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-umidita.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-temperature.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-vento.js"></script>
<script	src="/o/allerta-frontend-js/js/am.map-data-scenario-idrometrico.js?v=0.2"></script>
<script src="/o/allerta-frontend-js/js/am.map-phenomenon-scenario.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-radar.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-immagini.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-cumulata.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-factory.js"></script>

<script src="/o/allerta-frontend-js/js/am.map-data-render.js"></script>

<script src="/o/allerta-frontend-js/js/am.map-component.js"></script>
<script src="/o/allerta-frontend-js/js/am.data-map.js?v=0.7"></script>

<script src="/o/allerta-frontend-js/js/am.forecast-map.js?v=0.5"></script>
<script src="/o/allerta-frontend-js/js/am.monitoring-map.js?v=0.9"></script>
<script src="/o/allerta-frontend-js/js/am.backoffice-monitoring-map.js?v=0.2"></script>
