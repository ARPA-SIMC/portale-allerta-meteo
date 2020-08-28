package it.eng.allerte.custom.jsonRubrica;

import java.util.ArrayList;
import java.util.List;

public class UserInfoLogin {

	private Long userId;
	private Long currentSiteId;
	private String firstName;
	private String lastName;
	private String currentSiteName;
	private boolean permission;
	private boolean read;
	private boolean write;
	//private List<RolePermission> rolePermission = new ArrayList<>();

	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCurrentSiteId() {
		return currentSiteId;
	}
	public void setCurrentSiteId(Long currentSiteId) {
		this.currentSiteId = currentSiteId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCurrentSiteName() {
		return currentSiteName;
	}
	public void setCurrentSiteName(String currentSiteName) {
		this.currentSiteName = currentSiteName;
	}
	public boolean isPermission() {
		return permission;
	}
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
		
//	public List<RolePermission> getRolePermission() {
//		return rolePermission;
//	}
//	public void setRolePermission(List<RolePermission> rolePermission) {
//		this.rolePermission = rolePermission;
//	}
			
}
