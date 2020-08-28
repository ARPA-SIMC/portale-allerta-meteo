create index IX_463905AD on rt_portlet_Comuni_bacini_ws (bacino[$COLUMN_LENGTH:75$]);

create index IX_3675057B on rt_portlet_Comuni_ws (sottozona[$COLUMN_LENGTH:75$]);
create index IX_DD049013 on rt_portlet_Comuni_ws (zonaallerta[$COLUMN_LENGTH:75$]);

create index IX_203563FF on rt_portlet_Img (timestamp);

create index IX_6A15D785 on rt_portlet_Json (type_[$COLUMN_LENGTH:75$]);

create index IX_8163698D on rt_portlet_comuni_bacini_ws (bacino[$COLUMN_LENGTH:75$]);

create index IX_72C595B on rt_portlet_comuni_ws (sottozona[$COLUMN_LENGTH:2$]);
create index IX_5D366BF3 on rt_portlet_comuni_ws (zonaallerta[$COLUMN_LENGTH:1$]);

create index IX_52711FDF on rt_portlet_img (timestamp);

create index IX_3A76A7A5 on rt_portlet_json (type_[$COLUMN_LENGTH:75$]);