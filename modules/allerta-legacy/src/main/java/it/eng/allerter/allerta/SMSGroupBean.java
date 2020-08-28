 package it.eng.allerter.allerta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class SMSGroupBean implements Serializable {
	
	
	private Date myDataDa;
	private Date myDataA;
	private int pageSize = 30;
	private int pageSizeDettaglio = 50000;
	private String dettaglio;
	private String downloadLink;
	private String nomeEvento;
	private boolean soloFalliti = false;
	
	private List sms;
	private List smsDettaglio;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	

	private String testo;
	private String testoDettaglio;
	
	private int getNumeroRighe() {
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(getRigheQuery(0,0,true));
		if (o==null) return 0;
		return Integer.parseInt(o.toString());
	}
	
	private int getNumeroRigheDettaglio() {
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(getRigheDettaglioQuery(0,0,true));
		if (o==null) return 0;
		return Integer.parseInt(o.toString());
	}
	
	public void dettaglio(HttpServletRequest req) {
		try {
		dettaglio = ParamUtil.getString(req, "id"); 
		nomeEvento = ParamUtil.getString(req, "nome");
		
		smsDettaglio = null;
		//LogInternoLocalServiceUtil.log("SMSGroupBean", "dettaglio", dettaglio, "");

		} catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("SMSGroupBean","dettaglio",ex,"");
		}

	}
	
	public void esciDettaglio() {
		dettaglio = null;
		nomeEvento = null;
	}
	
	public void aggiornaPagina() {
		sms = null;
		smsDettaglio = null;
	}
	
	private String getRigheQuery(int begin, int end, boolean count) {
		int num = end-begin;
		String q = "select "+(count?"count(*)":"*")+" from sms_invii_vw where 1=1 ";
		
		if (myDataDa!=null) {
			q+=" and creazione>='"+sdf.format(myDataDa)+"'";
		}
		
		if (myDataA!=null) {
			q+=" and creazione<='"+sdf.format(myDataA)+"'";
		}
		
		if (testo!=null && !testo.equals("")) {
			String t = "'%"+testo.toUpperCase()+"%'";
			q+=" and(upper(evento) like "+t+" or upper(tipo_evento) like "+t+")";
		}
		
		if (!count) {
			q+=" limit "+num;
			if (begin>0) q+= " offset "+begin;
		}
		
		return q;
	}
	
	private String getRigheDettaglioQuery(int begin, int end, boolean count) {
		int num = end-begin;
		String q = "select "+(count?"count(*)":"*")+" from sms_dettaglio_vw where id='"+dettaglio+"' ";
		
		if (testoDettaglio!=null && !testoDettaglio.equals("")) {
			String t = "'%"+testoDettaglio.toUpperCase()+"%'";
			q+=" and(upper(nomedestinatario) like "+t+" or upper(numero) like "+t+" or upper(nomestato) like "+t+")";
		}
		
		if (soloFalliti) {
			q+=" and not destinatario_ricevuto ";
		}
		
		if (!count) {
			q+=" limit "+num;
			if (begin>0) q+= " offset "+begin;
		}
		
		return q;
	}
	
	private List getRighe(int begin, int end) {
		return BollettinoLocalServiceUtil.eseguiQueryGenericaLista(getRigheQuery(begin,end,false));
	}
	
	private List getRigheDettaglio(int begin, int end) {
		try {
		return BollettinoLocalServiceUtil.eseguiQueryGenericaLista(getRigheDettaglioQuery(begin,end,false));
	
		} catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("SMSGroupBean","getRigheDettaglio",ex,"");
			return null;
		}

	}
	public int getCarica() {
		
		
		return 0;
		
	}
	
	public void setCarica(int i) {
		
	}
	
	
	public void updateList() {
		sms = null;
	}
	
	public void updateListDettaglio() {
		smsDettaglio = null;
	}

	public List getSms() {
		
		if (sms==null) {
			
			sms = new LazyList(pageSize,getNumeroRighe())
			 {
				public List getData(int startRow, int numElementToFind) {
					
					try {
						return getRighe(startRow,startRow+numElementToFind);
						//if (tipo==null) return new ArrayList<SMS>();
						//if (sottotipo==null) return SMSUtil.findByTipoParam(tipo, param, startRow, startRow + numElementToFind);
						//if (param==0) return SMSUtil.findByTipoSottotipo(tipo, sottotipo, startRow, startRow + numElementToFind);
						//return SMSUtil.findByInvio(tipo, sottotipo, param, startRow, startRow + numElementToFind);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			};
			
			
		}
		
		return sms;
	}
	
	


	public void setSms(List sms) {
		this.sms = sms;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public Date getMyDataDa() {
		return myDataDa;
	}

	public void setMyDataDa(Date myDataDa) {
		this.myDataDa = myDataDa;
	}

	public Date getMyDataA() {
		return myDataA;
	}

	public void setMyDataA(Date myDataA) {
		this.myDataA = myDataA;
	}

	
	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		this.dettaglio = dettaglio;
	}

	public int getPageSizeDettaglio() {
		return pageSizeDettaglio;
	}

	public void setPageSizeDettaglio(int pageSizeDettaglio) {
		this.pageSizeDettaglio = pageSizeDettaglio;
	}

	public List getSmsDettaglio() {
		try {
		if (smsDettaglio==null) {
			
			smsDettaglio = new LazyList(pageSizeDettaglio,getNumeroRigheDettaglio())
			 {
				public List getData(int startRow, int numElementToFind) {
					
					try {
						return getRigheDettaglio(startRow,startRow+numElementToFind);
						//if (tipo==null) return new ArrayList<SMS>();
						//if (sottotipo==null) return SMSUtil.findByTipoParam(tipo, param, startRow, startRow + numElementToFind);
						//if (param==0) return SMSUtil.findByTipoSottotipo(tipo, sottotipo, startRow, startRow + numElementToFind);
						//return SMSUtil.findByInvio(tipo, sottotipo, param, startRow, startRow + numElementToFind);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			};
			
			
		}
		} catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("SMSGroupBean","getSmsDettaglio",ex,"");
		}
		
		return smsDettaglio;
	}

	public void setSmsDettaglio(List smsDettaglio) {
		this.smsDettaglio = smsDettaglio;
	}

	public String getTestoDettaglio() {
		return testoDettaglio;
	}

	public void setTestoDettaglio(String testoDettaglio) {
		this.testoDettaglio = testoDettaglio;
	}

	public String getDownloadLink() {
		String link = "/compila-allerta-portlet/sms-report2/sms.xls?";
		if (dettaglio==null) return "";
		link+="id="+dettaglio;
		
		if (nomeEvento!=null)
			link+="&nome="+nomeEvento;
		
		if (testoDettaglio!=null&&!testoDettaglio.equals("")) link+="&filtro="+testoDettaglio;
		
		if (soloFalliti) link += "&falliti=true";
		return link;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public boolean isSoloFalliti() {
		return soloFalliti;
	}

	public void setSoloFalliti(boolean soloFalliti) {
		this.soloFalliti = soloFalliti;
	}
	
	
	
	
}
