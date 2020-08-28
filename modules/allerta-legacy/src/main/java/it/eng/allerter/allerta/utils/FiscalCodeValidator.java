package it.eng.allerter.allerta.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class FiscalCodeValidator {

	// Logger
   private static final Log logger = LogFactoryUtil.getLog(FiscalCodeValidator.class);

   
	public static boolean checkCf(String cf){
		
		logger.info("Inizio Controllo COdice Fiscale");
		
		Boolean cfCorretto = true;
				
		if(cf!=null){
			cf = cf.toLowerCase();
		}
		if(cf == null){
			cfCorretto = false;
		}
		if (cf.length() != 16) {
			cfCorretto=false;
		} else if(!cf.matches("[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]")) {
		
			cfCorretto=false;
		} else {
			if (!checkCF16(cf)) {
				cfCorretto=false;
			}
		}		
		return cfCorretto;
		
	}
	
	private static  boolean checkCF16(String codFisc){
		boolean flag=false;
		try {
			if (codFisc!=null && codFisc.trim().length()==16){
				String carValidi="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
				codFisc=codFisc.toUpperCase();
				for (int i = 0; i < 16; i++) {
					if (carValidi.indexOf(codFisc.charAt(i))==-1){
						flag=false;
						break;
					}else{
						flag=true;
					}
				}
				if (flag){
					flag=false;
					String  set1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					String  set2 = "ABCDEFGHIJABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
					String setpari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					String setdisp = "BAKPLCQDREVOSFTGUHMINJWZYX";
					int s=0;
					for( int i = 1; i <= 13; i += 2 )
						s += setpari.indexOf( set2.charAt( set1.indexOf( codFisc.charAt(i) )));
					for( int i = 0; i <= 14; i += 2 )
						s += setdisp.indexOf( set2.charAt( set1.indexOf( codFisc.charAt(i) )));

					int codeLastChar=((int) codFisc.charAt(15)) - ((int)'A');
					flag=(codeLastChar==s%26);
				}
			}
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
