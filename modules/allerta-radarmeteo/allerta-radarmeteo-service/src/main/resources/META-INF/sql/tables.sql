create table rt_portlet_Comuni_bacini_ws (
	idBacini INTEGER not null primary key,
	comune VARCHAR(75) null,
	provincia VARCHAR(75) null,
	bacino VARCHAR(75) null
);

create table rt_portlet_Comuni_ws (
	idIstat VARCHAR(75) not null primary key,
	comune VARCHAR(75) null,
	provincia VARCHAR(75) null,
	sottozona VARCHAR(75) null,
	zonaallerta VARCHAR(75) null
);

create table rt_portlet_Img (
	id_ LONG not null primary key,
	coord VARCHAR(75) null,
	palette VARCHAR(75) null,
	timestamp LONG,
	data_ VARCHAR(75) null
);

create table rt_portlet_Json (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	inserted LONG,
	data_ VARCHAR(75) null
);

create table rt_portlet_comuni_bacini_ws (
	idBacini INTEGER not null primary key,
	comune VARCHAR(75) null,
	provincia VARCHAR(2) null,
	bacino VARCHAR(75) null
);

create table rt_portlet_comuni_ws (
	idIstat VARCHAR(10) not null primary key,
	comune VARCHAR(50) null,
	provincia VARCHAR(2) null,
	sottozona VARCHAR(2) null,
	zonaallerta VARCHAR(1) null
);

create table rt_portlet_img (
	id_ LONG not null primary key,
	coord VARCHAR(75) null,
	palette VARCHAR(75) null,
	timestamp LONG,
	data_ TEXT null
);

create table rt_portlet_json (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	inserted LONG,
	data_ TEXT null
);