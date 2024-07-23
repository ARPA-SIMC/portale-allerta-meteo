package it.eng.allerter.allerta.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.RubricaGruppoGruppiLocalService;
import it.eng.allerte.service.RubricaGruppoLocalService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.OrganizationLocalService;

@Component(
		immediate = true,
		service = MessaggioService.class
		)
public class MessaggioService {

	public Map<Long,String> getOrganizations(String[] organization) throws PortalException {
		 
		Map<Long,String> organizationIds = new HashMap<Long, String>();
		
		List<String> orgs = Arrays.asList(organization);
		if (organization == null || orgs.size() == 0) {
			return organizationIds;
		}
		
		String[] split = organization[0].split(",");
		long[] org = new long[split.length];
		for(int i=0;i<split.length;i++)
			org[i]=Long.parseLong(split[i]);

		for (Long l : org) {
			List<Object[]> al = rubricaGruppoGruppiService.getGruppiFigli(l);
			for (Object[] fi : al) {
				Long idFiglio = (Long)fi[1];
				RubricaGruppo rg = rubricaGruppoService.fetchRubricaGruppo(idFiglio);
				if (rg!=null)
					organizationIds.put(rg.getID_GRUPPO(),rg.getNOME());
			}
			
		}
		
		/*List<Organization> oo = organizationLocalService.getOrganizations(org);
		for(Organization o: organizationLocalService.getSuborganizations(oo))
			organizationIds.put(o.getOrganizationId(),o.getName());*/
		organizationIds =  sortByValues(organizationIds); 
		
		return organizationIds;

	}
	
	public Map<Long,String> getOrganizations(long owner) throws PortalException {
		 
		Map<Long,String> organizationIds = new HashMap<Long, String>();
		
		if (owner == 0) {
			return organizationIds;
		}
		
		ArrayList<Object[]> o = rubricaGruppoService.getGruppiByName(owner, "%", -1L, -1L);
		for (Object[] oo : o) {
			organizationIds.put((Long)oo[0],(String) oo[1]);
		}
		
		/*List<Organization> oo = organizationLocalService.getOrganizations(org);
		for(Organization o: organizationLocalService.getSuborganizations(oo))
			organizationIds.put(o.getOrganizationId(),o.getName());*/
		organizationIds =  sortByValues(organizationIds); 
		
		return organizationIds;

	}
	
	@SuppressWarnings(value = {"rawtypes","unchecked"})
	private HashMap<Long,String> sortByValues(Map<Long, String> map) { 
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		return sortedHashMap;
	}


	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private RubricaGruppoGruppiLocalService rubricaGruppoGruppiService;
	
	@Reference
	private RubricaGruppoLocalService rubricaGruppoService;
}
