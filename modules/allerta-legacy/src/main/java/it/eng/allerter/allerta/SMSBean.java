 package it.eng.allerter.allerta;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.model.Email;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.AllertaStatoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.allerter.service.persistence.SMSUtil;


public class SMSBean implements Serializable {
	
	boolean primoCaricamento = true;
	
	
	private String tipo = null;
	private String sottotipo = null;
	private String comune = null;
	private long param = 0;
	private long stato = -1;
	private String myStato = "-1";
	private String nomeDestinatario = null;
	private String numero = null;
	private String dataDa = null;
	private String dataA = null;
	
	private Date myDataDa;
	private Date myDataA;
	private int pageSize = 30;
	
	private List<SMS> sms;
	private List<Email> email;
	
	private String invioDa;
	private String invioA;
	private String testo;
	
	
	private DynamicQuery getQueryEmail(int begin, int end) {
		
		System.out.println("GetQueryEmail "+begin+" "+end);
		
		DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(Email.class);
		
		if (tipo!=null && !tipo.equals("")) dyn = dyn.add(PropertyFactoryUtil.forName("tipo").eq(tipo));
		if (sottotipo!=null && !sottotipo.equals("")) dyn = dyn.add(PropertyFactoryUtil.forName("sottotipo").eq(sottotipo));
		if (param!=0) dyn = dyn.add(PropertyFactoryUtil.forName("param").eq(param));
		/*if (myStato!=null && !myStato.equals("-1")  && !myStato.equals("")) {
			try {
			dyn = dyn.add(PropertyFactoryUtil.forName("stato").eq(Long.parseLong(myStato)));
			} catch (Exception e) {}
		}*/
		//if (numero!=null  && !numero.equals("")) dyn = dyn.add(PropertyFactoryUtil.forName("numero").eq(numero));
		if (nomeDestinatario!=null  && !nomeDestinatario.equals("")) dyn = dyn.add(PropertyFactoryUtil.forName("nomeDestinatario").like("%"+nomeDestinatario.toLowerCase()+"%"));
		if (myDataDa!=null) {
				dyn.add(PropertyFactoryUtil.forName("dataInvio").ge(myDataDa));
		}
		if (myDataA!=null) {
				dyn.add(PropertyFactoryUtil.forName("dataInvio").le(myDataA));
		}
		if (end!=0) dyn.setLimit(begin, end);

		return dyn;
		
	}
	
	public String getDownloadLinkEmail() {
		String link = "/compila-allerta-portlet/email-report?";
		int x = 0;
		if (tipo!=null && !tipo.equals("")) {
			if (x++ > 0) link +="&";
			link+="tipo="+tipo;
		}
		if (sottotipo!=null && !sottotipo.equals("")) {
			if (x++ > 0) link +="&";
			link+="sottotipo="+sottotipo;
		}
		if (param!=0) {
			if (x++ > 0) link +="&";
			link+="param="+param;
		}
		if (myStato!=null && !myStato.equals("") && !myStato.equals("-1")) {
			if (x++ > 0) link +="&";
			link+="stato="+myStato;
		}
		if (numero!=null && !numero.equals("")) {
			if (x++ > 0) link +="&";
			link+="numero="+numero;
		}
		if (nomeDestinatario!=null && !nomeDestinatario.equals("")) {
			if (x++ > 0) link +="&";
			link+="destinatario="+nomeDestinatario;
		}
		if (myDataDa!=null) {
			if (x++ > 0) link +="&";
			link += "datada=" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(myDataDa);
		}
		if (myDataA!=null) {
			if (x++ > 0) link +="&";
			link += "dataa=" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(myDataA);
		}
		if (x==0) return null;
		return link;
	}
	
	public int getCarica(PortletRequest req) {
		
		if (!primoCaricamento) return 0;
		
		//trova le info dall'url
		
		HttpServletRequest req2 = PortalUtil.getHttpServletRequest(req);
				
		tipo = req2.getParameter("tipo");
		sottotipo = req2.getParameter("sottotipo");
		String p = req2.getParameter("param");
		comune = req2.getParameter("comune");
		String c = comune;
		
		if (c!=null) {
			c = c.toUpperCase();
			try {
				List<Group> l = GroupLocalServiceUtil.getGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for (Group g : l) {
					if (g.getName()!=null && g.getName().toUpperCase().equals(c)) sottotipo = ""+g.getGroupId();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if (req2.getParameter("stato")!=null) {
			myStato = req2.getParameter("stato");
			stato = Long.parseLong(req2.getParameter("stato"));
		}
		
		nomeDestinatario = req2.getParameter("destinatario");
		numero = req2.getParameter("numero");
		dataDa = req2.getParameter("datada");
		dataA = req2.getParameter("dataa");
		if (dataDa!=null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				myDataDa = sdf.parse(dataDa);
			} catch (Exception e) {}
		}
		if (dataA!=null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				myDataA = sdf.parse(dataA);
			} catch (Exception e) {}
		}
		
		if (p!=null) param = Long.parseLong(p);
		
		primoCaricamento = false;
		
		return 0;
		
	}
	
	public void setCarica(int i) {
		
	}
	
	

	public int getNumeroEmail() {
		try {
			/*if (tipo==null) return 0;
			if (sottotipo==null) return SMSUtil.countByTipoParam(tipo, param);
			if (param==0) return SMSUtil.countByTipoSottotipo(tipo, sottotipo);
			
			return SMSUtil.countByInvio(tipo, sottotipo, param); */
			
			int num = (int) SMSLocalServiceUtil.dynamicQueryCount(getQueryEmail(0,0));
			
			System.out.println("Trovate "+num+" Email");
			
			return num;
			
		} catch (Exception e) {
			try {
				File f = new File("C:\\Users\\GFAVINI\\Documents\\Liferay\\liferay-portal-6.2-ce-ga6\\logs\\numeromail.txt");
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);
				e.printStackTrace(pw);
				pw.flush();
				pw.close();
			} catch (Exception ex2) {
				ex2.printStackTrace();
			}
			return 0;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSottotipo() {
		return sottotipo;
	}

	public void setSottotipo(String sottotipo) {
		this.sottotipo = sottotipo;
	}

	public long getParam() {
		return param;
	}

	public void setParam(long param) {
		this.param = param;
	}
	
	public void updateList() {
		sms = null;
		email = null;
	}
	
	public List<Email> getEmail() {
		
		if (email==null) {
		
		email = new LazyList<Email>(pageSize,getNumeroEmail())
		 {
			public List<Email> getData(int startRow, int numElementToFind) {
				
				try {
					return SMSLocalServiceUtil.dynamicQuery(getQueryEmail(startRow,startRow+numElementToFind));
					//if (tipo==null) return new ArrayList<SMS>();
					//if (sottotipo==null) return SMSUtil.findByTipoParam(tipo, param, startRow, startRow + numElementToFind);
					//if (param==0) return SMSUtil.findByTipoSottotipo(tipo, sottotipo, startRow, startRow + numElementToFind);
					//return SMSUtil.findByInvio(tipo, sottotipo, param, startRow, startRow + numElementToFind);
				} catch (Exception e) {
					try {
						File f = new File("C:\\Users\\GFAVINI\\Documents\\Liferay\\liferay-portal-6.2-ce-ga6\\logs\\getemail.txt");
						f.createNewFile();
						PrintWriter pw = new PrintWriter(f);
						e.printStackTrace(pw);
						pw.flush();
						pw.close();
					} catch (Exception ex2) {
						ex2.printStackTrace();
					}
				}
				return null;
			}
		};
		
		
	}
		return email;
	}

	public void setEmail(List<Email> email) {
		this.email = email;
	}

	public void setSms(List<SMS> sms) {
		this.sms = sms;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getStato() {
		return stato;
	}

	public void setStato(long stato) {
		this.stato = stato;
	}

	public String getNomeDestinatario() {
		//System.out.println("GETNOMEDEST "+nomeDestinatario);
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		//System.out.println("SETNOMEDEST "+nomeDestinatario);
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDataDa() {
		return dataDa;
	}

	public void setDataDa(String dataDa) {
		this.dataDa = dataDa;
	}

	public String getDataA() {
		return dataA;
	}

	public void setDataA(String dataA) {
		this.dataA = dataA;
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

	public String getMyStato() {
		return myStato;
	}

	public void setMyStato(String myStato) {
		this.myStato = myStato;
	}

	public String getInvioDa() {
		return invioDa;
	}

	public void setInvioDa(String invioDa) {
		this.invioDa = invioDa;
	}

	public String getInvioA() {
		return invioA;
	}

	public void setInvioA(String invioA) {
		this.invioA = invioA;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	public void inviaSmsProva() {
		long l = new Date().getTime();
		try {
			SMSLocalServiceUtil.creaSMS(invioDa, invioA, testo, "prova", "prova", l, 0);
			SMSLocalServiceUtil.inviaSMS("prova", "prova", l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inviaSmsShutdown() {
		long l = new Date().getTime();
		try {
			//SMSLocalServiceUtil.creaSMS(invioDa, invioA, testo, "shutdown", "shutdown", l, 0);
			SMSLocalServiceUtil.inviaSMS("shutdown", "shutdown", l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inviaSmsSvuota() {
		long l = new Date().getTime();
		try {
			//SMSLocalServiceUtil.creaSMS(invioDa, invioA, testo, "emptyQueue", "emptyQueue", l, 0);
			SMSLocalServiceUtil.inviaSMS("emptyQueue", "emptyQueue", l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
