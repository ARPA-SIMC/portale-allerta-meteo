package it.eng.bollettino.service.persistence.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.persistence.BollettinoFinder;

public class BollettinoFinderImpl extends BollettinoFinderBaseImpl implements BollettinoFinder {
	
	public List<Object> getFiumiBollettino(long id) {

		Session session = null;
	    try {
	        session = openSession();

	        String sql = "select distinct b2.nomebacino from bollettino_bollettinobacino b2 join bollettino_bollettinosensore bs on b2.id_ = bs.idbollettinobacino where bs.idbollettino="+id+" and bs.tendenza<>-100";
	        		
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);

	       List<Object> o = q.list();
	       
	       return o;
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}
	
	public List<Object> getComuniAllarme() {
		
		Session session = null;
	    try {
	        session = openSession();

	        //String sql = "select max(a.colore), upper(g.name) from bollettino_allarme a join bollettino_regolaallarmecomune c on a.idregola = c.idregola join group_ g on c.idcomune = g.groupid where stato = 0 and datafine is null group by g.name";
	        String sql = "select max(colore), upper(comune) from comune_superamento_vw where datafine is null group by upper(comune)";	
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);

	       List<Object> o = q.list();
	       
	       return o;
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}   
		
	
	public long getUtenteApprovatore(long idBollettino) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = "select assigneeclasspk from kaleotaskassignmentinstance where kaleotaskinstancetokenid in "+
		        "(select kaleotaskinstancetokenid from kaleotaskinstancetoken where "+
		        "classname='it.eng.bollettino.model.Bollettino' and classpk="+idBollettino+") and assigneeclassname='com.liferay.portal.model.User' order by modifieddate desc limit 1;";

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
	
	
	public double getSommaValori(String idStazione, String idVariabile, int quanti) {

	    Session session = null;
	    try {
	        session = openSession();

	        String sql = "select sum(value) from (select value from bollettino_valoresensore where idvariabile = '"+idVariabile+"' and idstazione = '"+idStazione+"' order by datetime desc limit "+quanti+") x";

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);

	       List<Object> o = q.list();
	       
	       if (o!=null && o.size()>0 && o.get(0)!=null) return Double.parseDouble(o.get(0).toString());
	       else return 0;
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }

	    return 0;
	}   
	
	
	public String nextIdMonitoraggio(int anno) {
		
		
		String query = "select numero from bollettino_bollettino where stato=0 order by dataapprovazione desc limit 1";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       List<Object> o = q.list();
		       
		       if (o==null || o.size()==0) return "001/"+anno + "/01";
		       
		       String num = o.get(0).toString();
		       
		       
		       if (num.endsWith("U") || num.endsWith("ULTIMO")) {
		    	   //era l'ultimo, comincia un nuovo evento
		    	   String ann = ""+anno;
		    	   if (num.contains(ann)) {
		    		   //lo stesso anno del precedente
		    		   int i = Integer.parseInt(o.get(0).toString().substring(0, 3));
		    		   i++;
		    		   String s = ""+i;
				       while (s.length()<3) s = "0"+s;
				       return s + "/" + ann + "/01";
		    	   } else {
		    		   //anno nuovo
		    		   return "001/"+anno+"/01";
		    	   }
		       } else {
		    	   try {
		    	   //prosegue l'evento precedente, cambia solo l'ultima parte... ignora i primi 9 caratteri
		    	   int i = Integer.parseInt(num.substring(9, 11));
		    	   i++;
		    	   String s = ""+i;
			       while (s.length()<2) s = "0"+s;
			       
		    	   return num.substring(0, 9) + s;
		    	   } catch (Exception e) {
		    		   return "001/"+anno+"/01";
		    	   }
		       }
		       
		       
		      		       
		    } catch (Exception e) {
		    	try {
					File f = new File("C:\\Users\\GFAVINI\\Documents\\Liferay\\liferay-portal-6.2-ce-ga6\\logs\\rigenera2.txt");
					f.createNewFile();
					PrintWriter pw = new PrintWriter(f);
					e.printStackTrace(pw);
					pw.flush();
					pw.close();
				} catch (Exception ex2) {
					ex2.printStackTrace();
				}
		    	return "";
		    } finally {
		        closeSession(session);
		    }
		    
		
	}
	
	public Object eseguiQueryGenerica(String s) {
		
		 Session session = null;
		    try {
		        session = openSession();


		        SQLQuery q = session.createSQLQuery(s);
		        q.setCacheable(false);

		       if (!s.toUpperCase().startsWith("SELECT")) {
		    	   q.executeUpdate();
		    	   return null;
		       }
		        
		       Object o = q.uniqueResult();
		       
		       return o;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		        //LogInternoLocalServiceUtil.log("BollettinoFinderUtil", "eseguiQueryGenerica", e, "");
		        _log.error(e);
		    } finally {
		        closeSession(session);
		    }

		    return null;
		
	}
	
	public List<Object> eseguiQueryGenericaLista(String s) {
		
		 Session session = null;
		    try {
		        session = openSession();


		        SQLQuery q = session.createSQLQuery(s);
		        q.setCacheable(false);
		        
		        if (!s.toUpperCase().startsWith("SELECT")) {
			    	   q.executeUpdate();
			    	   return null;
			       }

		       List o = q.list();
		       
		       return o;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		       // LogInternoLocalServiceUtil.log("BollettinoFinderUtil", "eseguiQueryGenerica", e, "");
		        _log.error(e);
		    } finally {
		        closeSession(session);
		    }

		    return null;
		
	}
	
	private Log _log = LogFactoryUtil.getLog(BollettinoFinderImpl.class);

}
