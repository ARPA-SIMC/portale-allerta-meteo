package it.eng.allerta.utils;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryMetadata;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;

import java.io.File;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class DlFileEntryModelListener extends BaseModelListener<DLFileEntryMetadata>  {
	
	@Override
	public void onAfterCreate(DLFileEntryMetadata md) throws ModelListenerException {
		// TODO Auto-generated method stub
		DLFileEntry model = DLFileEntryLocalServiceUtil.fetchDLFileEntry(md.getFileEntryId());
		boolean elimina = false;
		
		
		
		try {
		File f = DLFileEntryLocalServiceUtil.getFile(model.getPrimaryKey(), model.getVersion(), false);
		String mime = MimeTypesUtil.getContentType(f);
		if (mime!=null) mime = mime.toLowerCase();
		String extension = model.getExtension();
		if (extension!=null) extension = extension.toLowerCase();
		
		//byte[] b = FileUtil.getBytes(f);
		//String s = checkMagicNumber(b);
		
		if (mime==null) elimina = true;
		else if (extension==null) {
			if (!mime.equals("application/pdf") &&
					!mime.equals("image/jpeg") &&
					!mime.equals("image/gif") &&
					!mime.equals("image/png")) elimina = true;
		}
		else if (mime.equals("application/pdf")) {
			if (!extension.equals("pdf")) elimina = true;
		} else if (mime.equals("image/jpeg")) {
			if (!extension.equals("jpeg") && !extension.equals("jpg")) elimina = true;
		} else if (mime.equals("image/gif")) {
			if (!extension.equals("gif")) elimina = true;
		} else if (mime.equals("image/png")) {
			if (!extension.equals("png")) elimina = true;
		} else elimina = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (elimina) {
			DLFileEntryMetadataLocalServiceUtil.deleteDLFileEntryMetadata(md);
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(model);
		}
	}
	
	public static String checkMagicNumber(byte[] b) {
		
		if (b.length > 16) {
			byte b2[] = new byte[16];
			for (int k=0; k<16; k++) b2[k] = b[k];
			b = b2;
		}
		
		String hex = asHex(b);
		String upper = hex.toUpperCase();
		
		
		if(upper.startsWith("D0CF11E0A1B11AE1")) return "DOC"; //Tutti i file di tipo Microsoft Office
		else if(upper.startsWith("504B")) return "ZIP";
		else if(upper.startsWith("25504446")) return "PDF"; //File PDF
		else if(upper.startsWith("504B0304")) return "ODT"; //File ODT
		else if(upper.startsWith("FFD8")) return "JPG"; //File JPG
		else if(upper.startsWith("47494638")) return "GIF"; //File GIF
		else if(upper.startsWith("424D")) return "BMP"; //File BMP
		else if(upper.startsWith("89504E470D0A1A0A")) return "PNG"; //File PNG
		
		return "";
	}

	/*Trasformo un array di byte in stringa esadecimale*/
	private static String asHex(byte buf[])
	{
        StringBuffer strbuf = new StringBuffer(buf.length * 2);

        for(int i=0; i< buf.length; i++)
        {
                if(((int) buf[i] & 0xff) < 0x10)
                        strbuf.append("0");
                strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
	}

}
