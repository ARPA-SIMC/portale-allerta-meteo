package allerta.catasto.bean;

import com.liferay.admin.kernel.util.PortalUserPersonalBarApplicationType;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import allerta.catasto.model.Effetti;
import allerta.catasto.model.EffettiSub;
import allerta.catasto.model.Segnalazione;
import allerta.catasto.model.Sottocategoria;
import allerta.catasto.service.EffettiLocalServiceUtil;
import allerta.catasto.service.EffettiSubLocalServiceUtil;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.catasto.service.SottocategoriaLocalServiceUtil;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

public class CatastoBean {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	HttpServletRequest httpRequest = null;
	long id = 0;
	
	Segnalazione segnalazione;
	Allerta allertaCollegata;
	
	List<Object[]> comuni;
	List<Sottocategoria> sottocategorie;
	List<Effetti> effetti;
	List<EffettiSub> effettiSub;
	
	boolean readonly;
	
	public CatastoBean(HttpServletRequest request) {
		this(0,request);
	}
	
	public CatastoBean(long aid, HttpServletRequest request) {
		httpRequest = PortalUtil.getOriginalServletRequest( 
				request); 
		id = aid;
		if (id>0) {
			segnalazione = SegnalazioneLocalServiceUtil.fetchSegnalazione(id);
			if (segnalazione.getDocumentoAssociato()>0) {
				allertaCollegata = AllertaLocalServiceUtil.fetchAllerta(segnalazione.getDocumentoAssociato());
			}
		}
		
		comuni = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select nome,area,provincia from storico_aree where current_timestamp>=data_inizio and current_timestamp<=data_fine " + 
				"and tipo='M' and provincia is not null order by nome");
		
		sottocategorie = SottocategoriaLocalServiceUtil.getSottocategorias(-1, -1);
		effetti = EffettiLocalServiceUtil.getEffettis(-1, -1);
		effettiSub = EffettiSubLocalServiceUtil.getEffettiSubs(-1, -1);
		
		try {
			readonly = true;
			User u = PortalUtil.getUser(request);
			long[] roles = UserLocalServiceUtil.getRolePrimaryKeys(u.getUserId());
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_CATASTO_EDIT");
			if (bp!=null && bp.getValore()!=null) {
				String val = bp.getValore();
				for (long l : roles)
					if (val.contains(""+l)) readonly = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}


	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
	
	public String getTitolo() {
		if (segnalazione==null) return "Nuova segnalazione";
		
		return "Segnalazione "+segnalazione.getId();
	}
	
	public String getDataEvento() {
		if (segnalazione==null) return sdf.format(new Date());
		if (segnalazione.getDataEvento()==null) return "";
		return sdf.format(segnalazione.getDataEvento());
	}
	
	public String getDescrizione() {
		if (segnalazione==null) return "";
		return segnalazione.getDescrizione();
	}
	
	public String getNote() {
		if (segnalazione==null) return "";
		return segnalazione.getNote();
	}
	
	public String getEnte() {
		if (segnalazione==null) return "";
		return segnalazione.getEnteSegnalante();
	}
	
	public long getCategoria() {
		if (segnalazione==null) return 0;
		return segnalazione.getCategoria();
	}
	
	public long getEff() {
		if (segnalazione==null) return 0;
		return segnalazione.getEffetti();
	}
	
	public long getEffSub() {
		if (segnalazione==null) return 0;
		return segnalazione.getEffettiSub();
	}
	
	public long getSottocategoria() {
		if (segnalazione==null) return 0;
		return segnalazione.getSottocategoria();
	}
	
	public long getFonte() {
		if (segnalazione==null) return 0;
		return segnalazione.getFonte();
	}
	
	public String getRiferimento() {
		if (segnalazione==null) return "";
		return segnalazione.getRiferimento();
	}
	
	public String getUsername() {
		if (segnalazione==null) return "";
		return segnalazione.getUserName();
	}
	
	public String getTipoDocumentoCollegato() {
		if (allertaCollegata==null) return "";
		if (allertaCollegata.getTipoAllerta()) return "A";
		else return "B";
	}
	
	public String getNumeroDocumentoCollegato() {
		if (allertaCollegata==null) return "";
		return (allertaCollegata.getNumero());
	}
	
	public String getProvincia() {
		if (segnalazione==null) return "";
		return segnalazione.getProvincia();
	}
	
	public String getComune() {
		if (segnalazione==null) return "";
		return segnalazione.getComune();
	}
	
	public String getIndirizzo() {
		if (segnalazione==null) return "";
		return segnalazione.getIndirizzo();
	}
	
	public String getCivico() {
		if (segnalazione==null) return "";
		return segnalazione.getCivico();
	}

	
	public void salva() {
		if (segnalazione==null) {
			Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica("select coalesce(max(id_)+1,1) as sq from catasto_segnalazione");
			id = Long.parseLong(o.toString());
			segnalazione = SegnalazioneLocalServiceUtil.createSegnalazione(id);
			SegnalazioneLocalServiceUtil.addSegnalazione(segnalazione);
			//id = segnalazione.getId();  
		}
		
		try {
			User u = PortalUtil.getUser(httpRequest);
			if (u!=null) segnalazione.setUserName(u.getFirstName()+" "+u.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		segnalazione.setDescrizione(ParamUtil.getString(httpRequest, "descrizione"));
		segnalazione.setNote(ParamUtil.getString(httpRequest, "note"));
		segnalazione.setEnteSegnalante(ParamUtil.getString(httpRequest, "ente"));
		//segnalazione.setRiferimento(ParamUtil.getString(httpRequest, "riferimento"));
		
		segnalazione.setProvincia(ParamUtil.getString(httpRequest, "provincia"));
		segnalazione.setComune(ParamUtil.getString(httpRequest, "comune"));
		segnalazione.setIndirizzo(ParamUtil.getString(httpRequest, "indirizzo"));
		segnalazione.setCivico(ParamUtil.getString(httpRequest, "civico"));
		if (segnalazione.getComune()!=null) {
			segnalazione.setArea("");
			String match = segnalazione.getComune().toUpperCase();
			for (Object[] x : comuni) {
				if (x[0].toString().equals(match)) {
					segnalazione.setArea(x[1].toString());
					break;
				}
			}
		}
		
		segnalazione.setFonte(ParamUtil.getLong(httpRequest, "fonte"));
		segnalazione.setSottocategoria(ParamUtil.getLong(httpRequest, "categoria"));
		for (Sottocategoria sc : sottocategorie) {
			if (sc.getId()==segnalazione.getSottocategoria())
				segnalazione.setCategoria(sc.getIdCategoria());
		}
		//segnalazione.setCategoria(categoria);
		segnalazione.setEffetti(ParamUtil.getLong(httpRequest, "effetti"));
		segnalazione.setEffettiSub(ParamUtil.getLong(httpRequest, "effettiSub"));
		
		segnalazione.setLat(ParamUtil.getDouble(httpRequest, "lati"));
		segnalazione.setLon(ParamUtil.getDouble(httpRequest, "longi"));
		
		try {
			String dataEvento = ParamUtil.getString(httpRequest, "dataInizio");
			if (dataEvento==null || "".equals(dataEvento)) segnalazione.setDataEvento(null);
			else {
				dataEvento = dataEvento.split(" ")[0];
				dataEvento = dataEvento.trim();
				segnalazione.setDataEvento(sdf.parse(dataEvento));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			segnalazione.setDocumentoAssociato(0);
			/*String tipodoc = ParamUtil.getString(httpRequest, "tipodoc");
			String numerodoc = ParamUtil.getString(httpRequest, "numerodoc");
			if (numerodoc==null) numerodoc = "";
			if (tipodoc!=null && !tipodoc.equals("")) {
				List<Allerta> all = AllertaLocalServiceUtil.dynamicQuery(AllertaLocalServiceUtil.dynamicQuery().add(PropertyFactoryUtil.forName("stato").eq(0))
				.add(PropertyFactoryUtil.forName("numero").eq(numerodoc.trim()))
				.add(PropertyFactoryUtil.forName("tipoAllerta").eq("A".equals(tipodoc))));
				if (all==null || all.size()==0) segnalazione.setDocumentoAssociato(0);
				else segnalazione.setDocumentoAssociato(all.get(0).getAllertaId());
				
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		SegnalazioneLocalServiceUtil.updateSegnalazione(segnalazione);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Segnalazione getSegnalazione() {
		return segnalazione;
	}

	public void setSegnalazione(Segnalazione segnalazione) {
		this.segnalazione = segnalazione;
	}

	public List<Object[]> getComuni() {
		return comuni;
	}

	public void setComuni(List<Object[]> comuni) {
		this.comuni = comuni;
	}

	public List<Sottocategoria> getSottocategorie() {
		return sottocategorie;
	}

	public void setSottocategorie(List<Sottocategoria> sottocategorie) {
		this.sottocategorie = sottocategorie;
	}

	public List<Effetti> getEffetti() {
		return effetti;
	}

	public void setEffetti(List<Effetti> effetti) {
		this.effetti = effetti;
	}

	public List<EffettiSub> getEffettiSub() {
		return effettiSub;
	}

	public void setEffettiSub(List<EffettiSub> effettiSub) {
		this.effettiSub = effettiSub;
	}
	
	public Double getLat() {
		if (segnalazione==null) return 44.494887;
		return segnalazione.getLat();
	}
	
	public Double getLon() {
		if (segnalazione==null) return 11.3426163;
		return segnalazione.getLon();
	}
	
	public Double getLatVera() {
		if (segnalazione==null) return null;
		return segnalazione.getLat();
	}
	
	public Double getLonVera() {
		if (segnalazione==null) return null;
		return segnalazione.getLon();
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	
	

}
