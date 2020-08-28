create index IX_B8FBF85 on ALLERTER_Allerta (numero[$COLUMN_LENGTH:75$]);
create index IX_BCD0DEA9 on ALLERTER_Allerta (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3322FB6B on ALLERTER_Allerta (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_32D29BB4 on ALLERTER_AllertaStato (allertaId);
create index IX_9699A9FF on ALLERTER_AllertaStato (nome[$COLUMN_LENGTH:75$]);
create index IX_73BA5826 on ALLERTER_AllertaStato (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1C26B028 on ALLERTER_AllertaStato (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C1D9F52C on ALLERTER_Area (nome[$COLUMN_LENGTH:75$]);
create index IX_612E1974 on ALLERTER_Area (tipoArea[$COLUMN_LENGTH:75$]);
create index IX_EEA47D3 on ALLERTER_Area (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_63F8A715 on ALLERTER_Area (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F37D905B on ALLERTER_Email (destinatario);
create index IX_E29ECC88 on ALLERTER_Email (indirizzo[$COLUMN_LENGTH:256$]);
create index IX_1E68BD3F on ALLERTER_Email (tipo[$COLUMN_LENGTH:75$], param);
create index IX_E0608FE4 on ALLERTER_Email (tipo[$COLUMN_LENGTH:75$], sottotipo[$COLUMN_LENGTH:75$], param);

create index IX_370FFC2A on ALLERTER_Geografia (area[$COLUMN_LENGTH:75$], complessita[$COLUMN_LENGTH:75$]);
create index IX_27D8A82D on ALLERTER_Geografia (geografiaId[$COLUMN_LENGTH:75$], complessita[$COLUMN_LENGTH:75$]);
create index IX_6C8BA342 on ALLERTER_Geografia (tipo[$COLUMN_LENGTH:75$], area[$COLUMN_LENGTH:75$], complessita[$COLUMN_LENGTH:75$]);
create index IX_5EDAF6A3 on ALLERTER_Geografia (tipo[$COLUMN_LENGTH:75$], complessita[$COLUMN_LENGTH:75$]);

create index IX_22E5118 on ALLERTER_SMS (destinatario);
create index IX_29A6F2EC on ALLERTER_SMS (numero[$COLUMN_LENGTH:75$], dataAck);
create index IX_C6401293 on ALLERTER_SMS (timestamp[$COLUMN_LENGTH:75$]);
create index IX_506E70E2 on ALLERTER_SMS (tipo[$COLUMN_LENGTH:75$], param);
create index IX_C5F94861 on ALLERTER_SMS (tipo[$COLUMN_LENGTH:75$], sottotipo[$COLUMN_LENGTH:75$], param);

create index IX_E1E9DFF8 on ALLERTER_StatoAllertamento (nome[$COLUMN_LENGTH:75$]);
create index IX_64D4609F on ALLERTER_StatoAllertamento (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AEEA82E1 on ALLERTER_StatoAllertamento (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_23081908 on ALLERTER_TipoEvento (nome[$COLUMN_LENGTH:75$]);
create index IX_34866246 on ALLERTER_TipoEvento (tabella);
create index IX_FD9581AF on ALLERTER_TipoEvento (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DCA0A7F1 on ALLERTER_TipoEvento (uuid_[$COLUMN_LENGTH:75$], groupId);