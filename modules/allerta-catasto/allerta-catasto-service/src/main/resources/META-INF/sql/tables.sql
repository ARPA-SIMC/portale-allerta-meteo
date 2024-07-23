create table CATASTO_Categoria (
	id_ LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table CATASTO_Effetti (
	id_ LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table CATASTO_EffettiSub (
	id_ LONG not null,
	idEffetti LONG not null,
	descrizione VARCHAR(75) null,
	primary key (id_, idEffetti)
);

create table CATASTO_Fonte (
	id_ LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table CATASTO_Segnalazione (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	documentoAssociato LONG,
	dataEvento DATE null,
	enteSegnalante VARCHAR(75) null,
	fonte LONG,
	categoria LONG,
	sottocategoria LONG,
	riferimento VARCHAR(75) null,
	descrizione VARCHAR(75) null,
	note VARCHAR(75) null,
	area VARCHAR(75) null,
	provincia VARCHAR(75) null,
	comune VARCHAR(75) null,
	indirizzo VARCHAR(75) null,
	civico VARCHAR(75) null,
	lat DOUBLE,
	lon DOUBLE,
	effetti LONG,
	effettiSub LONG
);

create table CATASTO_Sottocategoria (
	id_ LONG not null,
	idCategoria LONG not null,
	descrizione VARCHAR(75) null,
	primary key (id_, idCategoria)
);