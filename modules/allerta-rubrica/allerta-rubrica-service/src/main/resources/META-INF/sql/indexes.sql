create index IX_A53234BA on rubrica_RubricaContatto (DATA_CREAZIONE);
create index IX_B6C0F5FE on rubrica_RubricaContatto (DATA_MODIFICA);
create index IX_BDE1CCC5 on rubrica_RubricaContatto (FK_CANALE);
create index IX_986928F9 on rubrica_RubricaContatto (FK_NOMINATIVO);
create index IX_E1A2FC41 on rubrica_RubricaContatto (FK_UTENTE_CREAZIONE);
create index IX_7EE5A197 on rubrica_RubricaContatto (FK_UTENTE_MODIFICA);

create index IX_D1C58909 on rubrica_RubricaGruppo (FK_CATEGORIA, FK_SITO_PROPRIETARIO);
create index IX_33AC84F9 on rubrica_RubricaGruppo (FK_SITO_PROPRIETARIO, NOME[$COLUMN_LENGTH:512$], DISABLED);
create index IX_A0657AAD on rubrica_RubricaGruppo (ID_GRUPPO, FK_SITO_PROPRIETARIO);

create index IX_E6BEE555 on rubrica_RubricaGruppoGruppi (FK_GRUPPO_FIGLIO);

create index IX_582BCB1C on rubrica_RubricaGruppoNominativi (FK_NOMINATIVO);

create index IX_6CCCD054 on rubrica_RubricaLog (DATA_MODIFICA, FK_SITO_PROPRIETARIO);
create index IX_18B19E49 on rubrica_RubricaLog (FK_SITO_PROPRIETARIO);
create index IX_F3CE9AC9 on rubrica_RubricaLog (FK_UTENTE_MODIFICA);
create index IX_D4126372 on rubrica_RubricaLog (ID_OGGETTO[$COLUMN_LENGTH:75$], FK_SITO_PROPRIETARIO);
create index IX_B48A27E8 on rubrica_RubricaLog (TABELLA[$COLUMN_LENGTH:75$], FK_SITO_PROPRIETARIO);

create index IX_F7DA056C on rubrica_RubricaNominativo (COGNOME[$COLUMN_LENGTH:128$], NOME[$COLUMN_LENGTH:128$], FK_SITO_PROPRIETARIO);
create index IX_827EBB63 on rubrica_RubricaNominativo (FK_UTENTE_CREAZIONE);
create index IX_BDE47635 on rubrica_RubricaNominativo (FK_UTENTE_MODIFICA);
create index IX_98FCA870 on rubrica_RubricaNominativo (FK_UTENTE_PORTALE);
create index IX_58C89F0D on rubrica_RubricaNominativo (ID_NOMINATIVO, FK_SITO_PROPRIETARIO);

create index IX_60C705C4 on rubrica_RubricaRuolo (FK_RUOLO_LIFERAY);

create index IX_AFA41CC2 on rubrica_RubricaSito (FK_LIFERAY_SITE);