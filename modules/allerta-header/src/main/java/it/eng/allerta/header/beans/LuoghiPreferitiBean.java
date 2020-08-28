package it.eng.allerta.header.beans;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;

public class LuoghiPreferitiBean {
	
	private long userId;
	private List<Group> elencoGruppiComuni;
	private Integer[] roleIdSite = {29574,75902,75920};
	private boolean flag;
	
	public LuoghiPreferitiBean(long userId) {
		
		this.userId = userId;
		
		elencoGruppiComuni= new ArrayList<Group>();
		
		try {
		
			for (Group a : GroupLocalServiceUtil.getGroups(QueryUtil.ALL_POS , QueryUtil.ALL_POS)) {
				
				if(a.getTreePath().contains("/20181/") && a.getType() == 1 && a.getSite() == true){
				
					flag=false;
					
					for(Integer roleId:roleIdSite) {
						
						if(UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, a.getGroupId(), roleId)){
							flag=true;
							break;
						}
						
					}
					
					if (!flag)
						elencoGruppiComuni.add(a);
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	public List<Group> getElencoGruppiComuni() {
		return elencoGruppiComuni;
	}

}
