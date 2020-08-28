package it.eng.rubrica.portlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaLog;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.RubricaRuolo;
import it.eng.allerte.model.RubricaUtenteSito;
import it.eng.allerte.service.RubricaCanaleLocalServiceUtil;
import it.eng.allerte.service.RubricaContattoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.RubricaLogLocalServiceUtil;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.RubricaRuoloLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiUtil;

@Component(immediate = true, property = { "osgi.http.whiteboard.context.path=/",
		"osgi.http.whiteboard.servlet.pattern=/rubrica/upload/*" }, service = Servlet.class)
public class UploadGruppoServlet extends HttpServlet {

	public static final long AMMINISTRATORE_RUBRICA = 233866;
	public static final long AMMINISTRATORE_PORTALE = 168321L;
	public static final long ADMIN = 20161;
	public static final long SINDACO = 29574;
	public static final long DELEGATO_TOTALE = 75902;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public class ContattoChange {
		public Long old;
		public String oldContatto;
		public long oldCanale;
		public String contatto;
		public long canale;
		public String nomeCanale;

		public String decisione = "NOTHING";

		public Long getOld() {
			return old;
		}

		public void setOld(Long old) {
			this.old = old;
		}

		public String getOldContatto() {
			return oldContatto;
		}

		public void setOldContatto(String oldContatto) {
			this.oldContatto = oldContatto;
		}

		public long getOldCanale() {
			return oldCanale;
		}

		public void setOldCanale(long oldCanale) {
			this.oldCanale = oldCanale;
		}

		public String getContatto() {
			return contatto;
		}

		public void setContatto(String contatto) {
			this.contatto = contatto;
		}

		public long getCanale() {
			return canale;
		}

		public void setCanale(long canale) {
			this.canale = canale;
		}

		public String getDecisione() {
			return decisione;
		}

		public void setDecisione(String decisione) {
			this.decisione = decisione;
		}

		public String getNomeCanale() {
			return nomeCanale;
		}

		public void setNomeCanale(String nomeCanale) {
			this.nomeCanale = nomeCanale;
		}
		
		
		
		
	}

	public class NominativoChange {
		public Long old;
		public long oldRuolo;
		public String oldSpecifica;
		public String oldNome;
		public String oldCognome;
		public String oldIndirizzo;
		public int gruppiAppartenenza;
		public String nomiGruppiAppartenenza;
		public Long gruppo;
		public String nomeGruppo;
		public String nome;
		public String cognome;
		public String specifica;
		public String indirizzo;
		public long ruolo = -1;
		public String oldNomeRuolo;
		public String nomeRuolo;
		public List<ContattoChange> contatti;
		public boolean chiedi = false;
		public boolean risposta = false;

		public String decisione = "NOTHING";
		
		

		public String getNomeGruppo() {
			return nomeGruppo;
		}

		public void setNomeGruppo(String nomeGruppo) {
			this.nomeGruppo = nomeGruppo;
		}

		public String getOldNomeRuolo() {
			return oldNomeRuolo;
		}

		public void setOldNomeRuolo(String oldNomeRuolo) {
			this.oldNomeRuolo = oldNomeRuolo;
		}

		public String getNomeRuolo() {
			return nomeRuolo;
		}

		public void setNomeRuolo(String nomeRuolo) {
			this.nomeRuolo = nomeRuolo;
		}

		public Long getOld() {
			return old;
		}

		public void setOld(Long old) {
			this.old = old;
		}

		public long getOldRuolo() {
			return oldRuolo;
		}

		public void setOldRuolo(long oldRuolo) {
			this.oldRuolo = oldRuolo;
		}

		public String getOldSpecifica() {
			return oldSpecifica;
		}

		public void setOldSpecifica(String oldSpecifica) {
			this.oldSpecifica = oldSpecifica;
		}

		public String getOldNome() {
			return oldNome;
		}

		public void setOldNome(String oldNome) {
			this.oldNome = oldNome;
		}

		public String getOldCognome() {
			return oldCognome;
		}

		public void setOldCognome(String oldCognome) {
			this.oldCognome = oldCognome;
		}

		public String getOldIndirizzo() {
			return oldIndirizzo;
		}

		public void setOldIndirizzo(String oldIndirizzo) {
			this.oldIndirizzo = oldIndirizzo;
		}

		public int getGruppiAppartenenza() {
			return gruppiAppartenenza;
		}

		public void setGruppiAppartenenza(int gruppiAppartenenza) {
			this.gruppiAppartenenza = gruppiAppartenenza;
		}

		public String getNomiGruppiAppartenenza() {
			return nomiGruppiAppartenenza;
		}

		public void setNomiGruppiAppartenenza(String nomiGruppiAppartenenza) {
			this.nomiGruppiAppartenenza = nomiGruppiAppartenenza;
		}

		public Long getGruppo() {
			return gruppo;
		}

		public void setGruppo(Long gruppo) {
			this.gruppo = gruppo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getSpecifica() {
			return specifica;
		}

		public void setSpecifica(String specifica) {
			this.specifica = specifica;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		public long getRuolo() {
			return ruolo;
		}

		public void setRuolo(long ruolo) {
			this.ruolo = ruolo;
		}

		public List<ContattoChange> getContatti() {
			return contatti;
		}

		public void setContatti(List<ContattoChange> contatti) {
			this.contatti = contatti;
		}

		public boolean isChiedi() {
			return chiedi;
		}

		public void setChiedi(boolean chiedi) {
			this.chiedi = chiedi;
		}

		public boolean isRisposta() {
			return risposta;
		}

		public void setRisposta(boolean risposta) {
			this.risposta = risposta;
		}

		public String getDecisione() {
			return decisione;
		}

		public void setDecisione(String decisione) {
			this.decisione = decisione;
		}
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = null;		
		
		try {
			u = PortalUtil.getUser(req);
		} catch (Exception e) {
			return;
		}
		long userId = u.getUserId();
		long idSitoUtente = getIdSitoUtente(userId);
		
		boolean caricaFile = false;
		InputStream i=null;
		
		UploadServletRequest upl = PortalUtil.getUploadServletRequest(req);
		if (upl!=null) {
			i = upl.getFileAsStream("file");
			if (i!=null) caricaFile = true;
		}
		
		if (!caricaFile) {
			if (!req.getParameterMap().containsKey("comandi")) {
				byte[] b = "{risultato:\"ko:mancano comandi\"}".getBytes();
				resp.setStatus(501);
				resp.setContentLength(b.length);
				resp.getOutputStream().write(b);
				return;
			}
			Gson gson = new Gson();
			Type listOfTestObject = new TypeToken<List<NominativoChange>>(){}.getType();
			List<NominativoChange> list2 = gson.fromJson(req.getParameter("comandi"), listOfTestObject);
			resp.setContentType("application/json");
			resp.setStatus(200);
			
			try {
				String out = esegui(list2, u);
				

				byte[] b = ("{\"risultato\":\"ok\", \"note\":\""+out+"\"}").getBytes();
				resp.setContentLength(b.length);
				resp.getOutputStream().write(b);
			} catch (Exception e) {
				e.printStackTrace();
				byte[] b = ("{\"risultato\":\"ko\", \"note:\"ERRORE: "+e.getMessage()+"\"}").getBytes();
				resp.setContentLength(b.length);
				resp.getOutputStream().write(b);
			}
			return;
		}

		byte[] file = FileUtil.getBytes(i);
		i.close();

		List<RubricaCanale> canali = RubricaCanaleLocalServiceUtil.getRubricaCanali();
		List<RubricaRuolo> ruoli = RubricaRuoloLocalServiceUtil.getRubricaRuolos(-1, -1);

		Map<String, RubricaGruppo> gruppi = new HashMap<String, RubricaGruppo>();
		Map<String, List<NominativoChange>> gruppiChanges = new HashMap<String, List<NominativoChange>>();

		XSSFWorkbook wb = new XSSFWorkbook(new ByteArrayInputStream(file));
		XSSFSheet s = wb.getSheetAt(0);
		
		DataFormatter df = new DataFormatter();

		for (int k = 1; k <= s.getLastRowNum(); k++) {
			XSSFRow r = s.getRow(k);
			String grp = df.formatCellValue(r.getCell(0));
			
			if (grp==null || grp.equals("")) continue;
			
			String cog = df.formatCellValue(r.getCell(1));
			String nom = df.formatCellValue(r.getCell(2));
			String rl = df.formatCellValue(r.getCell(3));
			String spc = df.formatCellValue(r.getCell(4));
			String ind = df.formatCellValue(r.getCell(5));
			String tpc = df.formatCellValue(r.getCell(6));
			String cnt = df.formatCellValue(r.getCell(7));
			
			if (cog!=null) cog = cog.trim();
			if (nom!=null) nom = nom.trim();
			if (spc!=null) spc = spc.trim();
			if (ind!=null) ind = ind.trim();
			if (cnt!=null) cnt = cnt.trim();

			long ruolo = 0;
			String rl2 = (rl != null ? rl.toLowerCase().trim() : null);
			for (RubricaRuolo rr : ruoli) {
				if (rr.getDESCRIZIONE() != null && rl2 != null
						&& rl2.equals(rr.getDESCRIZIONE().toLowerCase().trim())) {
					ruolo = rr.getID_RUOLO();
					break;
				}
			}
			long canale = 0;
			String cn2 = (tpc != null ? tpc.toLowerCase().trim() : null);
			for (RubricaCanale rc : canali) {
				if (rc.getNOME() != null && cn2 != null && cn2.equals(rc.getNOME().toLowerCase().trim())) {
					canale = rc.getID_CANALE();
					break;
				}
			}

			if (!gruppi.containsKey(grp)) {
				RubricaGruppo rgg = gruppoDaNome(grp, idSitoUtente);
				if (rgg==null) continue;
				gruppi.put(grp, rgg);
			}
			RubricaGruppo gruppoRubrica = gruppi.get(grp);
			if (!gruppiChanges.containsKey(grp)) {
				gruppiChanges.put(grp, getNominativi(gruppoRubrica));
			}
			List<NominativoChange> chn = gruppiChanges.get(grp);

			// assegna questa riga a un nominativo esistente
			NominativoChange pair = findNominativo(chn, gruppoRubrica, cog, nom, canale, cnt);
			if (pair != null) {
				pair.nome = (nom != null ? nom.trim() : "");
				pair.cognome = (cog != null ? cog.trim() : "");
				pair.ruolo = ruolo;
				pair.nomeRuolo = rl;
				pair.specifica = (spc != null ? spc.trim() : "");
				pair.indirizzo = (ind != null ? ind.trim() : "");
				ContattoChange contattoTrovato = null;
				for (ContattoChange cc : pair.contatti) {
					RubricaContatto rubcon = cc.old != null
							? RubricaContattoLocalServiceUtil.fetchRubricaContatto(cc.old)
							: null;

					if (rubcon != null && rubcon.getCONTATTO().trim().toLowerCase().equals(cnt.trim().toLowerCase()))
						contattoTrovato = cc;
				}
				if (contattoTrovato != null) {
					contattoTrovato.canale = canale;
					contattoTrovato.contatto = (cnt != null ? cnt.trim() : "");
					contattoTrovato.nomeCanale = tpc;
				} else {
					ContattoChange cc2 = new ContattoChange();
					cc2.canale = canale;
					cc2.nomeCanale = tpc;
					cc2.oldContatto = (cnt != null ? cnt.trim() : "");
					cc2.contatto = (cnt != null ? cnt.trim() : "");
					pair.contatti.add(cc2);
				}
			} else {
				pair = new NominativoChange();
				pair.cognome = (cog != null ? cog.trim() : "");
				pair.nome = (nom != null ? nom.trim() : "");
				;
				pair.gruppiAppartenenza = 1;
				pair.gruppo = gruppoRubrica.getID_GRUPPO();
				pair.nomeGruppo = gruppoRubrica.getNOME();
				pair.indirizzo = (ind != null ? ind.trim() : "");
				pair.ruolo = ruolo;
				pair.oldNomeRuolo = "";
				pair.nomeRuolo = rl;
				pair.specifica = (spc != null ? spc.trim() : "");
				pair.nomiGruppiAppartenenza = "";
				pair.contatti = new ArrayList<UploadGruppoServlet.ContattoChange>();
				ContattoChange cc2 = new ContattoChange();
				cc2.canale = canale;
				cc2.nomeCanale = tpc;
				cc2.contatto = (cnt != null ? cnt.trim() : "");
				cc2.oldContatto = (cnt != null ? cnt.trim() : "");
				pair.contatti.add(cc2);
				
				chn.add(pair);
			}
		}

		// calcola la decisione
		List<NominativoChange> out = new ArrayList<UploadGruppoServlet.NominativoChange>();

		for (String g : gruppiChanges.keySet()) {
			for (NominativoChange nc : gruppiChanges.get(g)) {
				out.add(nc);
				if (nc.old == null) {
					nc.decisione = "INSERT";
					for (ContattoChange cc : nc.contatti)
						cc.decisione = "INSERT";
					continue;
				}
				if (nc.nome == null && nc.cognome == null && nc.ruolo == -1) {
					nc.decisione = "DELETE";
					for (ContattoChange cc : nc.contatti)
						cc.decisione = "DELETE";
					continue;
				}
				RubricaNominativo rubnom = nc.old != null
						? RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(nc.old)
						: null;
				if (!nc.nome.equals((rubnom.getNOME() != null ? rubnom.getNOME().trim() : "")))
					nc.decisione = "UPDATE";
				if (!nc.cognome.equals((rubnom.getCOGNOME() != null ? rubnom.getCOGNOME().trim() : "")))
					nc.decisione = "UPDATE";
				if (nc.ruolo != nc.oldRuolo)
					nc.decisione = "UPDATE";
				if (!nc.specifica.equals(nc.oldSpecifica != null ? nc.oldSpecifica.trim() : ""))
					nc.decisione = "UPDATE";
				if (!nc.indirizzo.equals(rubnom.getINDIRIZZO() != null ? rubnom.getINDIRIZZO().trim() : ""))
					nc.decisione = "UPDATE";

				for (ContattoChange cc : nc.contatti) {
					RubricaContatto rubcon = cc.old != null
							? RubricaContattoLocalServiceUtil.fetchRubricaContatto(cc.old)
							: null;

					if (rubcon == null) {
						cc.decisione = "INSERT";
						nc.decisione = "UPDATE";
						continue;
					}
					if (cc.contatto == null) {
						cc.decisione = "DELETE";
						nc.decisione = "UPDATE";
						continue;
					}
					if (cc.canale != rubcon.getFK_CANALE()) {
						cc.decisione = "UPDATE";
						nc.decisione = "UPDATE";
						continue;
					}
					if (!cc.contatto.equals(rubcon.getCONTATTO())) {
						cc.decisione = "UPDATE";
						nc.decisione = "UPDATE";
						continue;
					}
				}

				// considera quando chiedere la decisione dell'utente. Questo accade
				// quando è prevista una modifica a un nominativo presente in più gruppi
				if (!nc.decisione.equals("NOTHING") && nc.gruppiAppartenenza > 1)
					nc.chiedi = true;

				
			}
		}

		wb.close();

		resp.setContentType("application/json");
		resp.setStatus(200);
		
		out.sort(new Comparator<NominativoChange>() {
			public int compare(NominativoChange o1, NominativoChange o2) {
				if (o1.nomeGruppo==null) return 1;
				if (o2.nomeGruppo==null) return -1;
				int compare = o1.nomeGruppo.compareTo(o2.nomeGruppo);
				if (compare!=0) return compare;
				String c1 = o1.cognome;
				String c2 = o2.cognome;
				if (c1==null) c1 = o1.oldCognome;
				if (c2==null) c2 = o2.oldCognome;
				if (c1==null) return 1;
				if (c2==null) return -1;
				compare = c1.compareTo(c2);
				if (compare!=0) return compare;
				c1 = o1.nome;
				c2 = o2.nome;
				if (c1==null) c1 = o1.nome;
				if (c2==null) c2 = o2.nome;
				if (c1==null) return 1;
				if (c2==null) return -1;
				compare = c1.compareTo(c2);
				return compare;
			};
		});

		byte[] b = new Gson().toJson(out).getBytes();
		resp.setContentLength(b.length);

		resp.getOutputStream().write(b);
	}

	private String esegui(List<NominativoChange> l, User u) {
		
		String out = "";
		int n = 0;
		int c = 0;
		
		HashMap<Long,Boolean> gruppiModificati = new HashMap<Long, Boolean>();
		
		for (NominativoChange nc : l) {
			RubricaNominativo rubricaNominativo = null;
			if (nc.nomeGruppo!=null && nc.gruppo==null) {
				out +="Gruppo sconosciuto: "+nc.nomeGruppo+". ";
			}
			if (nc.nomeRuolo!=null && !nc.nomeRuolo.equals("") && nc.ruolo==0) {
				out+="Ruolo sconosciuto: "+nc.nomeRuolo+". ";
			}
			RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(nc.gruppo);
			if (rg==null) continue;
			else {
				gruppiModificati.put(rg.getID_GRUPPO(), true);
			}
			if (!"NOTHING".equals(nc.decisione)) n++;
			
			if (nc.decisione.equals("INSERT") || nc.decisione.equals("UPDATE")) {
				String veraDecisione = nc.decisione;

				// l'utente ha visto un nominativo che compare in più gruppi e ha scelto di
				// non salvarne una versione separata
				if (nc.chiedi && !nc.risposta) {
					//controlla se ci sono altre modifiche allo stesso nominativo nel seguito del file di importazione; nel qual caso queste sono
					//inutili perché verrebbero sovrascritte.
					for (int k=l.size()-1; k>=0; k--) {
						NominativoChange nomi = l.get(k);
						if (nomi==nc) break;
						if (nomi.old==nc.old && nomi.chiedi && !nc.risposta) {
							veraDecisione = "NOTHING";
							break;
						}
					}
				}
				
				if (veraDecisione.equals("NOTHING")) { n--; continue; }
				
				if (veraDecisione.equals("UPDATE") && nc.chiedi && nc.risposta) {
					veraDecisione = "INSERT";
					
					try {
					RubricaGruppoNominativiLocalServiceUtil.deleteRubricaGruppoNominativi(new RubricaGruppoNominativiPK(rg.getID_GRUPPO(), nc.old));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (veraDecisione.equals("INSERT")) {
					rubricaNominativo = RubricaNominativoLocalServiceUtil.createRubricaNominativo(0);
					rubricaNominativo
							.setID_NOMINATIVO(CounterLocalServiceUtil.increment(RubricaNominativo.class.getName()));
				} else
					rubricaNominativo = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(nc.old);
				rubricaNominativo.setCOGNOME(nc.cognome);
				rubricaNominativo.setNOME(nc.nome);
				rubricaNominativo.setINDIRIZZO(nc.indirizzo);
				rubricaNominativo.setFK_SITO_PROPRIETARIO(rg.getFK_SITO_PROPRIETARIO());
				rubricaNominativo.setFK_UTENTE_PORTALE(0); // //Al momento abbiamo detto non serve questa info, lo setto
															// sempre a 0

				// Setto le date di creazione e modifica in inserimento saranno le stesse

				if (veraDecisione.equals("INSERT")) {
					rubricaNominativo.setDATA_CREAZIONE(new Date());
					rubricaNominativo.setFK_UTENTE_CREAZIONE(u.getUserId());
				}

				// e setto l'utente che sta creando il contatto
				// setto anche quello di modifica uguale a quello di creazione in questa fase
				rubricaNominativo.setFK_UTENTE_MODIFICA(u.getUserId());
				rubricaNominativo.setDATA_MODIFICA(new Date());
				rubricaNominativo.setMODIFICA_MINORE(false);

				RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rubricaNominativo);

				// Logga operazione in RUBRICA_LOG
				aggiornaRubricaLog("RubricaNominativo", String.valueOf(rubricaNominativo.getID_NOMINATIVO()),
						veraDecisione, rubricaNominativo.toString(), u.getUserId());
				// logger.info("inserisciNominativo2");
				// logger.info("inserisciNominativo3");
				if (veraDecisione.equals("INSERT")) {
					RubricaGruppoNominativi rgn = RubricaGruppoNominativiLocalServiceUtil.createRubricaGruppoNominativi(
							new RubricaGruppoNominativiPK(rg.getID_GRUPPO(), rubricaNominativo.getID_NOMINATIVO()));
					rgn.setFK_NOMINATIVO(rubricaNominativo.getID_NOMINATIVO());
					rgn.setFK_GRUPPO(rg.getID_GRUPPO());
					rgn.setFK_RUOLO(nc.ruolo);
					rgn.setSPECIFICA_RUOLO(nc.specifica);
					RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(rgn);
				

				
				} else {
					
					RubricaGruppoNominativi rgn2 = RubricaGruppoNominativiLocalServiceUtil.fetchRubricaGruppoNominativi(
							new RubricaGruppoNominativiPK(rg.getID_GRUPPO(), rubricaNominativo.getID_NOMINATIVO()));
					if (rgn2 != null) {
						rgn2.setFK_RUOLO(nc.ruolo);
						rgn2.setSPECIFICA_RUOLO(nc.specifica);
						RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(rgn2);
					}
					
				}

				for (ContattoChange cc : nc.contatti) {
					RubricaContatto rc = null;
					String decisioneV2 = cc.decisione;
					c++;
					/*if (decisioneV2.equals("UPDATE") && veraDecisione.equals("INSERT"))
						decisioneV2 = "INSERT"; // stiamo duplicando il nominativo
					else if (decisioneV2.equals("DELETE") && veraDecisione.equals("INSERT"))
						decisioneV2 = "NOTHING"; // stiamo duplicando il nominativo, ignora
					else if (decisioneV2.equals("NOTHING") && veraDecisione.equals("INSERT"))
						decisioneV2 = "INSERT";
					else if (veraDecisione.equals("DELETE")) {
						decisioneV2 = "NOTHING";
					}*/
					
					if (decisioneV2.equals("NOTHING"))
						continue;

					if (decisioneV2.equals("DELETE")) {
						rc = RubricaContattoLocalServiceUtil.fetchRubricaContatto(cc.old);
						if (rc != null) {
							rc.setDATA_FINE_VALIDITA(new Date());
							rc.setDATA_MODIFICA(new Date());
							rc.setFK_UTENTE_MODIFICA(u.getUserId());
							rc.setMODIFICA_MINORE(false);
							RubricaContattoLocalServiceUtil.updateRubricaContatto(rc);
							aggiornaRubricaLog("RubricaContatto", String.valueOf(rc.getID_CONTATTO()), "DELETE",
									rc.toString(), u.getUserId());

						}
						continue;
					}

					if (decisioneV2.equals("INSERT")) {
						rc = RubricaContattoLocalServiceUtil.createRubricaContatto(0);
						rc.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
						rc.setDATA_CREAZIONE(new Date());
						rc.setFK_UTENTE_CREAZIONE(u.getUserId());
						rc.setALLERTAMENTO(true);
						rc.setFK_NOMINATIVO(rubricaNominativo.getID_NOMINATIVO());

					} else
						rc = RubricaContattoLocalServiceUtil.fetchRubricaContatto(cc.old);
					rc.setMODIFICA_MINORE(false);
					rc.setDATA_MODIFICA(new Date());
					rc.setFK_UTENTE_MODIFICA(u.getUserId());
					rc.setFK_CANALE(cc.canale);
					rc.setCONTATTO(cc.contatto);
					RubricaContattoLocalServiceUtil.updateRubricaContatto(rc);
					aggiornaRubricaLog("RubricaContatto", String.valueOf(rc.getID_CONTATTO()), decisioneV2,
							rc.toString(), u.getUserId());

				}
			}

			// se lo vuoi rimuovere, oppure se ne vogliamo fare una copia separata solo per
			// questo gruppo
			if (nc.decisione.equals("DELETE")
					|| (nc.decisione.equals("UPDATE") && nc.gruppiAppartenenza > 1 && nc.chiedi && nc.risposta)) {
				if (nc.gruppiAppartenenza == 1) {
					// se apparteneva solo a questo, disabilitalo
					RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(nc.old);
					if (rn != null) {
						rn.setDATA_MODIFICA(new Date());
						rn.setDISABLED(true);
						rn.setMODIFICA_MINORE(false);
						rn.setFK_UTENTE_MODIFICA(u.getUserId());
						RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rn);
						aggiornaRubricaLog("RubricaNominativo", String.valueOf(rn.getID_NOMINATIVO()), "DELETE",
								rn.toString(), u.getUserId());
						

					}
				} else {  
					// spegnilo solo dal gruppo
					rubricaNominativo = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(nc.old);
					RubricaGruppoNominativi rgn = RubricaGruppoNominativiLocalServiceUtil.fetchRubricaGruppoNominativi(
							new RubricaGruppoNominativiPK(rg.getID_GRUPPO(), rubricaNominativo.getID_NOMINATIVO()));
					if (rgn != null) {
						aggiornaRubricaLog("RubricaGruppoNominativi", String.valueOf(rgn.getPrimaryKey()), "DELETE",
								rgn.toString(), u.getUserId());
						RubricaGruppoNominativiLocalServiceUtil.deleteRubricaGruppoNominativi(rgn);

					}
				}
			}
		}
		
		//aggiorna le date di modifica dei contatti
		for (Long gruppo : gruppiModificati.keySet()) {
			RubricaGruppoLocalServiceUtil.aggiornaTuttoGruppo(gruppo);
		}
		
		return "Elaborati "+n+" nominativi e "+c+" contatti. " + out;
	}

	public static Long getIdSitoUtente(Long userId) {
		if (userId == null)
			return null;

		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_RUBRICA))
			return 20181L;
		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_PORTALE))
			return 20181L;
		if (RoleLocalServiceUtil.hasUserRole(userId, ADMIN))
			return 20181L;

		List<Group> groups = GroupLocalServiceUtil.getUserGroups(userId);
		for (Group g : groups) {
			if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), SINDACO)
					|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), DELEGATO_TOTALE))
				return g.getGroupId();
		}

		RubricaUtenteSito rus = RubricaUtenteSitoLocalServiceUtil.fetchRubricaUtenteSito(userId);
		if (rus != null)
			return rus.getID_SITO();
		return null;
	}

	private RubricaGruppo gruppoDaNome(String nome, long sito) {
		return RubricaGruppoLocalServiceUtil.getGroupForOwnerByName(sito, nome);
	}


	private NominativoChange findNominativo(List<NominativoChange> changes, RubricaGruppo rg, String cognome,
			String nome, long tipoContatto, String contatto) {
		if (nome != null)
			nome = nome.toLowerCase().trim();
		if (cognome != null)
			cognome = cognome.toLowerCase().trim();
		// cerca prima tra i nuovi e vecchi modificati (per evitare conflitti
		// decisionali tra due contatti dello stesso nominativo)
		for (NominativoChange nc : changes) {
			if (nc.old != null && (nc.cognome == null || nc.nome == null))
				continue;
			if (nc.gruppo != rg.getID_GRUPPO())
				continue;
			String n = nc.nome;
			if (n != null)
				n = n.toLowerCase().trim();
			String c = nc.cognome;
			if (c != null)
				c = c.toLowerCase().trim();
			if ((n == null || n.equals(nome)) && (c == null || c.equals(cognome)))
				return nc; // match sul nome/cognome
			/*for (ContattoChange cc : nc.contatti) {
				if (cc.canale == tipoContatto && cc.contatto.trim().toLowerCase().equals(contatto))
					return nc; // match sul contatto
			}*/
		}
		// cerca tra i vecchi
		for (NominativoChange nc : changes) {
			if (nc.old == null)
				continue;
			RubricaNominativo rubnom = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(nc.old);
			if (nc.gruppo != rg.getID_GRUPPO())
				continue;
			String n = rubnom.getNOME();
			if (n != null)
				n = n.toLowerCase().trim();
			String c = rubnom.getCOGNOME();
			if (c != null)
				c = c.toLowerCase().trim();
			if ((n == null || n.equals(nome)) && (c == null || c.equals(cognome)))
				return nc; // match sul nome/cognome
			/*for (ContattoChange cc : nc.contatti) {
				RubricaContatto rubcon = cc.old != null ? RubricaContattoLocalServiceUtil.fetchRubricaContatto(cc.old)
						: null;

				if (rubcon != null && rubcon.getFK_CANALE() == tipoContatto
						&& rubcon.getCONTATTO().trim().toLowerCase().equals(contatto))
					return nc; // match sul contatto
			}*/
		}

		return null;
	}

	private List<NominativoChange> getNominativi(RubricaGruppo gruppo) {
		List<Object[]> oggetti = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(gruppo.getID_GRUPPO(),
				gruppo.getFK_SITO_PROPRIETARIO());
		List<NominativoChange> out = new ArrayList<UploadGruppoServlet.NominativoChange>();

		for (Object[] o : oggetti) {
			NominativoChange nc = new NominativoChange();
			out.add(nc);
			nc.gruppo = gruppo.getID_GRUPPO();
			nc.nomeGruppo = gruppo.getNOME();
			RubricaNominativo rubnom = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo((Long) o[1]);
			nc.old = rubnom != null ? rubnom.getID_NOMINATIVO() : null;
			if (o[2]!=null) nc.oldRuolo = (Long) o[2];
			if (nc.oldRuolo>=0) nc.oldNomeRuolo = RubricaRuoloLocalServiceUtil.fetchRubricaRuolo(nc.oldRuolo).getDESCRIZIONE();
			nc.oldSpecifica = (String) o[3];
			nc.oldNome = rubnom.getNOME();
			nc.oldCognome = rubnom.getCOGNOME();
			nc.oldIndirizzo = rubnom.getINDIRIZZO();
			
			if (nc.oldNome!=null) nc.oldNome = nc.oldNome.trim();
			if (nc.oldCognome!=null) nc.oldCognome = nc.oldCognome.trim();
			if (nc.oldSpecifica!=null) nc.oldSpecifica = nc.oldSpecifica.trim();
			if (nc.oldIndirizzo!=null) nc.oldIndirizzo = nc.oldIndirizzo.trim();
			
			
			nc.contatti = new ArrayList<UploadGruppoServlet.ContattoChange>();
			ArrayList<Object[]> c = RubricaContattoLocalServiceUtil.loadByNominativo(rubnom.getID_NOMINATIVO());
			for (Object[] con : c) {
				ContattoChange cc = new ContattoChange();
				RubricaContatto rubcon = RubricaContattoLocalServiceUtil.fetchRubricaContatto((Long) con[0]);
				cc.old = rubcon != null ? rubcon.getID_CONTATTO() : null;
				cc.oldCanale = rubcon.getFK_CANALE();
				cc.oldContatto = rubcon.getCONTATTO();
				cc.nomeCanale = RubricaCanaleLocalServiceUtil.fetchRubricaCanale(rubcon.getFK_CANALE()).getNOME();
				nc.contatti.add(cc);
			}
			List<RubricaGruppoNominativi> rr = RubricaGruppoNominativiLocalServiceUtil
					.findByRubricaGruppoRuoloByNominativo(rubnom.getID_NOMINATIVO());
			nc.gruppiAppartenenza = rr.size();
			nc.nomiGruppiAppartenenza = "";
			for (RubricaGruppoNominativi rgn : rr) {
				if (rgn.getFK_GRUPPO() != gruppo.getID_GRUPPO()) {
					nc.nomiGruppiAppartenenza += RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(rgn.getFK_GRUPPO())
							.getNOME() + "; ";
				}
			}

		}

		return out;
	}

	private void aggiornaRubricaLog(String nomeTabella, String idOggetto, String tipoOperazione, String value,
			long creatorUserId) throws SystemException {

		// Creo oggetto di Log
		RubricaLog rubricaLog = creaRubricaLog(nomeTabella, idOggetto, tipoOperazione, value, creatorUserId,
				new Date());
		// e lo inserisco
		inserimentoRubricaLog(rubricaLog);
	}

	public RubricaLog creaRubricaLog(String nomeTabella, String idOggetto, String tipoOperazione,
			String nuovaDescrizione, Long userId, Date dataModifica) {

		RubricaLog rubricaLog = RubricaLogLocalServiceUtil.createRubricaLog(0);

		rubricaLog.setDATA_MODIFICA(dataModifica);
		rubricaLog.setFK_SITO_PROPRIETARIO(20181);
		rubricaLog.setFK_UTENTE_MODIFICA(userId);
		rubricaLog.setID_OGGETTO(idOggetto);
		rubricaLog.setNUOVA_DESCRIZIONE(nuovaDescrizione);
		rubricaLog.setTABELLA(nomeTabella);
		rubricaLog.setTIPO_OPERAZIONE(tipoOperazione);

		return rubricaLog;
	}

	public void inserimentoRubricaLog(RubricaLog rubricaLog) throws SystemException {
		// setto l'id
		rubricaLog.setID_LOG(CounterLocalServiceUtil.increment(RubricaLog.class.getName()));

		RubricaLogLocalServiceUtil.updateRubricaLog(rubricaLog);

	}
}
