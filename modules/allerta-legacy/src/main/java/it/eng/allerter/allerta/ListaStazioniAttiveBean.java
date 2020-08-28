package it.eng.allerter.allerta;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;

import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.service.BacinoLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;


public class ListaStazioniAttiveBean implements Serializable {

	List<Bacino> bacini;
	List<StazioneManager> stazioni;
	List<SelectItem> selectItems;
	
	public class StazioneManager implements Serializable {
		
		Stazione stazione;
		String bacino;
		int progressivo;
		boolean incluso;
		public Stazione getStazione() {
			return stazione;
		}
		public void setStazione(Stazione stazione) {
			this.stazione = stazione;
		}
		public String getBacino() {
			return bacino;
		}
		public void setBacino(String bacino) {
			this.bacino = bacino;
		}
		public int getProgressivo() {
			return progressivo;
		}
		public void setProgressivo(int progressivo) {
			this.progressivo = progressivo;
		}
		public boolean isIncluso() {
			return incluso;
		}
		public void setIncluso(boolean incluso) {
			this.incluso = incluso;
		}
		
		
	}
	
	
	public ListaStazioniAttiveBean() {
		
		init();
		
	}
	
	public void init() {
		
		try {
			bacini = BacinoLocalServiceUtil.getBacinos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			List<Stazione> sv = new ArrayList<Stazione>();
			
			try {
				
			
			List<Stazione> tutte = StazioneLocalServiceUtil.getStaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			boolean aggiunto;
			
			for (Stazione s : tutte) {
				
				
				
				if (s.getProgressivo()<=0) continue;
				
				//System.out.println("Stazione "+s.getProgressivo());
				
				/*for (int k=0; k<sv.size(); k++) {
					if (!aggiunto && s.getProgressivo()<sv.get(k).getProgressivo()) {
						sv.add(k, s);
						aggiunto = true;
					}
				}
				
				if (!aggiunto) sv.add(sv.size(), s);*/
				
				sv.add(s);
				
			}
			
			} catch (Exception ex) {
				
				System.out.println(ex.getStackTrace()[0].toString());
				
				try {
					File f = new File("C:\\Users\\GFAVINI\\Documents\\Liferay\\liferay-portal-6.2-ce-ga6\\logs\\stazioni.txt");
					f.createNewFile();
					PrintWriter pw = new PrintWriter(f);
					ex.printStackTrace(pw);
					pw.flush();
					pw.close();
				} catch (Exception ex2) {
					ex2.printStackTrace();
				}
			}
			
			System.out.println("Stazioni "+sv.size());
			
			/*DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(Stazione.class)
					.add(PropertyFactoryUtil.forName("id").in(
							DynamicQueryFactoryUtil.forClass(StazioneVariabile.class)
							.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"))
							.add(PropertyFactoryUtil.forName("progressivo").gt(0))
							.setProjection(ProjectionFactoryUtil.property("idStazione"))))
					.addOrder(OrderFactoryUtil.asc("nameBasin")).addOrder(OrderFactoryUtil.asc("progressivo"));
			List<Stazione> sv = StazioneLocalServiceUtil.dynamicQuery(dyn);
			*/
			stazioni = new ArrayList<ListaStazioniAttiveBean.StazioneManager>();
			
			for (Stazione s : sv) {
				
				StazioneManager sm = new StazioneManager();
				stazioni.add(sm);
				
				sm.stazione = s;
				sm.progressivo = (s.getProgressivo() % 1000);
				sm.bacino = "----";
				sm.incluso = sm.stazione.getIncluso();
				if (s.getProgressivo()==0)
					for (Bacino b : bacini) {
						//if (b.getNome().equals(sm.stazione.getNameBasin())) sm.bacino = b.getId();
					}
				//else sm.bacino = bacini.get((s.getProgressivo() / 1000)-1).getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Bacino> getBacini() {
		return bacini;
	}


	public void setBacini(List<Bacino> bacini) {
		this.bacini = bacini;
	}


	public List<StazioneManager> getStazioni() {
		return stazioni;
	}


	public void setStazioni(List<StazioneManager> stazioni) {
		this.stazioni = stazioni;
	}


	public List<SelectItem> getSelectItems() {
		
		if (selectItems==null) {
			
			selectItems = new ArrayList<SelectItem>();
			
			selectItems.add(new SelectItem("----","----"));
			
			for (Bacino b : bacini) {
				
				SelectItem si = new SelectItem(b.getId(),b.getNome());
				selectItems.add(si);
				
			}
			
		}
		
		return selectItems;
	}


	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	
	public void annulla() {
		init();
	}
	
	public void salva() {
		
		for (StazioneManager s : stazioni) {
			
			/*if (!s.incluso) {
				s.bacino = "----";
				s.progressivo = 0;
			}*/
			
			s.stazione.setIncluso(s.incluso);
			
			/*
			int bac = 0;
			
			if (!s.bacino.equals("----")) {
				
				for (int k=0; k<bacini.size(); k++)
					if (s.bacino.equals(bacini.get(k).getId())) bac = k;
				
				
				s.stazione.setProgressivo((bac+1)*1000+s.progressivo);
			}
			else
				s.stazione.setProgressivo(0);
			*/
			try {
				StazioneLocalServiceUtil.updateStazione(s.stazione);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
		}
		
	}
	
	
}
