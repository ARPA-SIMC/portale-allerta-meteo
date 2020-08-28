package it.eng.comune.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

public class SelectOrganizationModelBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Map<Long,String> organizationIds = new HashMap<>();
	private List<String> selectedOrganization = new ArrayList<>();
	private String phase;

	// Logger
	private Log _log = LogFactoryUtil.getLog(SelectOrganizationModelBean.class);

	public SelectOrganizationModelBean() {
		initOrganizationList();
	}

	private void initOrganizationList(){
		try {
			
			//String organization[] = portletPreferences.getMap().get("organization");
			String organization[] = {};
			String[] split = organization[0].split(",");
			long[] org = new long[split.length];
			for(int i=0;i<split.length;i++)
				org[i]=Long.parseLong(split[i]);

			List<Organization> oo = OrganizationLocalServiceUtil.getOrganizations(org);
			
			for(Organization o:OrganizationLocalServiceUtil.getSuborganizations(oo))
				organizationIds.put(o.getOrganizationId(),o.getName());
			organizationIds = sortByValues(organizationIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		_log.info("Organizzazioni trovate: "+organizationIds.size());
	}

	private static HashMap<Long,String> sortByValues(Map<Long, String> map) { 
		
		List list = new LinkedList<>(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap<>();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		return sortedHashMap;
	}


	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Map<Long, String> getOrganizationIds() {
		return organizationIds;
	}

	public void setOrganizationIds(Map<Long, String> organizationIds) {
		this.organizationIds = organizationIds;
	}

	public List<String> getSelectedOrganization() {
		return selectedOrganization;
	}

	public void setSelectedOrganization(List<String> selectedOrganization) {
		this.selectedOrganization = selectedOrganization;
	}

	public String toStringView(){
		StringBuilder a = new StringBuilder();
		for(String s:selectedOrganization)
		{
			if(a.length()>0)
				a.append(" - ");
			a.append(organizationIds.get(Long.parseLong(s)));
		}

		return a.toString();
	}

}
