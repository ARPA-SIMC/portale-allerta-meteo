package it.eng.allerta.controlpanel.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.controlpanel.constants.AllertaControlPanelPortletKeys;
import it.eng.allerta.controlpanel.servlet.LogSearchServlet;

@Component(immediate = true, property = { "javax.portlet.name=" + AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL,
		"mvc.command.name=/controlpanel/submitFile" }, service = MVCActionCommand.class)
public class UploadAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("UploadAction");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String submissionFileName = uploadRequest.getFileName("file");//uploaded filename
		File submissionFile = uploadRequest.getFile("file"); //uploaded file you can see it in /tomcat/temp
		if (submissionFile!=null && submissionFile.exists()) {
			File destination = new File(getHome()+"data"+File.separator+"document_library"+File.separator+submissionFileName);
			Files.move(submissionFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			String computer = PortalUtil.getComputerName();
			String nodo = null;
			if (computer.contains("vm957lnx")) nodo = "vm959lnx";
			if (computer.contains("vm959lnx")) nodo = "vm957lnx";
			
			if (nodo!=null) LogSearchServlet.doCommandOnNode(nodo, "dpl", destination.getAbsolutePath(), "", "");
			else LogSearchServlet.doCommand("dpl", destination.getAbsolutePath(), "", "");
		}
		
		actionResponse.setRenderParameter("id","Deploy");
	}
	
	private static String getHome() {
		return PortalUtil.getPortal().getPortalProperties().getProperty("liferay.home")+File.separator;
	}



}
