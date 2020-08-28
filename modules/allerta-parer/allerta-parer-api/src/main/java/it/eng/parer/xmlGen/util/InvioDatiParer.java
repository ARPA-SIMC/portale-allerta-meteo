package it.eng.parer.xmlGen.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class InvioDatiParer implements IJavaToXMLParerConstants {
	
	private static Log logger = LogFactoryUtil.getLog(InvioDatiParer.class);

	/**
	 * 
	 * @param versatoreUserId 
	 * @param xmlAllerta
	 * @return
	 * @throws Exception
	 */
	public static String invioDatiParer(String xmlDaInviare, List<File> listaDocumenti, String versatoreUserId) throws Exception {

		//URL
        String requestURL = ConstansUtil.URL_PARER;
        String response = "";
        
        try {
            MultipartRequest multipart = new MultipartRequest();

            Map<String, String> parameter = new HashMap<String, String>();
            parameter.put("VERSIONE", VERSIONE);
            //User e id potrebbero cambiare in base al versatore
            parameter.put("LOGINNAME", versatoreUserId);
            if(versatoreUserId.equals(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE)) {
            	 parameter.put("PASSWORD", ConstansUtil.VERSATORE_PASS_PROT_CIV);
            }
            else if(versatoreUserId.equals(ConstansUtil.VERSATORE_ALLERTA_USER_ID_ARPA)) {
            	 parameter.put("PASSWORD", ConstansUtil.VERSATORE_PASS_ARPA);
            }
            //Qui ci va l'xml generato in formato testo.
            parameter.put("XMLSIP", xmlDaInviare); 
            //Qui ci vanno i documenti allegati (dovrebbe essere sempre uno??)
            Map<String, File> allegati = new HashMap<>();
            int index = 1;
            for(File docAllegato : listaDocumenti) {
            	allegati.put(String.valueOf(index), docAllegato);
            	index++;
            }

            response = multipart.invia(requestURL, allegati, parameter);
             
            logger.info("SERVER REPLIED:");
     
            logger.info(response);
           
        } catch (IOException ex) {
        	logger.error(ex);
        }
				
		return response;
	}


}
