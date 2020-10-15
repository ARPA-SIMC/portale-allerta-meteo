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
    JBoss EAP
    tcServer
    Tomcat
    WebLogic
    WebSphere
    Wildfly
- database
    DB2
    MariaDB
    MySQL
    Oracle
    PostgreSQL
    SQL Server
    Sybase
    
Il sistema non ha alcuna dipendenza da software che non siano *open source*.




