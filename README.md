# portale-allerta-meteo

Copyright (c) 2020 Arpae-SIMC

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published
by the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>

# Portale Allerta Meteo Regione Emilia-Romagna
Questo repository contiene il codice sorgente e i file di supporto relativi al Portale Allerta Meteo della Regione Emilia-Romagna. Si tratta di un progetto di personalizzazione del software CMS Liferay Community, che introduce strumenti per la generazione documentale, la raccolta di dati e immagini in tempo reale da fonti informative, strumenti per la gestione di siti comunali, un modulo di rubrica e meccanismi di integrazione con sistemi di comunicazione terzi (invio SMS e pubblicazione su social come Telegram.)

# Descrizione e finalità
Tramite il software è possibile redigere allerte, bollettini e documenti di monitoraggio; caricare altre categorie documentali; mandare comunicazioni a gruppi presenti nella rubrica; caricare dati di sensori forniti secondo opportuni protocolli; stabilire regole anche complesse per allertare gruppi di rubrica sulla base dei dati dei sensori; importare dati previsionali forniti secondo opportuni protocolli; creare e mantenere siti comunali, dando ai sindaci e loro delegati la facoltà di postare news, caricare tavole e piani di protezione civile e spedire comunicazioni agli iscritti. Tutto questo in aggiunta a tutte le funzionalità di Content Management System offerte da Liferay.

Il portale è online e raggiungibile su https://allertameteo.regione.emilia-romagna.it

# Struttura del repository
- configs: script per ricreare le viste di database (le tabelle sono create automaticamente dal software alla prima esecuzione, se ha i permessi per farlo.)
- gradle: file di gradle (builder dei progetti)
- kaleo: file contenenti i workflow del sito, da usare as-is oppure modificare secondo le esigenze (https://help.liferay.com/hc/en-us/articles/360018174111-Introduction-to-Workflow)
- modules: progetti che producono moduli .jar con le funzionalità del sistema
- war: come i moduli, ma producono file .war invece che .jar e forniscono temi e template di pagina.

# Requisiti
Valgono i requisiti di Liferay 7.2. consultabili nel dettaglio https://www.liferay.com/it/product/tech-specs . In breve:
- sistemi operativi Linux (tutte le distribuzioni con JVM) o Windows
- web server 
    (JBoss EAP,
    tcServer,
    Tomcat,
    WebLogic,
    WebSphere,
    Wildfly)
- database
    (DB2,
    MariaDB,
    MySQL,
    Oracle,
    PostgreSQL,
    SQL Server,
    Sybase)
    
Un'installazione di produzione richiede un'istanza separata del software ElasticSearch: https://www.elastic.co/ . In sviluppo è invece sufficiente l'istanza fornita all'interno dello stesso Liferay.

Il sistema non ha alcuna dipendenza da software che non siano *open source*.

# Stato del progetto
Il progetto è rilasciato come stabile.

# Detentori del copyright
ARPAE / Agenzia Regionale per la Sicurezza Territoriale e la Protezione Civile Emilia-Romagna

# Soggetti incaricati del mantenimento del progetto open source
Gruppo Engineering - https://www.eng.it

# Indirizzo per le segnalazioni di sicurezza
simc-allerta-referenti@arpae.it

# Installazione
Per l'installazione di Liferay 7 Community fare riferimento alla documentazione di Liferay: https://www.liferay.com/it/downloads-community,  https://help.liferay.com/hc/en-us/articles/360018175851-Preparing-for-Install

Terminata l'installazione di Liferay vanno installati i moduli del Portale. Questo richiede un tool di sviluppo: è fortemente consigliato l'uso di Liferay Developer Studio, una versione personalizzata dell'IDE Eclipse. Tutte le informazioni su https://help.liferay.com/hc/en-us/articles/360017885052-Installing-Liferay-Dev-Studio-DXP

L'intero contenuto del repository può essere importato massivamente come progetti nel Developer Studio. Il builder gradle contenuto nell'IDE provvederà a creare i moduli .jar e .war, disponibili nelle directory /build/libs di ciascun modulo. Questi file possono essere deployati in una qualunque istanza Liferay 7 trascinandoli o copiandoli nella directory /deploy di Liferay. In alternativa, un'istanza di Liferay collegata all'IDE Liferay Developer Studio è automaticamente sincronizzata con l'ambiente di sviluppo.

I workflow, se desiderati, vanno creati copiando i contenuti della directory kaleo e creando nuovi workflow con quei testi dal pannello di controllo Liferay.

# Utilizzo
L'amministrazione di un sito Liferay è un argomento vasto su cui è disponibile una grande quantità di documentazione dedicata: https://help.liferay.com/hc/en-us/categories/360000928332-Liferay-DXP-7-0-Admin-Guide . Per usare questo portale è necessaria una familiarità con i concetti principali di Liferay.

L'identità del sito, intesa come struttura delle pagine, non è inclusa nel repository. Diventeranno invece disponibili all'amministratore il tema grafico del portale, nonché i seguenti widget (portlet) di categoria Allerta-Meteo, da disporre come si desidera all'interno del sito:

- **Allerta Messaggio del Sindaco**: permette di comporre un messaggio e di inviarlo a un gruppo di destinatari tramite uno o più canali
- **Allerta Previsioni Home**: widget con previsioni regionali su 3 giorni
- **Allerta Previsioni Medio Termine**: widget con previsioni a medio termine
- **Allerta Previsioni Terriotrio**: widget con previsioni provinciali su 3 giorni
- **Allerte e Bollettini**: widget con elenco di allerte e bollettini
- **Animazione Cumulativa 48h**: animazione cumulata pioggia su 48 ore
- **Animazione Cumulativa 6h**: animazione cumulata pioggia su 6 ore
- **Animazione Idrometrico**: grafico con sensori idrometrici su mappa
- **Animazione Mare**: grafico con sensori moto ondoso su mappa
- **Animazione Meteo**: grafico con animazione stato meteo nel tempo
- **Animazione Precipitazioni**: grafico con sensori pluviometrici su mappa
- **Animazione Pressione**: grafico con sensori pressione su mappa
- **Animazione Radar**: grafico con dati radar su mappa
- **Animazione Temperatura**: grafico con sensori temperatura su mappa
- **Animazione Umidita**: grafico con sensori umidità su mappa
- **Animazione Vento**: grafico con sensori vento su mappa
- **Breadcrumbs**: briciole di pane secondo lo stile grafico del portale
- **Cartografia Comune**: widget per le tavole in pdf messe a disposizione dal comune
- **Compila Allerta**: compilazione allerte/bollettini
- **Compila Documento Monitoraggio**: compilazione documenti di monitoraggio
- **Comune Previsione-Dati**: mappa centrata su un comune, con vari strati informativi
- **Configurazione Allarmi**: gestione delle regole di superamento soglie dei sensori
- **Configurazione Sensori**: gestione dell'elenco di sensori con attivazione/disattivazione e settaggio della soglia di "spike" idrometrico (valori fuori scala che non generano superamenti di soglia)
- **Console per la gestione degli Scheduler di invio/verifica SMS**: pannello per il controllo dell'invio degli SMS
- **Cruscotto di sistema**: elenco di messaggi di sistema
- **Dettaglio report Evento:** gestione report post-evento
- **Documenti Comune**: gestione degli altri documenti caricati dal comune
- **Elenco SMS**: SMS inviati, suddivisi per invio con statistiche globali di invio e ricezione
- **Gestione Monitoraggio**: gestione dello stato di monitoraggio, che accende un tab aggiuntivo in home page per il monitoraggio degli eventi meteo in tempo reale
- **Grafico Sensori**: grafico con l'andamento di un sensore negli ultimi 3 giorni, sia puntuale che (per la pioggia) come valore cumulato
- **Home Comune Testa**: sezione news su sito comunale
- **Link Social**: link per share sui social media
- **Login e Registrazione**: widget per effettuare login e registrazione utenti
- **Luoghi Preferiti**: pannello che permette a un utente di iscriversi a un comune
- **Monitoraggio**: elenco dei documenti di monitoraggio
- **Nowcasting**: grafico del nowcasting degli echi radar
- **Preferenze Monitoraggio**: preferenze per la creazione del documento di monitoraggio (i sensori che possono essere inclusi nel documento)
- **Report Invii analitico**: pannello con dettagli sui singoli SMS spediti e il loro stato di ricezione
- **Strumenti Sindaco**: pulsanti per accedere alle funzionalità di amministrazione di un comune





