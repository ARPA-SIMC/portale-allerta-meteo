create index IX_A53234BA on rubrica_RubricaContatto (DATA_CREAZIONE);
create index IX_B6C0F5FE on rubrica_RubricaContatto (DATA_MODIFICA);
create index IX_BDE1CCC5 on rubrica_RubricaContatto (FK_CANALE);
create index IX_986928F9 on rubrica_RubricaContatto (FK_NOMINATIVO);
create index IX_E1A2FC41 on rubrica_RubricaContatto (FK_UTENTE_CREAZIONE);
create index IX_7EE5A197 on rubrica_RubricaContatto (FK_UTENTE_MODIFICA);

create index IX_6E6252C9 on rubrica_RubricaGruppo (FK_SITO_PROPRIETARIO, FK_CATEGORIA);
create index IX_E9F78EDD on rubrica_RubricaGruppo (FK_SITO_PROPRIETARIO, ID_GRUPPO);
create index IX_33AC84F9 on rubrica_RubricaGruppo (FK_SITO_PROPRIETARIO, NOME[$COLUMN_LENGTH:75$], DISABLED);

create index IX_E6BEE555 on rubrica_RubricaGruppoGruppi (FK_GRUPPO_FIGLIO);

create index IX_582BCB1C on rubrica_RubricaGruppoNominativi (FK_NOMINATIVO);

create index IX_E4256F84 on rubrica_RubricaLog (FK_SITO_PROPRIETARIO, DATA_MODIFICA);
create index IX_12F35C32 on rubrica_RubricaLog (FK_SITO_PROPRIETARIO, ID_OGGETTO[$COLUMN_LENGTH:75$]);
create index IX_3A2D8818 on rubrica_RubricaLog (FK_SITO_PROPRIETARIO, TABELLA[$COLUMN_LENGTH:75$]);
create index IX_F3CE9AC9 on rubrica_RubricaLog (FK_UTENTE_MODIFICA);

create index IX_A75CBF9C on rubrica_RubricaNominativo (FK_SITO_PROPRIETARIO, COGNOME[$COLUMN_LENGTH:75$], NOME[$COLUMN_LENGTH:75$]);
create index IX_62D647FD on rubrica_RubricaNominativo (FK_SITO_PROPRIETARIO, ID_NOMINATIVO);
create index IX_827EBB63 on rubrica_RubricaNominativo (FK_UTENTE_CREAZIONE);
create index IX_BDE47635 on rubrica_RubricaNominativo (FK_UTENTE_MODIFICA);
create index IX_98FCA870 on rubrica_RubricaNominativo (FK_UTENTE_PORTALE);

create index IX_60C705C4 on rubrica_RubricaRuolo (FK_RUOLO_LIFERAY);

create index IX_AFA41CC2 on rubrica_RubricaSito (FK_LIFERAY_SITE);