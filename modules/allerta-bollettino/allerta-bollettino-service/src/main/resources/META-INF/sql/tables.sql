create table BOLLETTINO_Allarme (
	uuid_ VARCHAR(75) null,
	allarmeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stato INTEGER,
	idApprovatore LONG,
	dataApprovazione DATE null,
	idRegola LONG,
	colore INTEGER,
	dataInizio DATE null,
	dataFine DATE null
);

create table BOLLETTINO_AttivazioneFiume (
	fiumeId VARCHAR(75) not null primary key,
	attivo BOOLEAN
);

create table BOLLETTINO_Bacino (
	uuid_ VARCHAR(75) null,
	id_ VARCHAR(75) not null primary key,
	nome VARCHAR(75) null,
	progressivo INTEGER
);

create table BOLLETTINO_Bollettino (
	uuid_ VARCHAR(75) null,
	bollettinoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stato INTEGER,
	idApprovatore LONG,
	dataApprovazione DATE null,
	numero VARCHAR(75) null,
	progressivo INTEGER,
	anno INTEGER,
	dataEmissione DATE null,
	dataInizio DATE null,
	dataFine DATE null,
	noteMeteo TEXT null,
	stringaMeteo TEXT null,
	link VARCHAR(256) null,
	ultimo BOOLEAN,
	hash VARCHAR(75) null
);

create table BOLLETTINO_BollettinoBacino (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idBollettino LONG,
	progressivo INTEGER,
	idBacino VARCHAR(75) null,
	nomeBacino VARCHAR(75) null,
	oreOsservazione VARCHAR(75) null,
	note TEXT null
);

create table BOLLETTINO_BollettinoIcona (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idBollettino LONG,
	idIcona LONG,
	x DOUBLE,
	y DOUBLE
);

create table BOLLETTINO_BollettinoParametro (
	parametroId VARCHAR(75) not null primary key,
	valore TEXT null
);

create table BOLLETTINO_BollettinoSensore (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idBollettino LONG,
	idStazione LONG,
	idBollettinoBacino LONG,
	progressivo INTEGER,
	nomeStazione VARCHAR(75) null,
	oreOsservazione VARCHAR(75) null,
	osservazione DOUBLE,
	tendenza INTEGER,
	colmoPrevisto VARCHAR(75) null,
	oraPrevista VARCHAR(75) null,
	soglia1 DOUBLE,
	soglia2 DOUBLE,
	soglia3 DOUBLE,
	giornoPrevisto VARCHAR(75) null,
	osservato BOOLEAN
);

create table BOLLETTINO_Icona (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	path_ VARCHAR(75) null,
	descrizione VARCHAR(75) null
);

create table BOLLETTINO_Idrometro (
	stazioneId VARCHAR(75) not null primary key,
	nomeBacino VARCHAR(75) null,
	nomeSottobacino VARCHAR(75) null,
	nomeRubrica VARCHAR(75) null,
	sogliaSpike DOUBLE
);

create table BOLLETTINO_Img (
	id_ LONG not null primary key,
	daypart VARCHAR(75) null,
	day VARCHAR(75) null,
	provincia VARCHAR(75) null,
	inserted DATE null,
	data_ VARCHAR(75) null
);

create table BOLLETTINO_Pluviometro (
	stazioneId VARCHAR(75) not null primary key,
	nomeGruppo VARCHAR(75) null,
	nomeRubrica VARCHAR(75) null
);

create table BOLLETTINO_RegolaAllarme (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	espressione VARCHAR(1024) null,
	descrizione VARCHAR(75) null,
	colore INTEGER,
	attivo BOOLEAN
);

create table BOLLETTINO_RegolaAllarmeComune (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idRegola LONG,
	idComune LONG
);

create table BOLLETTINO_RegolaAllarmeCondizione (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idRegola LONG,
	lettera VARCHAR(75) null,
	idVariabile VARCHAR(75) null,
	idStazione VARCHAR(75) null,
	idStazioneVariabile LONG,
	soglia INTEGER,
	valoreSoglia DOUBLE
);

create table BOLLETTINO_Stazione (
	uuid_ VARCHAR(75) null,
	id_ VARCHAR(75) not null primary key,
	ident VARCHAR(75) null,
	name VARCHAR(75) null,
	lon LONG,
	lat LONG,
	height DOUBLE,
	idBasin VARCHAR(75) null,
	idSubbasin VARCHAR(75) null,
	idCountry VARCHAR(75) null,
	idProvince VARCHAR(75) null,
	idRegion VARCHAR(75) null,
	idMunicipality VARCHAR(75) null,
	idMacroarea VARCHAR(75) null,
	nameBasin VARCHAR(75) null,
	nameSubbasin VARCHAR(75) null,
	nameCountry VARCHAR(75) null,
	nameProvince VARCHAR(75) null,
	nameRegion VARCHAR(75) null,
	nameMunicipality VARCHAR(75) null,
	nameMacroarea VARCHAR(75) null,
	network VARCHAR(75) null,
	attivo BOOLEAN,
	incluso BOOLEAN,
	progressivo INTEGER
);

create table BOLLETTINO_StazioneVariabile (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	idStazione VARCHAR(75) null,
	idVariabile VARCHAR(75) null,
	dataUltimoValore DATE null,
	soglia1 DOUBLE,
	soglia2 DOUBLE,
	soglia3 DOUBLE
);

create table BOLLETTINO_ValoreSensore (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	value DOUBLE,
	datetime DATE null,
	idVariabile VARCHAR(75) null,
	idStazione VARCHAR(75) null
);

create table BOLLETTINO_Variabile (
	uuid_ VARCHAR(75) null,
	id_ VARCHAR(75) not null primary key,
	description_it TEXT null,
	level_t1 INTEGER,
	level_t2 INTEGER,
	level_v1 INTEGER,
	level_v2 INTEGER,
	trange_p1 INTEGER,
	trange_p2 INTEGER,
	trange_pind INTEGER,
	unit VARCHAR(75) null,
	bcode VARCHAR(75) null
);