create table ALLERTER_Allerta (
	uuid_ VARCHAR(75) null,
	allertaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	creatorName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stato INTEGER,
	numero VARCHAR(75) null,
	progressivo INTEGER,
	anno INTEGER,
	dataEmissione DATE null,
	dataInizio DATE null,
	dataFine DATE null,
	descrizioneMeteo TEXT null,
	tendenza INTEGER,
	note TEXT null,
	riferimenti TEXT null,
	utenteFirmaArpaId LONG,
	dataFirmaArpa DATE null,
	utenteFirmaProtId LONG,
	dataFirmaProt DATE null,
	parentId LONG,
	sintesi TEXT null,
	link VARCHAR(256) null,
	titolo TEXT null,
	tipoAllerta BOOLEAN,
	hash VARCHAR(75) null,
	sintesiBriefing VARCHAR(75) null
);

create table ALLERTER_AllertaParametro (
	parametroId VARCHAR(75) not null primary key,
	valore TEXT null
);

create table ALLERTER_AllertaStato (
	uuid_ VARCHAR(75) null,
	allertaStatoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	dataInizio DATE null,
	dataFine DATE null,
	parentId LONG,
	allertaId LONG,
	statoId LONG,
	eventoId LONG,
	areaId LONG
);

create table ALLERTER_AllertaValanghe (
	uuid_ VARCHAR(75) null,
	allertaValangheId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	creatorName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dataEmissione DATE null,
	dataInizio DATE null,
	dataFine DATE null,
	numero VARCHAR(75) null,
	progressivo INTEGER,
	anno INTEGER,
	titolo VARCHAR(75) null,
	descrizioneFenomeni VARCHAR(75) null,
	note VARCHAR(75) null,
	riferimenti VARCHAR(75) null,
	sintesi VARCHAR(75) null,
	utenteFirmaArpaId LONG,
	dataFirmaArpa DATE null,
	utenteFirmaProtId LONG,
	dataFirmaProt DATE null,
	parentId LONG,
	link VARCHAR(75) null,
	stato INTEGER,
	tipoAllerta BOOLEAN,
	hash VARCHAR(75) null
);

create table ALLERTER_AllertaValangheStato (
	uuid_ VARCHAR(75) null,
	allertaValangheStatoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	dataInizio DATE null,
	dataFine DATE null,
	parentId LONG,
	allertaValangheId LONG,
	statoId LONG,
	eventoId LONG,
	areaId LONG
);

create table ALLERTER_Area (
	uuid_ VARCHAR(75) null,
	areaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	tipoArea VARCHAR(75) null,
	costiero BOOLEAN,
	dataInizio DATE null,
	dataFine DATE null,
	parentId LONG
);

create table ALLERTER_Email (
	id_ LONG not null primary key,
	tipo VARCHAR(75) null,
	sottotipo VARCHAR(75) null,
	param LONG,
	destinatario LONG,
	indirizzo VARCHAR(256) null,
	nomeDestinatario VARCHAR(200) null,
	stato LONG,
	dataInvio DATE null,
	testo TEXT null,
	oggetto TEXT null
);

create table ALLERTER_Feed (
	feedId VARCHAR(75) not null primary key,
	titolo VARCHAR(75) null,
	link VARCHAR(75) null,
	autore VARCHAR(75) null,
	query TEXT null
);

create table ALLERTER_Geografia (
	geografiaId VARCHAR(75) not null,
	tipo VARCHAR(75) not null,
	area VARCHAR(75) not null,
	complessita VARCHAR(75) not null,
	geometria TEXT null,
	primary key (geografiaId, tipo, area, complessita)
);

create table ALLERTER_LogInterno (
	logId LONG not null primary key,
	timestamp DATE null,
	thread VARCHAR(128) null,
	cosa VARCHAR(128) null,
	dettaglio VARCHAR(256) null,
	utente VARCHAR(75) null,
	risultato TEXT null,
	eccezione TEXT null
);

create table ALLERTER_SMS (
	id_ LONG not null primary key,
	tipo VARCHAR(75) null,
	sottotipo VARCHAR(75) null,
	param LONG,
	testo VARCHAR(160) null,
	destinatario LONG,
	numeroDa VARCHAR(75) null,
	numero VARCHAR(75) null,
	nomeDestinatario VARCHAR(75) null,
	stato LONG,
	dataInvio DATE null,
	dataAck DATE null,
	dataRicevuta DATE null,
	tentativi LONG,
	prossimoInvio DATE null,
	codiceErrore VARCHAR(75) null,
	descrizioneErrore VARCHAR(200) null,
	timestamp VARCHAR(75) null
);

create table ALLERTER_StatoAllertamento (
	uuid_ VARCHAR(75) null,
	statoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	dataInizio DATE null,
	dataFine DATE null,
	parentId LONG
);

create table ALLERTER_TipoEvento (
	uuid_ VARCHAR(75) null,
	eventoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	indice INTEGER,
	tabella INTEGER,
	split BOOLEAN,
	costiero BOOLEAN,
	dataInizio DATE null,
	dataFine DATE null,
	parentId LONG
);