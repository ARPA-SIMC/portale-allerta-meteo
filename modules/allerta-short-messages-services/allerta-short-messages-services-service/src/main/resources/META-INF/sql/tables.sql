create table smsService_Auth (
	key_ VARCHAR(75) not null primary key,
	value VARCHAR(75) null
);

create table smsService_CounterSms (
	counterId LONG not null primary key,
	date_ DATE null,
	numerosms INTEGER,
	nodo VARCHAR(75) null
);

create table smsService_Nodo (
	Id LONG not null primary key,
	ip VARCHAR(75) null,
	porta INTEGER,
	nodoConnesso VARCHAR(75) null,
	dataConnessione DATE null
);

create table smsService_Parametro (
	Id LONG not null primary key,
	ip VARCHAR(75) null,
	porta INTEGER,
	username VARCHAR(75) null,
	password_ VARCHAR(75) null,
	mittente VARCHAR(75) null,
	nodo VARCHAR(75) null,
	dataConnessione DATE null
);

create table smsService_SmsSchedulerContext (
	varId VARCHAR(75) not null primary key,
	value VARCHAR(75) null
);