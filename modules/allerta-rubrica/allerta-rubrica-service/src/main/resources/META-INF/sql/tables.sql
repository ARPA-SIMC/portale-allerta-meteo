create table rubrica_RubricaCanale (
	ID_CANALE LONG not null primary key,
	NOME VARCHAR(75) null,
	ICONA VARCHAR(75) null,
	REGEX VARCHAR(75) null
);

create table rubrica_RubricaContatto (
	ID_CONTATTO LONG not null primary key,
	FK_NOMINATIVO LONG,
	FK_CANALE LONG,
	CONTATTO VARCHAR(128) null,
	ALLERTAMENTO BOOLEAN,
	FK_UTENTE_CREAZIONE LONG,
	DATA_CREAZIONE DATE null,
	FK_UTENTE_MODIFICA LONG,
	DATA_MODIFICA DATE null,
	DATA_FINE_VALIDITA DATE null,
	MODIFICA_MINORE BOOLEAN
);

create table rubrica_RubricaGruppo (
	ID_GRUPPO LONG not null primary key,
	NOME VARCHAR(512) null,
	FK_SITO_PROPRIETARIO LONG,
	NOTE VARCHAR(2048) null,
	FK_UTENTE_CREAZIONE LONG,
	DATA_CREAZIONE DATE null,
	FK_UTENTE_MODIFICA LONG,
	DATA_MODIFICA DATE null,
	DISABLED BOOLEAN
);

create table rubrica_RubricaGruppoGruppi (
	FK_GRUPPO_PADRE LONG not null,
	FK_GRUPPO_FIGLIO LONG not null,
	primary key (FK_GRUPPO_PADRE, FK_GRUPPO_FIGLIO)
);

create table rubrica_RubricaGruppoNominativi (
	FK_GRUPPO LONG not null,
	FK_NOMINATIVO LONG not null,
	FK_RUOLO LONG,
	SPECIFICA_RUOLO VARCHAR(75) null,
	primary key (FK_GRUPPO, FK_NOMINATIVO)
);

create table rubrica_RubricaLog (
	ID_LOG LONG not null primary key,
	FK_SITO_PROPRIETARIO LONG,
	TABELLA VARCHAR(75) null,
	TIPO_OPERAZIONE VARCHAR(75) null,
	ID_OGGETTO VARCHAR(75) null,
	NUOVA_DESCRIZIONE TEXT null,
	FK_UTENTE_MODIFICA LONG,
	DATA_MODIFICA DATE null
);

create table rubrica_RubricaNominativo (
	ID_NOMINATIVO LONG not null primary key,
	COGNOME VARCHAR(128) null,
	NOME VARCHAR(128) null,
	INDIRIZZO VARCHAR(256) null,
	FK_SITO_PROPRIETARIO LONG,
	FK_UTENTE_PORTALE LONG,
	FK_UTENTE_CREAZIONE LONG,
	DATA_CREAZIONE DATE null,
	FK_UTENTE_MODIFICA LONG,
	DATA_MODIFICA DATE null,
	DISABLED BOOLEAN,
	MODIFICA_MINORE BOOLEAN
);

create table rubrica_RubricaPermessi (
	ID_PERMESSO VARCHAR(75) not null primary key,
	NOME_PERMESSO VARCHAR(75) null
);

create table rubrica_RubricaRuolo (
	ID_RUOLO LONG not null primary key,
	DESCRIZIONE VARCHAR(256) null,
	FK_RUOLO_LIFERAY LONG
);

create table rubrica_RubricaRuoloPermessi (
	FK_ID_RUOLO LONG not null,
	FK_ID_PERMESSO VARCHAR(75) not null,
	primary key (FK_ID_RUOLO, FK_ID_PERMESSO)
);

create table rubrica_RubricaRuoloRubrica (
	ID_RUOLO LONG not null primary key,
	DESCRIZIONE VARCHAR(75) null
);

create table rubrica_RubricaSito (
	ID_SITO LONG not null primary key,
	NOME VARCHAR(128) null,
	FK_LIFERAY_SITE LONG
);

create table rubrica_RubricaUtenteSito (
	ID_UTENTE LONG not null primary key,
	ID_SITO LONG
);