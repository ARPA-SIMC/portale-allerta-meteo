create index IX_20221D82 on VERIFICA_UtenteLavoro (documento);

create index IX_B51D06DF on VERIFICA_Verifica (documento);
create index IX_C8E60819 on VERIFICA_Verifica (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C853C0DB on VERIFICA_Verifica (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B06A898A on VERIFICA_VerificaDato (documento, giorno, evento);
create index IX_70A7DE66 on VERIFICA_VerificaDato (documento, giorno, zona[$COLUMN_LENGTH:75$], evento);
create index IX_D85D3FC0 on VERIFICA_VerificaDato (giorno, evento);
create index IX_31CA941C on VERIFICA_VerificaDato (giorno, zona[$COLUMN_LENGTH:75$], evento);