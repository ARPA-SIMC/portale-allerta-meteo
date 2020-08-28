package it.eng.sms.utility;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SMSUtility {
	/* DELETE CLASS ?
	private Log _log = LogFactoryUtil.getLog(SMSUtility.class);
	
	public void sendMailWithPlainText(String body) {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;

		try {
			fromAddress = new InternetAddress("allertameteoSMS@regione.emilia-romagna.it");
			toAddress = new InternetAddress("francesco.giorgianni@eng.it");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("SMS Notification");
			mailMessage.setBody(body);
			MailServiceUtil.sendEmail(mailMessage);
			_log.info("Sent mail -> " +body);
		} catch (AddressException e) {
			_log.error(e.getMessage(),e);
		}
	}
	
	public String nameJVM(){
		return ManagementFactory.getRuntimeMXBean().getName();
	}

	
	public String tail( File file, int lines) {
		
		java.io.RandomAccessFile fileHandler = null;
		
		try {
			fileHandler = 
					new java.io.RandomAccessFile( file, "r" );
			
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();
			int line = 0;

			for(long filePointer = fileLength; filePointer != -1; filePointer--){
				
				fileHandler.seek( filePointer );
				int readByte = fileHandler.readByte();

				if( readByte == 0xA ) {
					if (filePointer < fileLength) {
						line = line + 1;
					}
				} else if( readByte == 0xD ) {
					if (filePointer < fileLength-1) {
						line = line + 1;
					}
				}
				if (line >= lines) {
					break;
				}
				sb.append(( char ) readByte );
			}

			String lastLine = sb.reverse().toString();
			
			return lastLine;
			
		} catch( java.io.FileNotFoundException e ) {
			
			e.printStackTrace();
			return null;
		} catch( java.io.IOException e ) {
			
			e.printStackTrace();
			return null;
		}
		finally {
			
			if (fileHandler != null )
				try {
					fileHandler.close();
				} catch (IOException e) {
				}
		}
	}
	*/
}
