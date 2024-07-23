package allerta.verifica.web.datacreator.filler;

import allerta.verifica.web.datacreator.QueryBasedColumnFiller;

public class DewetraHRWFiller extends QueryBasedColumnFiller{

	static String query = /*"select string_agg(to_char(x.timestamp at time zone 'utc' at time zone 'europe/rome','HH24:MI') || ' ' || x.comune,', ') as risultato from (select * from dewetra_hrw d join storico_aree c on c.nome = upper(d.comune) and c.data_inizio<=current_timestamp and c.data_fine>=current_timestamp where " + 
			"d.timestamp at time zone 'utc' at time zone 'europe/rome'>=%GIORNO% " + 
			"and cast((d.timestamp at time zone 'utc' at time zone 'europe/rome') as date)=cast(%GIORNO% as date) and c.area=%ZONA% order by d.timestamp asc) x";
	*/
	"select txt from dewetra3_vw where allertaid=%ALLERTA% and dt=%GIORNO% and area=%ZONA%";
	public DewetraHRWFiller() {
		super(query);
	}
	
	

}
