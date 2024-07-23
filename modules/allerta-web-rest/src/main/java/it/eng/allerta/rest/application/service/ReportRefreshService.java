package it.eng.allerta.rest.application.service;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.allerta.AllertaValangheBean;
import it.eng.allerter.allerta.BollettinoBean;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalService;

@Component(
		immediate = true,
		service=ReportRefreshService.class
		)
public class ReportRefreshService  {

	private Log logger = LogFactoryUtil.getLog(ReportRefreshService.class);
	
	public void refreshPdf(String p, String oggetto, String id, String scope, 
			HttpServletRequest request) {

		//logInternoLocalService.log("ReportRefreshServlet", "doGet", p, "");

		logger.info("OGGETTO " + oggetto + " ID " + id + " SCOPE " + scope);

		if (oggetto == null || id == null || scope == null)
			return;

		Long l = Long.parseLong(id);
		//Long s = Long.parseLong(scope);

		CacheRegistryUtil.clear();

		if (oggetto.equals("allerta"))
			refreshAllerta(l, request);
		if (oggetto.equals("valanghe"))
			refreshAllertaValanghe(l, request);
		if (oggetto.equals("bollettino"))
			refreshMonitoraggio(l, request);

	}

	private void refreshAllerta(long allertaId, HttpServletRequest request) {

		try {

			AllertaBean ab = new AllertaBean(allertaId, request);
			ab.setThreadUserPermission();
			
			ab.creaReport();

		} catch (Exception e) {
			//logInternoLocalService.log("ReportRefreshServlet", "refreshAllerta", e, "");
			e.printStackTrace();
		}
	}
	
	private void refreshAllertaValanghe(long allertaId, HttpServletRequest request) {

		try {

			AllertaValangheBean ab = new AllertaValangheBean(allertaId, request);
			ab.setThreadUserPermission();
			
			ab.creaReport();

		} catch (Exception e) {
			//logInternoLocalService.log("ReportRefreshServlet", "refreshAllerta", e, "");
			e.printStackTrace();
		}
	}

	private void refreshMonitoraggio(long bollettinoId, HttpServletRequest request) {

		try {
			
			BollettinoBean ab = new BollettinoBean(bollettinoId, request);
			// BollettinoBean.pathReports = p;
			ab.setThreadUserPermission();
			ab.creaReport(false);// myCarica(l, scopeGroup);

		} catch (Exception e) {
			//logInternoLocalService.log("ReportRefreshServlet", "refreshMonitoraggio", e, "");
			e.printStackTrace();
		}
	}
	
	@Reference
	private LogInternoLocalService logInternoLocalService;
	
	@Reference
	private BollettinoLocalService bollettinoLocalService;
	
	/*
	 * public void destroy() {
	 * 
	 * try {
	 * 
	 * 
	 * //Get a list of all classes loaded by the current webapp classloader
	 * WebappClassLoader classLoader = (WebappClassLoader)
	 * getClass().getClassLoader(); Field classLoaderClassesField = null; Class
	 * clazz = WebappClassLoader.class; while (classLoaderClassesField == null &&
	 * clazz != null) { try { classLoaderClassesField =
	 * clazz.getDeclaredField("classes"); } catch (Exception exception) { //do
	 * nothing } clazz = clazz.getSuperclass(); }
	 * classLoaderClassesField.setAccessible(true);
	 * 
	 * List classes = new
	 * ArrayList((Vector)classLoaderClassesField.get(classLoader));
	 * 
	 * for (Object o : classes) { Class c = (Class)o; //Make sure you identify only
	 * the packages that are holding references to the classloader. //Allowing this
	 * code to clear all static references will result in all sorts //of horrible
	 * things (like java segfaulting). if
	 * (c.getName().startsWith("it.eng.allerter")) { //Kill any static references
	 * within all these classes. for (Field f : c.getDeclaredFields()) { if
	 * (Modifier.isStatic(f.getModifiers()) && !Modifier.isFinal(f.getModifiers())
	 * && !f.getType().isPrimitive()) { try { f.setAccessible(true); f.set(null,
	 * null); System.out.println("Annullo "+f.getName()+" in "+c.getName()); } catch
	 * (Exception exception) { //Log the exception } } } } }
	 * 
	 * classes.clear();
	 * 
	 * 
	 * 
	 * } catch (Exception e) {
	 * logInternoLocalService.log("reportRefreshServlet", "destroy", e, ""); }
	 * 
	 * }
	 */
}
