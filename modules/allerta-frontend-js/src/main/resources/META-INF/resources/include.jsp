<%@page import="java.util.Date"%>
<%
	long ts = new Date().getTime();
	boolean nuovaMappa = true;
%>
<!-- assets 	-->
<script src="/o/allerta-frontend-js/js/moment.min.js"></script>
<script src="/o/allerta-frontend-js/js/moment-locale-it.js"></script>

<script src="/o/allerta-frontend-js/js/swiper.min.js"></script>
<script src="/o/allerta-frontend-js/js/am.theme.js?v=0.93"></script>

<script src="/o/allerta-frontend-js/js/leaflet.js"></script>
<script src="/o/allerta-frontend-js/js/leaflet-search.src.js?v=1.15"></script>
<script src="/o/allerta-frontend-js/js/bootstrap-datetimepicker.js"></script>



<script src="/o/allerta-frontend-js/js/am.data.aree-idro-new.js?v=1.3"></script>
<script src="/o/allerta-frontend-js/js/am.data.comuni-new.js?v=1.4"></script>

<script src="/o/allerta-frontend-js/js/am.data.aree-idro.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.comuni.js"></script>


<script src="/o/allerta-frontend-js/js/am.data.regione.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.bacini.js"></script>
<script src="/o/allerta-frontend-js/js/am.data.reticolo.js"></script>

<script src="/o/allerta-frontend-js/js/am.aria.bootstrap-datetimepicker.js"></script>


<script src="/o/allerta-frontend-js/js/am.map-config-new.js?v=1.3"></script>
<script src="/o/allerta-frontend-js/js/am.map-config.js?v=1.8"></script>


<script src="/o/allerta-frontend-js/js/am.leaflet-controls.js?ts=<%=ts%>"></script>


<script src="/o/allerta-frontend-js/js/am.map-data-server-new.js?v=0.62g"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-server.js?v=0.42g"></script>


<script src="/o/allerta-frontend-js/js/am.map-data-scenario.js?v=0.9"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-sensore.js?v=1.99"></script>
<script	src="/o/allerta-frontend-js/js/am.map-data-scenario-precipitazioni.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-pressione.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-livellomare.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-altezzaonda.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-direzioneonda.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-umidita.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-temperature.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-vento.js?v=0.3"></script>
<script	src="/o/allerta-frontend-js/js/am.map-data-scenario-idrometrico.js?v=0.2"></script>
<script src="/o/allerta-frontend-js/js/am.map-phenomenon-scenario.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-radar.js?v=1.13"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-nowcasting.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-animeteo.js?v=1.7"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-immagini.js"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-cumulata.js?v=1.1"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-animazione-mare.js?v=1.0"></script>
<script src="/o/allerta-frontend-js/js/am.map-data-scenario-factory.js?v=1.5"></script>

<script src="/o/allerta-frontend-js/js/am.map-data-render.js"></script>

<script src="/o/allerta-frontend-js/js/am.map-component.js"></script>
<script src="/o/allerta-frontend-js/js/am.data-map.js?v=0.95"></script>


<script src="/o/allerta-frontend-js/js/am.forecast-map-new.js?v=0.14"></script>
<script src="/o/allerta-frontend-js/js/am.forecast-map.js?v=0.8"></script>

<script src="/o/allerta-frontend-js/js/am.monitoring-map.js?v=0.9"></script>
<script src="/o/allerta-frontend-js/js/am.backoffice-monitoring-map.js?v=0.2"></script>
