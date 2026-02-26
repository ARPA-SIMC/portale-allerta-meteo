create index IX_DA826265 on prev_meteo_Bollettino (tipo[$COLUMN_LENGTH:75$]);

create index IX_BF07CE2A on prev_meteo_Img (day[$COLUMN_LENGTH:75$], provincia[$COLUMN_LENGTH:75$], daypart[$COLUMN_LENGTH:75$]);

create index IX_2922A704 on prev_meteo_Storico (sigla[$COLUMN_LENGTH:75$]);