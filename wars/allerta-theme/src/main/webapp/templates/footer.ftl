<!-- # sezioni/layout/footer -->
  <footer class="col-12 flex-column flex-md-row align-content-center footer">
    <div class="container">
        <div class="row d-print-flex">
            <div class="col-12">
                <h2>Allerta Meteo Emilia-Romagna &egrave; un progetto di</h2>
            </div>
            
            <div class="col-12 col-lg-4 mb-4">
                <a class="footer__brand" href="https://www.arpae.it/" title="Vai al sito di Arpae">
                    <picture>
                        <img src="${css_folder}/../img/logo-arpae--neg.png" alt="Logo Arpae" class="brand--arpae">
                    </picture>
                </a>    
                <h3>Arpae Emilia-Romagna - <br>Servizio Idro-Meteo-Clima</h3>
                <p>P.IVA 04290860370</p>
                <p>Viale Silvani 6, 40122 Bologna</p>
                <p>tel. <a href="tel:+390516497511">+39 0516 497511</a></p>
                <p>email: <a href="mailto:simc-urp@arpae.it">simc-urp@arpae.it</a> </p>
                <p>email: <a href="mailto:aoosim@cert.arpa.emr.it">aoosim@cert.arpa.emr.it</a></p>
            </div>
            
            <div class="col-12 col-lg-4 mb-4">
                <a class="footer__brand" 
                    href="https://protezionecivile.regione.emilia-romagna.it/" 
                    title="Vai al sito di Agenzia per la sicurezza territoriale e la protezione civile dell'Emilia-Romagna">
                    <picture>
                        <img src="${css_folder}/../img/logo-protezione-civile--neg.png" alt="Logo di Agenzia per la sicurezza territoriale e la protezione civile" class="brand--prociv">
                    </picture>
                </a>    
                <h3>Agenzia per la sicurezza territoriale<br> e la protezione civile - Emilia-Romagna</h3>
                <p>Cod fiscale 91278030373</p>
                <p>Viale Silvani 6, 40122 Bologna</p>
                <p> tel. <a href="tel:+390515274404">+39 051 527 44 04</a> - fax +39 051 558 545</p>
                <p> email: <a href="mailto:procivsegr@regione.emilia-romagna.it">procivsegr@regione.emilia-romagna.it </a>,<br> 
                    <a href="mailto:procivsegr@postacert.regione.emilia-romagna.it">procivsegr@postacert.regione.emilia-romagna.it</a>
                </p>
            </div>

            <div class="col-12 col-lg-4 mb-4">
                <a class="footer__brand" href="http://www.regione.emilia-romagna.it/" title="Vai al sito di Regione Emilia-Romagna">
                    <picture>
                        <img src="${css_folder}/../img/logo-rer-xl--neg.png" alt="Logo Regione Emilia-Romagna" class="brand--rer">
                    </picture>
                </a>    
                <h3> Regione Emilia-Romagna </h3>
                <p> CF 800.625.903.79 </p>
                <p> Viale Aldo Moro 52, 40127 Bologna</p>
                <p> Centralino: <a href="tel:+390515271">+39 051 5271</a> </p>
                <p> <strong> Ufficio Relazioni con il Pubblico</strong>:<br> 
                    Numero Verde URP: <a href="tel:+39800662200">+39 800 66 22 00</a>, <br>
                    <a href="mailto:urp@regione.emilia-romagna.it">urp@regione.emilia-romagna.it</a>,<br> 
                    <a href="mailto:urp@postacert.regione.emilia-romagna.it">urp@postacert.regione.emilia-romagna.it</a>
                </p>
            </div>

            <div class="col-12 mt-3 d-flex flex-column flex-md-row justify-content-md-center align-items-md-center">
                <div class="align-md-self-center">
                    &copy; 2019 Allerta Meteo Emilia-Romagna
                </div>
                <nav  role="navigation">
                    <ul class="nav flex-column flex-md-row">
                            <li class="nav-item ">
                                <a class="nav-link" href="/informativa" title="Vai a Informativa sulla privacy">Informativa sulla privacy</a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/cookie" title="Vai a Informativa sui cookie">Informativa sui cookie</a>
                            </li>
			    <li class="nav-item"><span  class="nav-link" style="padding-left:5px;padding-right:10px;color:#ffffff">Seguici su</span>
	    			<span>
                <a style="text-decoration:none" target="_blank" title="Segui Allerta Meteo Emilia-Romagna su Twitter" href="https://twitter.com/AllertaMeteoRER"><span class="icon i-twitter" style="margin-right:0.5rem"/></a>
            			</span>
            			<span>
                <a style="text-decoration:none" target="_blank" title="Segui Allerta Meteo Emilia-Romagna su Telegram" href="https://t.me/AllertaMeteoEMR"><span class="icon i-telegram" style=""/></a>
           			 </span>
			    </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</footer>
<script type="text/javascript">

/* 	Aggiungere (o togliere) se necessario una definizione di variabile "var indexn = ..." per ogni ulteriore ambiente di test/sviluppo/backend da non tracciare e
	modificare di conseguenza la condizione di filtro per escludere dal tracciamento anche le visite provenienti da quei siti.
*/	 
    var _paq = _paq || [];

var index1 = location.href.indexOf("applicazioni.regione.emilia-romagna.it");
var index2 = location.href.indexOf("applicazionitest.regione.emilia-romagna.it");
var index3 = location.href.indexOf("wwwservizitest.regione.emilia-romagna.it");
var index4 = location.href.indexOf("cm.regione.emilia-romagna.it");
var index5 = location.href.indexOf("test-cm.regione.emilia-romagna.it");
var index6 = location.href.indexOf("www2.regione.emilia-romagna.it");
var index7 = location.href.indexOf("localhost");
var index8 = location.href.indexOf("//10.");

(function(){ var u="https://statisticheweb.regione.emilia-romagna.it/analytics/";

if (index1==-1 && index2==-1 && index3==-1 && index4==-1 && index5==-1 && index6==-1 && index7==-1 && index8==-1){

    _paq.push(['setSiteId', 125]);
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setDocumentTitle', document.domain + "/" + document.title]);
    _paq.push(['trackPageView']);
    _paq.push(['enableLinkTracking']);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; g.type='text/javascript'; g.defer=true; g.async=true; g.src=u+'piwik.js';

    s.parentNode.insertBefore(g,s); }})();

</script>

<noscript><p><img src="https://statisticheweb.regione.emilia-romagna.it/analytics/piwik.php?idsite=125" style="border:0" alt="" /></p></noscript>

<!-- / sezioni/layout/footer -->