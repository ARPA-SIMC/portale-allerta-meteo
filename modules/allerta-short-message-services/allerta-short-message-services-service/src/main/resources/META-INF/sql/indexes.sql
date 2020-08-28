create index IX_5B1C063B on smsService_CounterSms (date_, nodo[$COLUMN_LENGTH:75$]);

create index IX_B7FEE6D0 on smsService_Nodo (ip[$COLUMN_LENGTH:75$]);
create index IX_8D97650B on smsService_Nodo (nodoConnesso[$COLUMN_LENGTH:75$]);

create index IX_FBD35FFC on smsService_Parametro (nodo[$COLUMN_LENGTH:75$]);