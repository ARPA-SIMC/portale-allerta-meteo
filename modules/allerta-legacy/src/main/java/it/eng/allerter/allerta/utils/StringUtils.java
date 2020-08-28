package it.eng.allerter.allerta.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class StringUtils {
	private static final Log logger = LogFactoryUtil.getLog(StringUtils.class);
	
	public static String toCamelCase(String s){
		
		
		   String[] parts = s.split(" ");
		   String camelCaseString = "";
		   for (String part : parts){
		      camelCaseString = camelCaseString + toProperCase(part);
		   }
		   
		   logger.info("toCamelCase Trasform String "+s+" in "+camelCaseString);
		   return camelCaseString;
	}

	public 	static String toProperCase(String s) {
		 String proper = "";
		     proper= s.substring(0, 1).toUpperCase() +
		               s.substring(1).toLowerCase();
		     
		     logger.info("toProperCase Trasform String "+s+" in "+proper);
		     return proper;
	}
	
	public String toUpperLowerCase(String[] tempString) {
        StringBuilder builder = new StringBuilder();

        for (String temp : tempString) {

            String char1 = temp.substring(0, 1);
            String restString = temp.substring(1, temp.length()).toLowerCase();
            builder.append(char1).append(restString).append(" ");

        }
        
        String toLower = builder.toString();
        logger.info("toProperCase Trasform String "+tempString+" in "+toLower);
        return toLower;
    }
	
	
	
}
