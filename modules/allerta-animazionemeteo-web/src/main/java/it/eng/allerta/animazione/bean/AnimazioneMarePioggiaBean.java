package it.eng.allerta.animazione.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaAdriacLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaSwanitaLocalServiceUtil;
import it.eng.animazione.image.service.elevazioneLocalServiceUtil;

public class AnimazioneMarePioggiaBean implements Serializable {

	private static final long serialVersionUID = -1893290548878271990L;
	
	private static Log _log = LogFactoryUtil.getLog(AnimazioneMarePioggiaBean.class);
	
	private List<PioggiaCumulativa> cumulativa48 = null;
	private List<PioggiaCumulativa> cumulativa6 = null;
	private List<altezzaOnda> altezzaOnda = null;
	private List<it.eng.animazione.image.model.altezzaOndaSwanita> altezzaOndaSwanita = null;
	private List<it.eng.animazione.image.model.altezzaOndaAdriac> altezzaOndaAdriac = null;
	private List<it.eng.animazione.image.model.elevazione> elevazione = null;
	private SimpleDateFormat sdf;
	private Calendar calendar = Calendar.getInstance();
	
	public AnimazioneMarePioggiaBean() {
		
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	}
	
	public String cumulativa48Json() {
		
		if (cumulativa48 == null)
			
			try {
				
				cumulativa48 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("48h");
				
				for(PioggiaCumulativa cumulativa : cumulativa48) {
					
					calendar.setTime(cumulativa.getInzioCumulazione());
//					calendar.add(Calendar.MONTH, -1);
					cumulativa.setInzioCumulazione(calendar.getTime());

					calendar.setTime(cumulativa.getFineCumulazione());
//					calendar.add(Calendar.MONTH, -1);
					cumulativa.setFineCumulazione(calendar.getTime());
				}
			} catch (SystemException | NoSuchPioggiaCumulativaException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(cumulativa48);
	}
	
	public List<PioggiaCumulativa> getCumulativa48() {
		
		if (cumulativa48 == null)
			try {
				
				cumulativa48 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("48h");
				
			} catch (SystemException | NoSuchPioggiaCumulativaException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return cumulativa48;
	}
	
	public String cumulativa6Json() {
		
		if (cumulativa6 == null)
			try {
				
				cumulativa6 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("6h");
				
				for(PioggiaCumulativa cumulativa : cumulativa6) {
					
					calendar.setTime(cumulativa.getInzioCumulazione());
//					calendar.add(Calendar.MONTH, -1);
					cumulativa.setInzioCumulazione(calendar.getTime());

					calendar.setTime(cumulativa.getFineCumulazione());
//					calendar.add(Calendar.MONTH, -1);
					cumulativa.setFineCumulazione(calendar.getTime());
				}
			} catch (SystemException | NoSuchPioggiaCumulativaException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(cumulativa6);
	}
	
	public List<PioggiaCumulativa> getCumulativa6() {
		
		if (cumulativa6 == null)
			try {
				
				cumulativa6 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("6h");
				
			} catch (SystemException | NoSuchPioggiaCumulativaException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return cumulativa6;
	}
	
	public String altezzaOndaJson() {
		
		if (altezzaOnda == null)
			try {
				
				altezzaOnda = altezzaOndaLocalServiceUtil.getaltezzaOndas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(altezzaOnda);
	}
	
	public String altezzaOndaSwanitaJson() {
		
		if (altezzaOndaSwanita == null)
			try {
				
				altezzaOndaSwanita = altezzaOndaSwanitaLocalServiceUtil.getaltezzaOndaSwanitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(altezzaOndaSwanita);
	}
	
	public String altezzaOndaAdriacJson() {
		
		if (altezzaOndaAdriac == null)
			try {
				
				altezzaOndaAdriac = altezzaOndaAdriacLocalServiceUtil.getaltezzaOndaAdriacs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(altezzaOndaSwanita);
	}
	
	public String elevazioneJson() {
		
		if (elevazione == null)
			try {
				
				elevazione = elevazioneLocalServiceUtil.getelevaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		
		return new Gson().toJson(elevazione);
	}
	
	public List<altezzaOnda> getaltezzaOnda() {
		if (altezzaOnda == null)
			try {
				altezzaOnda = altezzaOndaLocalServiceUtil.getaltezzaOndas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		return altezzaOnda;
	}
	
	public List<it.eng.animazione.image.model.altezzaOndaSwanita> getaltezzaOndaSwanita() {
		if (altezzaOndaSwanita == null)
			try {
				altezzaOndaSwanita = altezzaOndaSwanitaLocalServiceUtil.getaltezzaOndaSwanitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		return altezzaOndaSwanita;
	}
	
	public List<it.eng.animazione.image.model.altezzaOndaAdriac> getaltezzaOndaAdriac() {
		if (altezzaOndaAdriac == null)
			try {
				altezzaOndaAdriac = altezzaOndaAdriacLocalServiceUtil.getaltezzaOndaAdriacs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		return altezzaOndaAdriac;
	}

	public SimpleDateFormat getSdf(Date date){
		
		sdf.format(date);
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf){
		
		this.sdf = sdf;
	}

}
