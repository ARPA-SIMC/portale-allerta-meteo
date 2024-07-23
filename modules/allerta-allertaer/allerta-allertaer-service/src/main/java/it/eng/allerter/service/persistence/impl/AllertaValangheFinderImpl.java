package it.eng.allerter.service.persistence.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.model.impl.AllertaValangheImpl;
import it.eng.allerter.service.persistence.AllertaValangheFinder;

public class AllertaValangheFinderImpl extends AllertaValangheFinderBaseImpl implements AllertaValangheFinder {
	
	private static final String FIND_ALL_ALLERTAVALANGHE_ORDERED = AllertaValangheFinder.class.getName() + ".getAllertaValanghesOrdered";
	
	public List<AllertaValanghe> getAllertaValanghesOrdered( int start, int end, OrderByComparator<AllertaValanghe> comparator) {
		Session session = null;

	    try {
	        session = openSession();

	        String sql =  CustomSQLUtil.get(this.getClass(), FIND_ALL_ALLERTAVALANGHE_ORDERED);
	        sql = CustomSQLUtil.replaceOrderBy(sql, comparator);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.addEntity(AllertaValangheImpl.TABLE_NAME, AllertaValangheImpl.class);

	        //QueryPos qPos = QueryPoss.getInstance(q);
	        //qPos.add(groupId);
	       

	        return (List<AllertaValanghe>) QueryUtil.list(q, getDialect(), start, end);
	    }
	    finally {
	        closeSession(session);
	    }
	}
	
	public long getUtenteApprovatore(long idAllertaValanghe) {
		    Session session = null;
		    try {
		        session = openSession();

		        String sql = "select assigneeclasspk from kaleotaskassignmentinstance where kaleotaskinstancetokenid in "+
		        "(select kaleotaskinstancetokenid from kaleotaskinstancetoken where "+
		        "classname='it.eng.allerter.model.AllertaValanghe' and classpk="+idAllertaValanghe+") and assigneeclassname='com.liferay.portal.model.User' order by modifieddate desc limit 1;";

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);

		       List<Object> o = q.list();
		       
		       if (o!=null && o.size()>0) return Long.parseLong(o.get(0).toString());
		       else return 0;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }

		    return 0;
		} 
	
	public List<Object> getMacroareeAllertaValanghe(int giorni) {	
		String timestamp = (giorni==0? "current_timestamp" : "current_timestamp + interval '"+giorni+" days'");
		
		String query = "select abs(areaid) as areaid, x.eventi from (" +
		 "select allertavalangheid, areaid, string_agg('' || eventoid || ':' || statoid,',') as eventi "
				+ " from allerter_allertavalanghestato ass where allertavalangheid = "
						+ "(select allertavalangheid from allerter_allertavalanghe a where datainizio<"+timestamp+" "
						+ "	and datafine>"+timestamp+" and stato=0 "
						+ " and not exists (select allertavalangheid from allerter_allertavalanghe a2 where "
						+ " a2.stato=0 and a2.dataemissione>a.dataemissione "
						+ " and a2.datainizio<="+timestamp
						+ " and a2.datafine>="+timestamp+") order by dataemissione desc limit 1) " 
						+ " group by allertavalangheid, areaid  order by areaid) x "
						+ " join allerter_allertavalanghe aa on aa.allertavalangheid=x.allertavalangheid "
						+ " where aa.parentid=0 or (date("+timestamp+")=date(aa.datainizio) and x.areaid<0) "
						+ " or (date("+timestamp+")<>date(aa.datainizio) and x.areaid>0)";
		/*** Non capisco, rimuovo il filtro exists ***/
		
		/*
		String query = "select areaid, string_agg('' || eventoid || ':' || statoid,',') as eventi "
				+ " from allerter_allertavalanghestato ass where allertavalangheid = "
						+ "(select allertavalangheid from allerter_allertavalanghe a where datainizio<"+timestamp+" "
						+ "	and datafine>"+timestamp+" and stato=0 "
						+ " order by dataemissione desc limit 1) " 
						+ " group by areaid  order by areaid";
		*/
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       List<Object> o = q.list();
		       
		       if (o!=null && o.size()>0) return o;
		       else return null;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
	}
	
	public List<Object> getMacroareeAllertaValanghePrimes(int giorni) {	
		String timestamp = (giorni==0? "current_timestamp" : "current_timestamp + interval '"+giorni+" days'");
		
		String query = "select areaid, string_agg('' || eventoid || ':' || statoid,',') as eventi from allerter_allertavalanghestato ass where allertavalangheid = " +
		"(select allertavalangheid from allerter_allertavalanghe a where datainizio<"+timestamp+" and datafine>"+timestamp+" and eventoid<4 and stato=0 "+
				"and not exists (select allertavalangheid from allerter_allertavalanghe a2 where a2.stato=0 and a2.dataemissione>a.dataemissione "+
		" and a2.datafine<="+timestamp+") order by dataemissione desc limit 1) " +
		"group by areaid  order by areaid";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       List<Object> o = q.list();
		       
		       if (o!=null && o.size()>0) return o;
		       else return null;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
	}
	
	public Map<String,Object> getInfoAllertaValanghe(int giorni) {
		String timestamp = (giorni==0? "current_timestamp" : "current_timestamp + interval '"+giorni+" days'");
		
		
		String query =
		"select numero, link, datainizio, datafine, tipoallerta, titolo from allerter_allertavalanghe a where datainizio<"+timestamp+" and datafine>"+timestamp+" and stato=0 "+
		"and not exists (select allertavalangheid from allerter_allertavalanghe a2 where a2.stato=0 and a2.dataemissione>a.dataemissione "+
		" and a2.datainizio<=" +timestamp+
		" and a2.datafine>="+timestamp+
				") order by dataemissione desc limit 1 ";
		
		/* Non capisco - rimouovo il filtro exists */
		/*
		String query =
				"select numero, sintesi, link, datainizio, datafine, tipoallerta, titolo from allerter_allertavalanghe a where datainizio<"+timestamp+" and datafine>"+timestamp+" and stato=0 "+
				" order by dataemissione desc limit 1 ";*/
				
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       List<Object> oo = (List<Object>) q.list();
		       Object[] o;
		       if (oo!=null && oo.size()>0) o = (Object[])oo.get(0);
		       else o = new Object[6];
		       
		       if (o!=null && o.length>0) {
		    	   HashMap<String, Object> m = new HashMap<String, Object>();
		    	   m.put("numero", o[0]);
		    	   m.put("link", o[1]);
		    	   m.put("datainizio", o[2]);
		    	   m.put("datafine", o[3]);
		    	   m.put("tipo", o[4]!=null && o[4].toString()!=null && o[4].toString().toLowerCase().equals("true")? "AllertaValanghe" : "BollettinoValanghe");
		    	   m.put("titolo", o[5]);
		    	   return m;
		       }
		       else return null;
		       
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
	}
	
	public List<Object> getEventi(long allertaValangheId) {
		String query = "select eventoid,statoid,areaid from allerter_allertavalanghestato where allertavalangheid = "+allertaValangheId;
				
				  Session session = null;
				    try {
				        session = openSession();

				        SQLQuery q = session.createSQLQuery(query);
				        q.setCacheable(false);

				       List<Object> o = q.list();
				       
				       if (o!=null && o.size()>0) return o;
				       else return null;
				       
				    } catch (Exception e) {
				        e.printStackTrace();
				    } finally {
				        closeSession(session);
				    }
				    
				    return null;
	}
	
	public String nextIdAllertaValanghe(boolean allertaValanghe, int anno) {
		String tipo = (allertaValanghe?"tipoallerta":"not tipoallerta");
		
		String query = "select numero from allerter_allertavalanghe where "+tipo+" and stato=0 and numero like '%/"+anno+"' order by numero desc limit 1";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       List<Object> o = q.list();
		       
		       if (o==null || o.size()==0) return "001/"+anno;
		       
		       int i = Integer.parseInt(o.get(0).toString().substring(0, 3));
		       
		       i++;
		       String s = ""+i;
		       while (s.length()<3) s = "0"+s;
		       
		       return s+"/"+anno;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "";
		    } finally {
		        closeSession(session);
		    }	
	}
}
