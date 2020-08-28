package it.eng.allerte.custom.jsonRubrica;

public class LiferayRoleRequest {

	private Long id;
	private String name;
	private LiferayRolePermission permission ;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LiferayRolePermission getPermission() {
		return permission;
	}
	public void setPermission(LiferayRolePermission permission) {
		this.permission = permission;
	}
			
}
