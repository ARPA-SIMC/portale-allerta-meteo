create table VERIFICA_UtenteLavoro (
	id_ LONG not null primary key,
	documento LONG,
	utente VARCHAR(75) null,
	ts DATE null,
	attivita VARCHAR(75) null
);

create table VERIFICA_Verifica (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	documento LONG,
	stato INTEGER,
	titolo VARCHAR(75) null,
	fenomeni VARCHAR(75) null,
	fenomeniDescritti VARCHAR(75) null,
	note VARCHAR(75) null,
	dataInizio DATE null,
	dataFine DATE null,
	link VARCHAR(75) null,
	hash VARCHAR(75) null
);

create table VERIFICA_VerificaDato (
	id_ LONG not null primary key,
	documento LONG,
	giorno DATE null,
	zona VARCHAR(75) null,
	evento LONG,
	nomeDato VARCHAR(75) null,
	progressivo INTEGER,
	datoInserito VARCHAR(75) null,
	datoCalcolato VARCHAR(75) null
);