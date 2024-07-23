package allerta.verifica.web.datacreator.filler;

import allerta.verifica.web.datacreator.QueryBasedColumnFiller;

public class SuperamentiIdroFiller extends QueryBasedColumnFiller{

	static String query = "select string_agg(to_char(x.createdate at time zone 'utc'  " + 
			"at time zone 'europe/rome','HH24:MI') || ' ' || x.name || ' ' || x.soglia, ', ') as risultato from (select v.createdate,v.name,v.soglia,v.livello,v.sogliaregola, " + 
			"st.namebasin,c.zona from  " + 
			"(select *, to_char(sogliaregola,'FM9999990.09') as sr2 from elenco_superamenti_vw  " + 
			"union " + 
			"select null as allarmeid, dataorainizio at time zone 'utc' at time zone 'europe/rome'  " + 
			" as createdate, dataorainizio at time zone 'utc' at time zone 'europe/rome' as datafine,  " + 
			" null as idregola, " + 
			"0 as colore, idvariabile, soglia, idstazione, nomestazione, 0 as soglia1, " + 
			"null as soglia2, null as soglia3, null as txt, to_char(dataorainizio at time zone 'utc'  " + 
			"at time zone 'europe/rome','HH24:MI') as oralocale, 'idro' as tipo, " + 
			"replace(to_char(valore,'FM9999990.09'),'.',',') || ' m' as livello, " + 
			"valoresoglia as sogliaregola, to_char(valoresoglia,'FM9999990.09') as sr2  " + 
			" from allerter_logsoglia) " + 
			"v join bollettino_stazione st on st.id_ = v.idstazione left join comune_translate c  " + 
			"on c.nome_db=st.namemunicipality  " + 
			"where tipo='idro' and zona=%ZONA% and v.soglia>1 " + 
			"and (v.createdate at time zone 'utc' at time zone 'europe/rome'>=%GIORNO%)	 " + 
			"and cast((v.createdate at time zone 'utc' at time zone 'europe/rome') as date)= " + 
			"cast(%GIORNO% as date) " + 
			"order by v.createdate asc)x";
	
	
	public SuperamentiIdroFiller() {
		super(query);
	}
	
	

}
