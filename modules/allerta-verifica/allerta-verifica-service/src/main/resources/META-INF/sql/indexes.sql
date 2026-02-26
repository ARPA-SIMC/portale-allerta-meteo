create index IX_20221D82 on VERIFICA_UtenteLavoro (documento);

create index IX_B51D06DF on VERIFICA_Verifica (documento);
create unique index IX_C853C0DB on VERIFICA_Verifica (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_92B3987 on VERIFICA_VerificaDato (documento);
create index IX_F192BFD6 on VERIFICA_VerificaDato (giorno, documento, evento);
create index IX_78A92BB2 on VERIFICA_VerificaDato (giorno, documento, zona[$COLUMN_LENGTH:75$], evento);
create index IX_D85D3FC0 on VERIFICA_VerificaDato (giorno, evento);
create index IX_31CA941C on VERIFICA_VerificaDato (giorno, zona[$COLUMN_LENGTH:75$], evento);