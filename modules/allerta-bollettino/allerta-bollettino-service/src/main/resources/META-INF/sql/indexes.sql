create index IX_1BC60342 on BOLLETTINO_Allarme (idRegola);
create index IX_E09C57F7 on BOLLETTINO_Allarme (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D6787039 on BOLLETTINO_Allarme (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6DDE631B on BOLLETTINO_Bacino (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4DCC9A15 on BOLLETTINO_Bollettino (numero[$COLUMN_LENGTH:75$]);
create index IX_E4E9C539 on BOLLETTINO_Bollettino (uuid_[$COLUMN_LENGTH:75$], companyId);
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

create index IX_343676ED on BOLLETTINO_Img (day[$COLUMN_LENGTH:75$], provincia[$COLUMN_LENGTH:75$]);
create index IX_692FF34 on BOLLETTINO_Img (daypart[$COLUMN_LENGTH:75$], day[$COLUMN_LENGTH:75$], provincia[$COLUMN_LENGTH:75$]);

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

create index IX_8B0A1742 on bollettino_Allarme (idRegola);
create index IX_248C6BF7 on bollettino_Allarme (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BF5D8439 on bollettino_Allarme (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_AA4C771B on bollettino_Bacino (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C70B0615 on bollettino_Bollettino (numero[$COLUMN_LENGTH:75$]);
create index IX_E4113139 on bollettino_Bollettino (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6076B1FB on bollettino_Bollettino (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_95495F2C on bollettino_BollettinoBacino (idBollettino);
create index IX_D5FCC409 on bollettino_BollettinoBacino (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D4432630 on bollettino_BollettinoIcona (idBollettino);
create index IX_A3B1985 on bollettino_BollettinoIcona (uuid_[$COLUMN_LENGTH:75$]);

create index IX_336A24D3 on bollettino_BollettinoSensore (idBollettino);
create index IX_236FFC42 on bollettino_BollettinoSensore (uuid_[$COLUMN_LENGTH:75$]);

create index IX_BE7FBC33 on bollettino_Icona (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B2749CAD on bollettino_Idrometro (nomeBacino[$COLUMN_LENGTH:75$]);
create index IX_D827B311 on bollettino_Idrometro (nomeRubrica[$COLUMN_LENGTH:75$]);
create index IX_E074BDB6 on bollettino_Idrometro (nomeSottobacino[$COLUMN_LENGTH:75$]);

create index IX_B5D43F41 on bollettino_Pluviometro (nomeGruppo[$COLUMN_LENGTH:75$]);
create index IX_B133F73C on bollettino_Pluviometro (nomeRubrica[$COLUMN_LENGTH:75$]);

create index IX_43EA6A28 on bollettino_RegolaAllarme (attivo);
create index IX_CA6DF701 on bollettino_RegolaAllarme (uuid_[$COLUMN_LENGTH:75$]);

create index IX_31B11378 on bollettino_RegolaAllarmeComune (idComune);
create index IX_2C51CB7D on bollettino_RegolaAllarmeComune (idRegola);
create index IX_17F89136 on bollettino_RegolaAllarmeComune (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AE0EF962 on bollettino_RegolaAllarmeCondizione (idRegola);
create index IX_B4D3B571 on bollettino_RegolaAllarmeCondizione (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AC9F66BA on bollettino_Stazione (idBasin[$COLUMN_LENGTH:75$], attivo, incluso);
create index IX_95CB0E89 on bollettino_Stazione (name[$COLUMN_LENGTH:75$]);
create index IX_B7CB442A on bollettino_Stazione (uuid_[$COLUMN_LENGTH:75$]);

create index IX_CEB5A247 on bollettino_StazioneVariabile (idStazione[$COLUMN_LENGTH:75$]);
create index IX_DA2D7C13 on bollettino_StazioneVariabile (idVariabile[$COLUMN_LENGTH:75$]);
create index IX_2FBE45B3 on bollettino_StazioneVariabile (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AFDC3D37 on bollettino_ValoreSensore (idVariabile[$COLUMN_LENGTH:75$], idStazione[$COLUMN_LENGTH:75$]);
create index IX_D7F347F1 on bollettino_ValoreSensore (uuid_[$COLUMN_LENGTH:75$]);

create index IX_61B9539C on bollettino_Variabile (uuid_[$COLUMN_LENGTH:75$]);