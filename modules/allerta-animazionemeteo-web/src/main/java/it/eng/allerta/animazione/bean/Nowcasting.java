package it.eng.allerta.animazione.bean;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.service.ImgLocalServiceUtil;

public class Nowcasting {
	
	private Log _log = LogFactoryUtil.getLog(Nowcasting.class);
	
	public Img getImg(String value) throws SystemException {
		
		Img img = null;
		
		try {
			img = ImgLocalServiceUtil.getByPartDayProvincia(value, "Nowcasting", "ND");
		}catch (Exception e) {
			_log.error("Created image");
		}
		
		return img;
	}

}
