create index IX_1BC60342 on BOLLETTINO_Allarme (idRegola);
create unique index IX_D6787039 on BOLLETTINO_Allarme (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6DDE631B on BOLLETTINO_Bacino (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4DCC9A15 on BOLLETTINO_Bollettino (numero[$COLUMN_LENGTH:75$]);
create unique index IX_266445FB on BOLLETTINO_Bollettino (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C24CF32C on BOLLETTINO_BollettinoBacino (idBollettino);
create index IX_ED17B009 on BOLLETTINO_BollettinoBacino (uuid_[$COLUMN_LENGTH:75$]);

create index IX_EE7D1230 on BOLLETTINO_BollettinoIcona (idBollettino);
create index IX_6E12AD85 on BOLLETTINO_BollettinoIcona (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A6D910D3 on BOLLETTINO_BollettinoSensore (idBollettino);
create index IX_EFB29042 on BOLLETTINO_BollettinoSensore (uuid_[$COLUMN_LENGTH:75$]);

create index IX_8B005033 on BOLLETTINO_Icona (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6B5A88AD on BOLLETTINO_Idrometro (nomeBacino[$COLUMN_LENGTH:75$]);
create index IX_3BFF4711 on BOLLETTINO_Idrometro (nomeRubrica[$COLUMN_LENGTH:75$]);
create index IX_A66251B6 on BOLLETTINO_Idrometro (nomeSottobacino[$COLUMN_LENGTH:75$]);

create index IX_CCEF2B41 on BOLLETTINO_Pluviometro (nomeGruppo[$COLUMN_LENGTH:75$]);
create index IX_7D768B3C on BOLLETTINO_Pluviometro (nomeRubrica[$COLUMN_LENGTH:75$]);

create index IX_FCD05628 on BOLLETTINO_RegolaAllarme (attivo);
create index IX_A71A8B01 on BOLLETTINO_RegolaAllarme (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4BEAFF78 on BOLLETTINO_RegolaAllarmeComune (idComune);
create index IX_468BB77D on BOLLETTINO_RegolaAllarmeComune (idRegola);
create index IX_DDE62536 on BOLLETTINO_RegolaAllarmeComune (uuid_[$COLUMN_LENGTH:75$]);

create index IX_172E562 on BOLLETTINO_RegolaAllarmeCondizione (idRegola);
create index IX_E1D74971 on BOLLETTINO_RegolaAllarmeCondizione (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C5B8FABA on BOLLETTINO_Stazione (idBasin[$COLUMN_LENGTH:75$], attivo, incluso);
create index IX_4476A289 on BOLLETTINO_Stazione (name[$COLUMN_LENGTH:75$]);
create index IX_DE92302A on BOLLETTINO_Stazione (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E8EF8E47 on BOLLETTINO_StazioneVariabile (idStazione[$COLUMN_LENGTH:75$]);
create index IX_7311013 on BOLLETTINO_StazioneVariabile (idVariabile[$COLUMN_LENGTH:75$]);
create index IX_FC00D9B3 on BOLLETTINO_StazioneVariabile (uuid_[$COLUMN_LENGTH:75$]);

create index IX_BA0BD137 on BOLLETTINO_ValoreSensore (idVariabile[$COLUMN_LENGTH:75$], idStazione[$COLUMN_LENGTH:75$]);
create index IX_B49FDBF1 on BOLLETTINO_ValoreSensore (uuid_[$COLUMN_LENGTH:75$]);

create index IX_13CFE79C on BOLLETTINO_Variabile (uuid_[$COLUMN_LENGTH:75$]);