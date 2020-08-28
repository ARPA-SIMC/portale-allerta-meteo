package it.eng.allerte.custom.jsonRubrica;

import java.util.List;

public class NominativeCreateRequest {

	private String firstName;
    private String lastName;
    private String address;
    private List<Contact> contacts;
    private List<GroupAssociationRequest> groups;
    private Long role;
    private Long group;
    private String specificaRuolo;
    private String email;
    private String telefono;
    private boolean modificaMinore;
    
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public List<GroupAssociationRequest> getGroups() {
		return groups;
	}
	public void setGroups(List<GroupAssociationRequest> groups) {
		this.groups = groups;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public Long getGroup() {
		return group;
	}
	public void setGroup(Long group) {
		this.group = group;
	}
	public String getSpecificaRuolo() {
		return specificaRuolo;
	}
	public void setSpecificaRuolo(String specificaRuolo) {
		this.specificaRuolo = specificaRuolo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isModificaMinore() {
		return modificaMinore;
	}
	public void setModificaMinore(boolean modificaMinore) {
		this.modificaMinore = modificaMinore;
	}
	
    	
}
