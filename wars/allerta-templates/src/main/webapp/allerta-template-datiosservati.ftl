
<main class="page main page--single-dato" id="main-content">

	<div class="page__head">
	
		 <div class="container d-flex">
		 
		 	<div class="row w-100 justify-content-between">
	            <div class="col-10 col-lg-10">
	                <h1 id='pageTitle'></h1> 
	                <p class="lead"></p>
	            </div>   
            </div>
          </div>
     </div>
     
    <div class="breadcrumb-container">
        <div class="container d-flex">
            <nav class="row" aria-label="Hai percorso">
                <ol class="breadcrumb">
    
                    <li class="breadcrumb-item">
                        <a href="/">Home</a>
                    </li>
                    <li class="breadcrumb-item">
                       <a href="/previsioni-e-dati">Previsioni e dati</a>
                    </li>
    
                    <li class="breadcrumb-item active" aria-current="page" id='liPageTile'> </li>
    
                </ol>
            </nav>
        </div>
    </div>
    
    ${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}
    
    
    <div class="portlet-boundary portlet-boundary_com_liferay_journal_content_web_portlet_JournalContentPortlet_  decorate portlet-journal-content  portlet-draggable yui3-dd-drop" id="p_p_id_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_PZXqtaQX5PDC_">

<section>

	<div class="portlet-content portlet-content-editable">
<div >
	<dl><dd><section class="u-background--cyan py-3 pb-5">
<div class="container">
<div class="row pt-3">
<div class="col-12">
<h2>Tutti gli strumenti della sezione Previsioni e Dati</h2>

<ul class="link-list link-list--row row">
	<li class="link-list-item col-12 col-md-3">
	<div class="link-list-span link-list__sub-link-list__heading"><span class="icon i-previsioni-meteo" title="Icona Previsioni Meteo"></span> Previsioni meteo</div>

	<ul class="link-list flex-column">
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/previsioni-regionali" target=""><span class="link-list__item-label">Previsioni regionali</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/previsioni-a-medio-termine"><span class="link-list__item-label">Previsioni a medio termine</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/previsioni-meteo-modellistiche"><span class="link-list__item-label">Previsioni meteo modellistiche</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/previsioni-mare"><span class="link-list__item-label">Previsioni mare</span> </a></li>
	</ul>
	</li>
	<li class="link-list-item col-12 col-md-6">
	<div class="link-list-span link-list__sub-link-list__heading"><span class="icon i-dati-osservati" title="Icona Dati Osservati"></span> Dati osservati</div>

	<ul class="link-list link-list--md-two-col">
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/precipitazioni"><span class="link-list__item-label">Precipitazioni</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/livello-idrometrico"><span class="link-list__item-label">Livelli idrometrici</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/temperature"><span class="link-list__item-label">Temperature</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/vento"><span class="link-list__item-label">Vento</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/umidita"><span class="link-list__item-label">Umidit&#224; relativa</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/pressione"><span class="link-list__item-label">Pressione</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/livello-mare"><span class="link-list__item-label">Livello mare</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/altezza-onda"><span class="link-list__item-label">Altezza onda</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/direzione-onda"><span class="link-list__item-label">Direzione onda</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/cumulativa-6"><span class="link-list__item-label">Pioggia cumulata 6h</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/cumulativa-24"><span class="link-list__item-label">Pioggia cumulata 24h</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/cumulativa-48"><span class="link-list__item-label">Pioggia cumulata 48h</span> </a></li>
	</ul>
	</li>
	<li class="link-list-item col-12 col-md-3">
	<div class="link-list-span link-list__sub-link-list__heading"><span class="icon i-radar-meteo" title="Icona Radar Meteo"></span> Radar meteo</div>

	<ul class="link-list flex-column">
		<li class="link-list-item"><a class="link-list-link " href="/web/guest/radar-meteo"><span class="link-list__item-label">Radar meteo: stima delle piogge</span> </a></li>
		<li class="link-list-item"><a class="link-list-link " href="/nowcasting-evoluzione-degli-echi-radar"><span class="link-list__item-label">Nowcasting: evoluzione degli echi radar</span> </a></li>
	</ul>
	</li>
</ul>
</div>
</div>
</div>
</section></dd></dl>
</div>

		
	</div>
</section>




	</div>
</main>

<script>
 $(document).ready( function() {
 	console.log('ready');
 	var m =$("meta[property='og:title']").attr("content");
 	console.log(m);
 	$('#pageTitle').html(m);
 	$('#liPageTile').html(m);
 });
 
</script>
           