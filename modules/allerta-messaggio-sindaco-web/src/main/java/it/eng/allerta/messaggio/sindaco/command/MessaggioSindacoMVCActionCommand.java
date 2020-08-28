package it.eng.allerta.messaggio.sindaco.command;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.messaggio.sindaco.bean.MessaggioBean;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.FileBean;

@Component(
		immediate = true,
		property= {
				"javax.portlet.name=" + AllertaKeys.AllertaMessaggioSindacoPortlet,
				"mvc.command.name=/allertaer/comunicazioni/invia"
		},
		service = MVCActionCommand.class
		)
public class MessaggioSindacoMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		try {
			
			String step = ParamUtil.getString(actionRequest, "step");
			if (step.equals("on")) {
				salva(actionRequest, actionResponse);
				stepOn(actionRequest, actionResponse);
			} else if (step.equals("off")) {
				stepOff(actionRequest, actionResponse);
			} else if (step.equals("upload")) {
				salva(actionRequest, actionResponse);
				upload(actionRequest, actionResponse);
			}  else if (step.equals("delete")) {
				salva(actionRequest, actionResponse);
				deleteFile(actionRequest, actionResponse);
			}  else if (step.equals("send")) {
				send(actionRequest, actionResponse);
				stepOn(actionRequest, actionResponse);
			}
			
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, e.getClass());
		}
		
	}
	
	private void send(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws AddressException, SystemException, IOException, Exception {
		
		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		messaggioBean.dispatchMessage(themeDisplay);
	}

	protected void deleteFile(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
		
		String hash = ParamUtil.getString(actionRequest, "fileHash");
			
		messaggioBean.deleteUploadedFiles(hash);
			
		actionRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean);
		
		
	}
	
	
	private void upload(ActionRequest actionRequest, ActionResponse actionResponse) {
		

		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		try {
			
			File uploadedFile = uploadRequest.getFile("fileUpload");
			String mimeType = uploadRequest.getContentType("fileUpload");
            String title = uploadRequest.getFileName("fileUpload");
            String hash = DigesterUtil.digest(new FileInputStream(uploadedFile));
			
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            StreamUtil.transfer(new FileInputStream(uploadedFile), baos);
            FileBean fileBean = new FileBean();
            fileBean.setContent(baos.toByteArray());
            fileBean.setMimeType(mimeType);
            fileBean.setTitle(title);
            fileBean.setHash(hash);
			
			messaggioBean.addUploadedFiles(fileBean);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, e.getClass());
		}
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean);
		
	}
	
	private void stepOn(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
		
		int step = messaggioBean.getStep();
		messaggioBean.setStep(++step);
		
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean);
		
	}

	private void salva(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
		
		if (messaggioBean.getStep() == 1) {
			
			String[] selectedOrganization = ParamUtil.getParameterValues(actionRequest, "selectedOrganization[]");
			messaggioBean.setSelectedOrganization(Arrays.asList(selectedOrganization));
		
			String[] selectedTownHall = ParamUtil.getParameterValues(actionRequest, "comune[]");
			messaggioBean.setSelectTownHall(Arrays.asList(selectedTownHall));
			
			String obj_mail = ParamUtil.getString(actionRequest, "obj_mail");
			messaggioBean.setObj_mail(obj_mail);
			
			String mex_pc = ParamUtil.getString(actionRequest, "mex_pc");
			messaggioBean.setMex_pc(mex_pc);
			
			String subject = ParamUtil.getString(actionRequest, "subject");
			messaggioBean.setSubject(subject);
			
			messaggioBean.setSelectBooleanInfo(new ArrayList<String>());
			
			String[] selectBooleanInfo = ParamUtil.getParameterValues(actionRequest, "selectBooleanInfo");
			for (String value : selectBooleanInfo) {
				switch (value) {
				case "piene":
					messaggioBean.addSelectBooleanInfo("piene");
					break;
					
				case "frane":
					messaggioBean.addSelectBooleanInfo("frane");
					break;
					
				case "temporali":
					messaggioBean.addSelectBooleanInfo("temporali");
					break;
					
				case "vento":
					messaggioBean.addSelectBooleanInfo("vento");
					break;
					
				case "mareggiate":
					messaggioBean.addSelectBooleanInfo("mareggiate");
					break;
					
				case "neve":
					messaggioBean.addSelectBooleanInfo("neve");
					break;
					
				case "ghiaccio":
					messaggioBean.addSelectBooleanInfo("ghiaccio");
					break;
					
				case "ondateDiCalore":
					messaggioBean.addSelectBooleanInfo("ondateDiCalore");
					break;
					
				case "incendi":
					messaggioBean.addSelectBooleanInfo("incendi");
					break;
					
				case "terremoto":
					messaggioBean.addSelectBooleanInfo("terremoto");
					break;
					
				default:
					break;

				}
			}
			
		} else if (messaggioBean.getStep() == 2) {
			
			messaggioBean.unsetChannels();
						
			String[] selectBooleanChannel= ParamUtil.getParameterValues(actionRequest, "selectBooleanChannel[]");
			for (String value : selectBooleanChannel) {
				switch (value) {
				case "telefono":
					messaggioBean.setTelefono("si");
					break;

				case "sms":
					messaggioBean.setSms("si");
					break;

				case "social":
					messaggioBean.setSocial("si");
					break;

				case "mail":
					messaggioBean.setMail("si");
					break;

				case "portale":
					messaggioBean.setPortale("si");
					break;

				default:
					break;
				} 
			}
		}
		
		
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean);
	}

	private void stepOff(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		MessaggioBean messaggioBean = (MessaggioBean) actionRequest
				.getPortletSession().getAttribute(AllertaKeys.SessionMessaggioBean);
		
		if (messaggioBean.getStep() > 1) {
			int step = messaggioBean.getStep();
			messaggioBean.setStep(--step);
		}
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean);
	}
	

	private Log _log = LogFactoryUtil.getLog(MessaggioSindacoMVCActionCommand.class);

}
