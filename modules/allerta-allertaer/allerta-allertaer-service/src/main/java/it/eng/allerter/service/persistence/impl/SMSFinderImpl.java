package it.eng.allerter.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import it.eng.allerter.service.persistence.SMSFinder;

public class SMSFinderImpl extends SMSFinderBaseImpl implements SMSFinder  {
	
	
	public int eliminaDuplicati(String tipo, String sottotipo, long param) {
		
		String tipo1 = (tipo!=null?" and s.tipo='"+tipo+"' ":"");
		String sottotipo1 = (sottotipo!=null?" and s.sottotipo='"+sottotipo+"' ":"");
		String param1 = (param!=0?" and s.param="+param+" ":"");
		
		String tipo2 = (tipo!=null?" and s2.tipo=s.tipo ":"");
		String sottotipo2 = (sottotipo!=null?" and s2.sottotipo=s.sottotipo ":"");
		String param2 = (param!=0?" and s2.param=s.param ":"");
		
		String queryDelete = "delete from allerter_sms s where s.stato = 0 "+tipo1+sottotipo1+param1+" and s.id_ < (select max(id_) from allerter_sms s2 where s2.stato=0 and s2.numero=s.numero and s2.destinatario=s.destinatario "+tipo2+sottotipo2+param2+")";
		String query = "update allerter_sms s set stato = -1000 where s.stato = 0 "+tipo1+sottotipo1+param1+" and s.id_ < (select max(id_) from allerter_sms s2 where s2.stato=0 and s2.numero=s.numero "+tipo2+sottotipo2+param2+")";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(queryDelete);
		        q.setCacheable(false);

		       int del = q.executeUpdate();
			       
			   System.out.println("Cancellati "+del+" SMS duplicati"); 
		        
			   q = session.createSQLQuery(query);
		       del = q.executeUpdate();
		       System.out.println("Segnati "+del+" SMS duplicati");
		       return del;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return 0;
		
		
	}
	
	public int eliminaDuplicatiEmail(String tipo, String sottotipo, long param) {
		
		String tipo1 = (tipo!=null?" and s.tipo='"+tipo+"' ":"");
		String sottotipo1 = (sottotipo!=null?" and s.sottotipo='"+sottotipo+"' ":"");
		String param1 = (param!=0?" and s.param="+param+" ":"");
		
		String tipo2 = (tipo!=null?" and s2.tipo=s.tipo ":"");
		String sottotipo2 = (sottotipo!=null?" and s2.sottotipo=s.sottotipo ":"");
		String param2 = (param!=0?" and s2.param=s.param ":"");
		
		String query = "delete from allerter_email s where s.stato = 0 "+tipo1+sottotipo1+param1+" and s.id_ < (select max(id_) from allerter_email s2 where s2.stato=0 and s2.indirizzo=s.indirizzo "+tipo2+sottotipo2+param2+")";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       int del = q.executeUpdate();
		       
		       System.out.println("Cancellati "+del+" indirizzi email duplicati");
		       return del;
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return 0;
		
		
	}
	
	public List<Object[]> ottieniPerSpedizione(String tipo, String sottotipo, long param) {
	
		  return ottieniPerSpedizione(tipo, sottotipo, param, 0, 1, -1);
		
	}
	
	public List<Object[]> ottieniPerSpedizione(String tipo, String sottotipo, long param, int currentStatus, int newStatus, int limit) {
		
		String tipo1 = (tipo!=null?" and s2.tipo='"+tipo+"' ":"");
		String sottotipo1 = (sottotipo!=null?" and s2.sottotipo='"+sottotipo+"' ":"");
		String param1 = (param!=0?" and s2.param="+param+" ":"");
		String lim = (limit>0?"limit "+limit:"");
		
		
		String query = "update allerter_sms s set stato = "+newStatus+" from (select * from allerter_sms s2 where s2.stato = "+currentStatus+" "+tipo1+sottotipo1+param1+" order by s2.id_ asc "+lim+" for update) a where s.id_ = a.id_ returning s.numeroda,s.numero,s.testo,s.id_";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);
		        //q.addEntity("allerter_sms", SMS.class);

		       return q.list();
		       

		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
		
	}
	
	public List<String> ottieniEmailPerSpedizione(String tipo, String sottotipo, long param) {
		
		String tipo1 = (tipo!=null?" and s2.tipo='"+tipo+"' ":"");
		String sottotipo1 = (sottotipo!=null?" and s2.sottotipo='"+sottotipo+"' ":"");
		String param1 = (param!=0?" and s2.param="+param+" ":"");
		
		
		
		String query = "update allerter_email s set stato = 1 from (select * from allerter_email s2 where s2.stato = 0 "+tipo1+sottotipo1+param1+" order by s2.id_ asc for update) a where s.id_ = a.id_ returning s.indirizzo";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       return q.list();
		       

		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
		
	}
	
public List<String> ottieniEmailPerSpedizione(String tipo, String sottotipo, long param, String text, String subject) {
		
		String tipo1 = (tipo!=null?" and s2.tipo='"+tipo+"' ":"");
		String sottotipo1 = (sottotipo!=null?" and s2.sottotipo='"+sottotipo+"' ":"");
		String param1 = (param!=0?" and s2.param="+param+" ":"");
		
		String txt = text.replaceAll("'", "''");
		String sub = subject.replaceAll("'", "''");
		
		String query = "update allerter_email s set stato = 1, testo='"+txt+"', oggetto='"+sub+"' from (select * from allerter_email s2 where s2.stato = 0 "+tipo1+sottotipo1+param1+" order by s2.id_ asc for update) a where s.id_ = a.id_ returning s.indirizzo";
		
		  Session session = null;
		    try {
		        session = openSession();

		        SQLQuery q = session.createSQLQuery(query);
		        q.setCacheable(false);

		       return q.list();
		       

		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        closeSession(session);
		    }
		    
		    return null;
		
	}

	public int marcaMessaggiInTimeout() {
		String query = "update allerter_sms s set stato = 5 where stato in (3,6) and dataack is not null and current_timestamp - dataack > '3 days'";
		Session session = null;
	    try {
	        session = openSession();

	        SQLQuery q = session.createSQLQuery(query);
	        q.setCacheable(false);

	       return q.executeUpdate();
	       

	       
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    } finally {
	        closeSession(session);
	    }
	}
	
	
}
