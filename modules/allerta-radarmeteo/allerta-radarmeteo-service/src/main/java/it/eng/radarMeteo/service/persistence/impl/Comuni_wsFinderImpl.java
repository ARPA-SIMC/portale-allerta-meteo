package it.eng.radarMeteo.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import it.eng.radarMeteo.service.persistence.Comuni_wsFinder;

@Component(service = Comuni_wsFinder.class)
public class Comuni_wsFinderImpl extends Comuni_wsFinderBaseImpl implements Comuni_wsFinder{
	/*private String GET_Meteomont = Comuni_wsFinderImpl.class.getName() + ".getMeteomont";
	private String GET_StatoAllerta = Comuni_wsFinderImpl.class.getName() + ".getStatoAllerta";
	private String GET_StatoAllertaForCap = Comuni_wsFinderImpl.class.getName() + ".getAllertaForCap";
	private String GET_BollettinoMonitoraggio = Comuni_wsFinderImpl.class.getName() + 
			".getBollettinoMonitoraggio";*/
	
	private String GET_Meteomont = "SELECT * FROM meteomont_vw LIMIT 10 ";
	private String GET_StatoAllerta = "select '' || abs(y.areaid) as nome,y.dataemissione,y.datainizio,y.datafine,\r\n"
			+ "y.idraulica,y.idrogeologica,y.temporali,y.vento,y.temperature_estreme,\r\n"
			+ "y.neve,y.ghiaccio_pioggia_gela,y.stato_mare,y.mareggiate,y.titolo, y.descrizionemeteo, y.link, y.tendenza from (select x.areaid, a.dataemissione, a.datafine, a.parentid, a.datainizio,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=1) as idraulica,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=2) as idrogeologica,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=3) as temporali,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=4) as vento,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=5) as temperature_estreme,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=6) as neve,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=7) as ghiaccio_pioggia_gela,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=8) as stato_mare,\r\n"
			+ "(select case when statoid=1 then 'yellow' when statoid=2 then 'orange' when statoid=3 then 'red' when statoid=0 then 'green' else null end from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=9) as mareggiate,\r\n"
			+ "a.titolo, a.descrizionemeteo, a.link, case when not a.tipoallerta then '' when a.tendenza=1 \r\n"
			+ "then 'intensificazione' when a.tendenza=2 then 'stazionarieta' \r\n"
			+ "when a.tendenza=3 then 'attenuazione' else 'esaurimento' end as tendenza \r\n"
			+ "from allerter_allerta a left join \r\n"
			+ "(select distinct areaid from allerter_allertastato) x on 1=1 \r\n"
			+ "where a.stato = 0 and a.allertaid = (select allertaid from allerter_allerta a2 where a2.stato=0 \r\n"
			+ "and a2.datainizio <= ? and a2.datafine > ? order by a2.dataemissione desc limit 1 )\r\n"
			+ "order by x.areaid asc) y where (y.parentid=0 or (areaid<0 and date(?)=date(y.datainizio)) or\r\n"
			+ "(areaid>0 and date(?)<>date(y.datainizio))) and\r\n"
			+ "(idraulica is not null or idrogeologica is not null or temporali is not null or vento  is not null or \r\n"
			+ "temperature_estreme is not null or neve is not null or ghiaccio_pioggia_gela is not null or \r\n"
			+ " stato_mare is not null or mareggiate is not null)";
	private String GET_StatoAllertaForCap = "select * from (select x.areaid, a.dataemissione, a.datafine, a.parentid, a.datainizio,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=1) as idraulica,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=2) as idrogeologica,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=3) as temporali,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=4) as vento,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=5) as temperature_estreme,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=6) as neve,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=7) as ghiaccio_pioggia_gela,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=8) as stato_mare,\r\n"
			+ "(select statoid from allerter_allertastato aa where aa.allertaid=a.allertaid and aa.areaid=x.areaid and aa.eventoid=9) as mareggiate,\r\n"
			+ "a.numero,a.tipoallerta,a.titolo, a.descrizionemeteo, a.link, case when not a.tipoallerta then '' when a.tendenza=1 \r\n"
			+ "then 'intensificazione' when a.tendenza=2 then 'stazionarieta' \r\n"
			+ "when a.tendenza=3 then 'attenuazione' else 'esaurimento' end as tendenza \r\n"
			+ "from allerter_allerta a left join \r\n"
			+ "(select distinct areaid from allerter_allertastato) x on 1=1 \r\n"
			+ "where a.stato = 0 and a.allertaid = (select allertaid from allerter_allerta a2 where a2.stato=0 \r\n"
			+ "and a2.datainizio <= ? and a2.datafine > ? order by a2.dataemissione desc limit 1 )\r\n"
			+ "order by x.areaid asc) y where\r\n"
			+ "(idraulica is not null or idrogeologica is not null or temporali is not null or vento  is not null or \r\n"
			+ "temperature_estreme is not null or neve is not null or ghiaccio_pioggia_gela is not null or \r\n"
			+ " stato_mare is not null or mareggiate is not null)";
	private String GET_BollettinoMonitoraggio = "select b.numero,b.datainizio,b.datafine,b.notemeteo,bb.nomebacino,bs.nomestazione,bs.osservazione,bs.oreosservazione, b.link,bs.colmoprevisto,bs.oraprevista from \r\n"
			+ "(select * from bollettino_bollettino where stato = 0 order by dataemissione desc limit 10) b\r\n"
			+ "left join bollettino_bollettinosensore bs on bs.idbollettino = b.bollettinoid and bs.tendenza <> -100\r\n"
			+ "left join bollettino_bollettinobacino bb on bs.idbollettinobacino = bb.id_";

	public List<Object[]> getMeteomont() {
		Session session = openSession();

		String sql = GET_Meteomont;
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
//		QueryPos qPos = QueryPos.getInstance(query);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		
		return list;
	}
	
	public List<Object[]> getStatoAllerta(java.sql.Timestamp data) {
		Session session = openSession();
		String sql = GET_StatoAllerta;
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
		QueryPos qPos = QueryPos.getInstance(query);
		qPos.add(data);
		qPos.add(data);
		qPos.add(data);
		qPos.add(data);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}
	
	public List<Object[]> getStatoAllertaForCap(java.sql.Timestamp data) {
		Session session = openSession();
		String sql = GET_StatoAllertaForCap;
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
		QueryPos qPos = QueryPos.getInstance(query);
		qPos.add(data);
		qPos.add(data);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}
	
	public List<Object[]> getBollettinoMonitoraggio() {
		Session session = openSession();
		String sql = GET_BollettinoMonitoraggio;
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
//		QueryPos qPos = QueryPos.getInstance(query);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}

}
