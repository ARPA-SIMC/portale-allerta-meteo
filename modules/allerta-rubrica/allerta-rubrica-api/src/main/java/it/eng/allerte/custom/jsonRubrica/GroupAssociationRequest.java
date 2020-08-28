package it.eng.allerte.custom.jsonRubrica;

public class GroupAssociationRequest {

	private Long id;
	private Long roleId;
	private String specificaRuolo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getSpecificaRuolo() {
		return specificaRuolo;
	}
	public void setSpecificaRuolo(String specificaRuolo) {
		this.specificaRuolo = specificaRuolo;
	}

}
