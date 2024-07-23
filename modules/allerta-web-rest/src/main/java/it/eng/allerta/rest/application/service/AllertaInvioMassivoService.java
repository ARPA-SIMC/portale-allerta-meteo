package it.eng.allerta.rest.application.service;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.EmailLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/special/invio-massivo"
	    },
	    service = Servlet.class
	)
public class AllertaInvioMassivoService extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	private FileEntry getReportId(Allerta a) {
    	
    	try {
    		
    		PrincipalThreadLocal.setName(a.getUserId());
			
			PermissionChecker pc = PermissionCheckerFactoryUtil.create(UserLocalServiceUtil.fetchUser(a.getUserId()));
			PermissionThreadLocal.setPermissionChecker(pc);
    	
	    	Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	    	
	    	try {
	    		AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
	    		if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
	    	} catch (Exception e) {}
	    	
	    	Folder folder =DLAppServiceUtil.getFolder(20181, parentFolderId, "allerta-"+a.getAllertaId());
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());
			
			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					return f;
				}
			}
			
			return null;
			
    	} catch (Exception e) {
    		LogInternoLocalServiceUtil.log("AllertaInvioMassivo", "getReportId", e, "");
    		return null;
    	}
    	
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipo = req.getParameter("tipo")!=null?req.getParameter("gruppo"):"comunicazione";
		String sottotipo = req.getParameter("sottotipo")!=null?req.getParameter("sottotipo"):"massiva";
		long param = Long.parseLong(req.getParameter("param"));
		String from = req.getParameter("from")!=null?req.getParameter("from"):"no-reply@regione.emilia-romagna.it";

		String subject = BollettinoLocalServiceUtil.eseguiQueryGenerica("select oggetto from allerter_email where tipo='"
				+tipo+"' and sottotipo='"+sottotipo+"' and param="+param+" limit 1").toString();
		
		String text = BollettinoLocalServiceUtil.eseguiQueryGenerica("select testo from allerter_email where tipo='"
				+tipo+"' and sottotipo='"+sottotipo+"' and param="+param+" limit 1").toString();
		

		try {
		if ("allerta".equals(tipo)) {
			Allerta aa = AllertaLocalServiceUtil.fetchAllerta(param);
			FileEntry fe = getReportId(aa);
			File ff = FileUtil.createTempFile(fe.getContentStream());
			SMSLocalServiceUtil.inviaEmail("allerta", aa.getNumero(), aa.getAllertaId(),
					"ALLERTAER - Emessa Allerta " + aa.getNumero(), text, from, ff, fe.getTitle());
			return;
		}
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("invioMassivo", "param="+param, e, "");	
			return;
		}
		
		try {
			SMSLocalServiceUtil.inviaEmail(tipo, sottotipo, param, subject, text, from);
		} catch (Exception e) {
			e.printStackTrace();
			LogInternoLocalServiceUtil.log("invioMassivo", "param="+param, e, "");
		}
	}
}
