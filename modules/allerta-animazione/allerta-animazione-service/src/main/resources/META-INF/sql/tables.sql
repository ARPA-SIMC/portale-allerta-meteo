create table img_animazioni_Parametro (
	key_ VARCHAR(75) not null primary key,
	value VARCHAR(75) null
);

create table img_animazioni_PioggiaCumulativa (
	id_ LONG not null primary key,
	nome VARCHAR(300) null,
	cumulazione VARCHAR(75) null,
	inzioCumulazione DATE null,
	fineCumulazione DATE null,
	imgData TEXT null
);

create table img_animazioni_altezzaOnda (
	id_ LONG not null primary key,
	im VARCHAR(75) null,
	text_LOC VARCHAR(75) null,
	timestamp LONG,
	imgData TEXT null
);