package it.eng.allerte.custom.jsonRubrica;

import java.util.ArrayList;
import java.util.List;

public class LiferayRolePermissionUpdateRequest {
	
	private List<String> permissionId = new ArrayList<>();

	public List<String> getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(List<String> permissionId) {
		this.permissionId = permissionId;
	}
			
}
