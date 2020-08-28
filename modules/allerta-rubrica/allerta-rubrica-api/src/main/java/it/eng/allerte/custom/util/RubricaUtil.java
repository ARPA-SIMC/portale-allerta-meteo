package it.eng.allerte.custom.util;

import java.util.Map;

import com.liferay.portal.kernel.log.Log;

import it.eng.allerta.utils.AllertaLegacy;

public class RubricaUtil {

	//I seguenti metodo servono per gestire gli indici di start ed end in liferay secondo i valori limit offset 
	//passati come parametri delle richieste
	
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static int calcolaStart(int offset, int limit) {
		
		if(offset >= 0) {
			
			return offset;
		}
		
		return -1;
	}
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public static int calcolaEnd(int start, int limit){
		
		if(limit == 0){
			return 0;
		}
		//nel caso di limit = 1 non devo fare il -1 (altrimenti non torna il risultato)
		else if(limit >= 1 ) {
			return (start+limit);
		} 
//		else if(limit > 1) {
//			return (start+limit)-1;
//		}
		
		return -1;
		
	}
	
	/**
	 * Request method non valido
	 * @param logger 
	 * 
	 * @param mappa
	 */
	public static void methodNoValid(Log logger, Map<String, Object> mappa) {
		logger.error(AllertaLegacy.MSG_METHOD_NO_VALID);
		mappa.put(AllertaLegacy.CODE, 405);
		mappa.put(AllertaLegacy.ERROR, AllertaLegacy.METHOD_NO_VALID);
	}
	
}
