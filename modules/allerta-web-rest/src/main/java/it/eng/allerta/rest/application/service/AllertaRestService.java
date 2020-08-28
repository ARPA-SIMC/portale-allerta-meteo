package it.eng.allerta.rest.application.service;

import java.io.IOException;
import java.util.List;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;


@Component(
		immediate = true,
		service = AllertaRestService.class
		)
public class AllertaRestService {

	
	
	public JSONArray getPlace(String placeName) throws IOException {
		
			
		JSONArray citysJSONArray = JSONFactoryUtil.createJSONArray();
		
		DynamicQuery placeQuery = DynamicQueryFactoryUtil.forClass(
				Group.class, PortalClassLoaderUtil.getClassLoader());
		
		Criterion criterion = RestrictionsFactoryUtil.ilike("name",
				StringPool.PERCENT + placeName + StringPool.PERCENT);
		placeQuery.add(criterion);
		
		try {
			long companyId = portal.getDefaultCompanyId();
			
			Group guestGroup = groupLocalService.getGroup(companyId, "Guest");
			List<Group> groups = groupLocalService.dynamicQuery(placeQuery);
			
			_log.debug("====Numero citta trovate========" + groups.size());
			
			for (Group city : groups) {
				String path = city.getTreePath();
				if (path.contains(String.valueOf(guestGroup.getGroupId())) 
						&& !(path.contains("guest"))) {
					
					JSONObject cityJSON = JSONFactoryUtil.createJSONObject();
					cityJSON.put("place", city.getName().toUpperCase());
					cityJSON.put("companyId", city.getCompanyId());
					cityJSON.put("href", "/web" + city.getFriendlyURL());
					
					citysJSONArray.put(cityJSON);
				}
				
				
			}
			

		} catch (Exception e) {
			_log.error(e);
		}
		
		return citysJSONArray;
	}

	@Reference
	private GroupLocalService groupLocalService;
	
	@Reference
	private Portal portal;
	
	private Log _log = LogFactoryUtil.getLog(AllertaRestService.class);
}
