package allerta.verifica.web.bean;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import allerta.catasto.model.Segnalazione;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.verifica.model.UtenteLavoro;
import allerta.verifica.model.Verifica;
import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.UtenteLavoroLocalServiceUtil;
import allerta.verifica.service.VerificaDatoLocalServiceUtil;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.web.constants.CostantiVerificaAllerte;
import allerta.verifica.web.datacreator.VerificaDatoFactory;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class VerificaAllertaBean {

	HttpServletRequest httpRequest = null;
	long id = 0;
	long eventoSelezionato1=1;
	long eventoSelezionato2=1;
	Verifica verifica;
	List<VerificaDato> tuttiDati;
	List<GiornoPrecipitazioni> giornoPrecipitazioni;
	List<GiornoFenomeno> giornoFenomeni;
	boolean first = false;
	boolean last = false;
	Map<Date,List<Segnalazione>> segnalazioni;
	String descrizioneMeteo = null;
	List<UtenteLavoro> altriUtenti = null;
	List<UtenteLavoro> altriRead = new ArrayList<UtenteLavoro>();
	List<UtenteLavoro> altriWrite = new ArrayList<UtenteLavoro>();
	
	String utente = null;
	
	public VerificaAllertaBean(HttpServletRequest request) {
		httpRequest = PortalUtil.getOriginalServletRequest( 
				request); 
		creaVerificheMancanti();
	}
	
	
	public VerificaAllertaBean(long aid, HttpServletRequest request) {
		httpRequest = PortalUtil.getOriginalServletRequest( 
				request); 
		id = aid;
		try {
			User u = PortalUtil.getUser(request);
			if (u!=null) utente = u.getScreenName();
		} catch (Exception e) {
			
		}
		verifica = VerificaLocalServiceUtil.fetchVerifica(id);
		tuttiDati = VerificaDatoLocalServiceUtil.dynamicQuery(
				VerificaDatoLocalServiceUtil.dynamicQuery().add(PropertyFactoryUtil.forName("documento").eq(id)));
		
		segnalazioni = new HashMap<Date, List<Segnalazione>>();
		

		try {
			first = BollettinoLocalServiceUtil.eseguiQueryGenerica("select id_ from verifica_verifica where createdate<(select createdate from verifica_verifica where id_="
				+id+") order by createdate desc limit 1")==null;
		
			last = BollettinoLocalServiceUtil.eseguiQueryGenerica("select id_ from verifica_verifica where createdate>(select createdate from verifica_verifica where id_="
				+id+") order by createdate asc limit 1")==null;
		} catch (Exception e) {}
		
		ArrayList<VerificaDato> tuttiDati2 = new ArrayList<VerificaDato>();
		tuttiDati2.addAll(tuttiDati);
		tuttiDati = tuttiDati2;
		
		giornoPrecipitazioni = new ArrayList<GiornoPrecipitazioni>();
		
		List<Date> giorni = getGiorni(verifica.getDataInizio(),verifica.getDataFine());
		
		for (Date ggg : giorni) {
			List<Segnalazione> segn = SegnalazioneLocalServiceUtil.dynamicQuery(SegnalazioneLocalServiceUtil.dynamicQuery().
					add(PropertyFactoryUtil.forName("dataEvento").eq(ggg)).addOrder(OrderFactoryUtil.asc("id")));
			segnalazioni.put(ggg, segn);
		}

		
		for (Date giorno : giorni) {
			
			DynamicQuery dq = VerificaDatoLocalServiceUtil.dynamicQuery().add(PropertyFactoryUtil.forName("giorno").eq(giorno))
					.add(PropertyFactoryUtil.forName("documentoAssociato").eq(id)).add(PropertyFactoryUtil.forName("nomeDato").like("precipitazioni_%"));
			dq.addOrder(OrderFactoryUtil.asc("zona"));
			//List<VerificaDato> prec = VerificaDatoLocalServiceUtil.dynamicQuery(dq);
			//tuttiDati.addAll(prec);
		}
		
		Allerta a = AllertaLocalServiceUtil.fetchAllerta(id);
		tuttiDati = VerificaDatoFactory.initializeVerifica(a, tuttiDati);
		descrizioneMeteo = a.getDescrizioneMeteo();
		if (descrizioneMeteo!=null) {
			descrizioneMeteo = descrizioneMeteo.replaceAll("\n", "<br/><br/>");
		}
		
		for (Date giorno : giorni) {
			
			DynamicQuery dq = VerificaDatoLocalServiceUtil.dynamicQuery().add(PropertyFactoryUtil.forName("giorno").eq(giorno))
					.add(PropertyFactoryUtil.forName("nomeDato").like("precipitazioni_%"));
			dq.addOrder(OrderFactoryUtil.asc("zona"));
			List<VerificaDato> prec = VerificaDatoLocalServiceUtil.dynamicQuery(dq);
			GiornoPrecipitazioni gp = new GiornoPrecipitazioni(giorno,prec,id);
			
			giornoPrecipitazioni.add(gp);
			
	
			
		}
		
		giornoFenomeni = new ArrayList<GiornoFenomeno>();
		for (int fenomeno=1; fenomeno<=9; fenomeno++) {
			for (Date giorno : getGiorniAncheParziali(verifica.getDataInizio(),verifica.getDataFine())) {
				GiornoFenomeno gf = new GiornoFenomeno();
				gf.setDocumento(aid);
				gf.setEvento(fenomeno);
				gf.setGiorno(giorno);
				gf.setDati(filtraDati(giorno, "", (long)fenomeno, null, null));
				
				String zon[] = (fenomeno>=8?CostantiVerificaAllerte.SOTTOZONE_COSTA:CostantiVerificaAllerte.SOTTOZONE);
				for (String sss : zon) {
					GiornoFenomenoRiga gfr = new GiornoFenomenoRiga();
					gfr.setDocumento(aid);
					gfr.setEvento(fenomeno);
					gfr.setGiorno(giorno);
					gfr.setZona(sss);
					gfr.setDati(filtraDati(giorno, sss, (long)fenomeno, null, null));
					gfr.setSegnalazioni(new ArrayList<Segnalazione>());
					Date giorno2 = togliOre(giorno);
					if (segnalazioni!=null && segnalazioni.get(giorno2)!=null) {
						for (Segnalazione seg : segnalazioni.get(giorno2)) {
							if (seg.getCategoria()==0 || seg.getCategoria()==fenomeno) {
								if (seg.getArea()!=null && seg.getArea().equals(sss)) {
									gfr.getSegnalazioni().add(seg);
									
								}
							}
						}
					}
					gf.righe.add(gfr);
				}
				giornoFenomeni.add(gf);
			}
		}
		
		altriUtenti = UtenteLavoroLocalServiceUtil.dynamicQuery(
		UtenteLavoroLocalServiceUtil.dynamicQuery().add(PropertyFactoryUtil.forName("documento").eq(id))
		);
		aggiornaSessione("READ");
		
		for (UtenteLavoro ul : altriUtenti) {
			if (ul.getAttivita().equals("READ") && !ul.getUtente().equals(utente))
				altriRead.add(ul);
			if (ul.getAttivita().equals("WRITE") && !ul.getUtente().equals(utente))
				altriWrite.add(ul);
		}
	}


	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}


	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
	
	private List<VerificaDato> filtraDati(Date giorno,String zona,Long evento,String nomeDato,Integer progressivo) {
		return VerificaAllertaBean.filtraDati(tuttiDati,giorno,zona,evento,nomeDato,progressivo);
	}
	
	public static List<VerificaDato> filtraDati(List<VerificaDato> source, Date giorno,String zona,Long evento,String nomeDato,Integer progressivo) {
		List<VerificaDato> out = new ArrayList<VerificaDato>();
		
		for (VerificaDato v : source) {
			if ((giorno==null || giorno.equals(v.getGiorno())) &&
					(zona==null || zona.equals(v.getZona())) &&
					(evento==null || evento.equals(v.getEvento())) &&
					(nomeDato==null || nomeDato.equals(v.getNomeDato())) &&
					(progressivo==null || progressivo.equals(v.getProgressivo())))
				out.add(v);
					
		}
		
		if (out==null || out.size()==0) System.out.println("Non trovato "+giorno+" "+zona+" "+evento+" "+nomeDato);
		return out;
	}

	public static List<VerificaDato> filtraDati(List<VerificaDato> source, Long doc, Date giorno,String zona,Long evento,String nomeDato,Integer progressivo) {
		List<VerificaDato> out = new ArrayList<VerificaDato>();
		
		for (VerificaDato v : source) {
			if ((giorno==null || giorno.equals(v.getGiorno())) &&
					(doc==null || doc.equals(v.getDocumento())) &&
					(zona==null || zona.equals(v.getZona())) &&
					(evento==null || evento.equals(v.getEvento())) &&
					(nomeDato==null || nomeDato.equals(v.getNomeDato())) &&
					(progressivo==null || progressivo.equals(v.getProgressivo())))
				out.add(v);
					
		}
		
		if (out==null || out.size()==0) System.out.println("Non trovato "+giorno+" "+zona+" "+evento+" "+nomeDato);
		return out;
	}
	
	public static VerificaDato filtraDatiUnico(List<VerificaDato> source, Date giorno,String zona,Long evento,String nomeDato,Integer progressivo) {
		
		for (VerificaDato v : source) {
			if ((giorno==null || giorno.equals(v.getGiorno())) &&
					(zona==null || zona.equals(v.getZona())) &&
					(evento==null || evento.equals(v.getEvento())) &&
					(nomeDato==null || nomeDato.equals(v.getNomeDato())) &&
					(progressivo==null || progressivo.equals(v.getProgressivo())))
				return v;
					
		}
		System.out.println("Non trovato "+giorno+" "+zona+" "+evento+" "+nomeDato);
		return null;
	}
	
	public static VerificaDato filtraDatiUnico(List<VerificaDato> source, Long doc, Date giorno,String zona,Long evento,String nomeDato,Integer progressivo) {
		
		for (VerificaDato v : source) {
			if ((giorno==null || giorno.equals(v.getGiorno())) &&
					(doc==null || doc.equals(v.getDocumento())) &&
					(zona==null || zona.equals(v.getZona())) &&
					(evento==null || evento.equals(v.getEvento())) &&
					(nomeDato==null || nomeDato.equals(v.getNomeDato())) &&
					(progressivo==null || progressivo.equals(v.getProgressivo())))
				return v;
					
		}
		System.out.println("Non trovato "+giorno+" "+zona+" "+evento+" "+nomeDato);
		return null;
	}
	
	public static VerificaDato nuovoVerificaDato(Long doc, Date giorno, String zona, Long evento, String nomeDato, Integer progressivo) {
		VerificaDato v = VerificaDatoLocalServiceUtil.createVerificaDato(CounterLocalServiceUtil.increment(VerificaDato.class.getName()));
		v.setDocumento(doc!=null?doc:0);
		v.setGiorno(giorno);
		v.setEvento(evento!=null?evento:-1);
		v.setZona(zona);
		v.setNomeDato(nomeDato);
		v.setProgressivo(progressivo!=null?progressivo:0);
		VerificaDatoLocalServiceUtil.addVerificaDato(v);
		return v;
	}
	
	public static void salvaVerificaDato(HttpServletRequest request, List<VerificaDato> l) {
		int salvati = 0;
		for (VerificaDato v : l) {
			String field = CostruttoreVerificaDato.getFieldName(v);
			String val = ParamUtil.getString(request, field,null);
			if (val!=null && !val.equals(v.getDatoInserito())) {
				v.setDatoInserito(val);
				VerificaDatoLocalServiceUtil.updateVerificaDato(v);
				salvati++;
			}
		}
		System.out.println("Salvati "+salvati+" verificadato");
	}
	
	public void creaVerificheMancanti() {
		List<Object[]> ll = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select a.allertaid, a.titolo from allerter_allerta a left join verifica_verifica v on v.id_ = a.allertaid where v.id_ is null and a.stato=0 and a.datafine<current_timestamp and a.datafine>'2021-12-31' order by a.datainizio desc limit 10");
		if (ll!=null && ll.size()>0) {
			for (Object[] o : ll) {
				try {
					Long id = Long.parseLong(o[0].toString());
					Verifica v = VerificaLocalServiceUtil.createVerifica(id);
					Allerta a = AllertaLocalServiceUtil.fetchAllerta(id);
					v.setDataInizio(a.getDataInizio());
					v.setDataFine(a.getDataFine());
					v.setTitolo(a.getTitolo());
					v.setCompanyId(a.getCompanyId());
					v.setCreateDate(a.getCreateDate());
					v.setGroupId(a.getGroupId());
					v.setLink(a.getLink());
					v.setHash(a.getHash());
					v.setNote(a.getNote());
					v.setStato(0);
					if (a.getTitolo()!=null) {
						String titoloSplit[] = a.getTitolo().split(":");
						v.setFenomeni(titoloSplit[titoloSplit.length-1].trim().toUpperCase());
						v.setFenomeniDescritti(titoloSplit[titoloSplit.length-1].trim().toUpperCase());
					}
					
					VerificaLocalServiceUtil.addVerifica(v);
					
				
					VerificaDatoFactory.initializeVerifica(a, new ArrayList<VerificaDato>());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void salva() {
		
		if (verifica.getStato()!=0) return;
		
		verifica.setFenomeni(ParamUtil.getString(httpRequest, "fenomeni"));
		verifica.setFenomeniDescritti(ParamUtil.getString(httpRequest, "fenomeniDescritti"));
		verifica.setNote(ParamUtil.getString(httpRequest, "note"));
		
		VerificaLocalServiceUtil.updateVerifica(verifica);
		salvaVerificaDato(httpRequest,tuttiDati);
		aggiornaSessione("WRITE");
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Verifica getVerifica() {
		return verifica;
	}


	public void setVerifica(Verifica verifica) {
		this.verifica = verifica;
	}
	
	public static List<Date> getGiorni(Date dataInizio,Date dataFine) {
		List<Date> d = new ArrayList<Date>();
		
		Date x = dataInizio;
		Calendar c = Calendar.getInstance();
		c.setTime(x);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		while (c.getTime().before(dataFine)) {
			d.add(c.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return d;
	}
	
	public static Date togliOre(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	public static List<Date> getGiorniAncheParziali(Date dataInizio,Date dataFine) {
		List<Date> d = new ArrayList<Date>();
		
		Date x = dataInizio;
		Calendar c = Calendar.getInstance();
		c.setTime(x);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		if (!c.getTime().equals(dataInizio)) {
			d.add(dataInizio);
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		while (c.getTime().before(dataFine)) {
			d.add(c.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return d;
	}


	public List<VerificaDato> getTuttiDati() {
		return tuttiDati;
	}


	public void setTuttiDati(List<VerificaDato> tuttiDati) {
		this.tuttiDati = tuttiDati;
	}


	public List<GiornoPrecipitazioni> getGiornoPrecipitazioni() {
		return giornoPrecipitazioni;
	}


	public void setGiornoPrecipitazioni(List<GiornoPrecipitazioni> giornoPrecipitazioni) {
		this.giornoPrecipitazioni = giornoPrecipitazioni;
	}


	public List<GiornoFenomeno> getGiornoFenomeni() {
		return giornoFenomeni;
	}


	public void setGiornoFenomeni(List<GiornoFenomeno> giornoFenomeni) {
		this.giornoFenomeni = giornoFenomeni;
	}


	public long getEventoSelezionato1() {
		return eventoSelezionato1;
	}


	public void setEventoSelezionato1(long eventoSelezionato1) {
		this.eventoSelezionato1 = eventoSelezionato1;
	}


	public long getEventoSelezionato2() {
		return eventoSelezionato2;
	}


	public void setEventoSelezionato2(long eventoSelezionato2) {
		this.eventoSelezionato2 = eventoSelezionato2;
	}


	public boolean isFirst() {
		return first;
	}


	public void setFirst(boolean first) {
		this.first = first;
	}


	public boolean isLast() {
		return last;
	}


	public void setLast(boolean last) {
		this.last = last;
	}
	
	public String getDataInizioSettimana() {
		Calendar c = Calendar.getInstance();
		c.setTime(verifica.getDataInizio());
		c.add(Calendar.HOUR_OF_DAY, 4);
		int dow = c.get(Calendar.DAY_OF_WEEK);
		int sub = 0;
		switch (dow) {
		case Calendar.TUESDAY: sub = -1; break;
		case Calendar.WEDNESDAY: sub = -2; break;
		case Calendar.THURSDAY: sub = -3; break;
		case Calendar.FRIDAY: sub = -4; break;
		case Calendar.SATURDAY: sub = -5; break;
		case Calendar.SUNDAY: sub = -6; break;
		
		}
		
		c.add(Calendar.DAY_OF_YEAR, sub);
		return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				
	}


	public String getDescrizioneMeteo() {
		return descrizioneMeteo;
	}


	public void setDescrizioneMeteo(String descrizioneMeteo) {
		this.descrizioneMeteo = descrizioneMeteo;
	}
	
	private void pulisciUtenti() {
		BollettinoLocalServiceUtil.eseguiQueryGenerica(
				"delete from verifica_utentelavoro where "
				+ "current_timestamp-ts>cast('60 minutes' as interval);");
	}
	
	public static void tuttoVerde(long vid) {
		String q = "update verifica_verificadato set datoinserito='VERDE' where (datoinserito=' ' or datoinserito is null) and nomedato='colore_post' and documento="+vid;
		BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
	}
	
	public void aggiornaSessione(String attivita) {
		pulisciUtenti();
		if (altriUtenti==null || utente==null) return;
		
		for (UtenteLavoro ul : altriUtenti) {
			if (utente.equals(ul.getUtente()) && attivita.equals(ul.getAttivita())) {
				ul.setTs(new Date());
				UtenteLavoroLocalServiceUtil.updateUtenteLavoro(ul);
				return;
			}
		}
		
		UtenteLavoro ul = UtenteLavoroLocalServiceUtil.createUtenteLavoro(
				CounterLocalServiceUtil.increment(UtenteLavoro.class.getName()));
		ul.setUtente(utente);
		ul.setDocumento(id);
		ul.setAttivita(attivita);
		ul.setTs(new Date());
		UtenteLavoroLocalServiceUtil.addUtenteLavoro(ul);
	}


	public List<UtenteLavoro> getAltriUtenti() {
		return altriUtenti;
	}


	public void setAltriUtenti(List<UtenteLavoro> altriUtenti) {
		this.altriUtenti = altriUtenti;
	}


	public List<UtenteLavoro> getAltriRead() {
		return altriRead;
	}


	public void setAltriRead(List<UtenteLavoro> altriRead) {
		this.altriRead = altriRead;
	}


	public List<UtenteLavoro> getAltriWrite() {
		return altriWrite;
	}


	public void setAltriWrite(List<UtenteLavoro> altriWrite) {
		this.altriWrite = altriWrite;
	}


	public String getUtente() {
		return utente;
	}


	public void setUtente(String utente) {
		this.utente = utente;
	}
	
	
	
}
