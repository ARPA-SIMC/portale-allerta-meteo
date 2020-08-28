create table prev_meteo_Bollettino (
	id_ LONG not null primary key,
	tipo VARCHAR(75) null,
	timestamp LONG,
	emissione VARCHAR(75) null,
	validita VARCHAR(75) null,
	xml_content TEXT null,
	json TEXT null
);

create table prev_meteo_Img (
	id_ LONG not null primary key,
	daypart VARCHAR(75) null,
	day VARCHAR(75) null,
	provincia VARCHAR(75) null,
	inserted DATE null,
	data_ TEXT null
);

create table prev_meteo_Storico (
	id_ LONG not null primary key,
	idZona INTEGER,
	nome VARCHAR(75) null,
	sigla VARCHAR(75) null,
	tipo VARCHAR(75) null,
	xml TEXT null
);