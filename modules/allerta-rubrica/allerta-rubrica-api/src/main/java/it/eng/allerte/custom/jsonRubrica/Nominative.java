package it.eng.allerte.custom.jsonRubrica;

import java.util.List;

public class Nominative {

	private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String role;
    private String specificaRuolo;
    private String owner;
    private String createUser;
    private String modifyUser;
    private Long lastEdit;
    private boolean modificaMinore;
    private List<Contact> contacts; // lista di contatti del nominativo
    private List<Group> groups; //lista di gruppi associati al nominativo
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Long getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Long lastEdit) {
		this.lastEdit = lastEdit;
	}
	public String getSpecificaRuolo() {
		return specificaRuolo;
	}
	public void setSpecificaRuolo(String specificaRuolo) {
		this.specificaRuolo = specificaRuolo;
	}
	public boolean isModificaMinore() {
		return modificaMinore;
	}
	public void setModificaMinore(boolean modificaMinore) {
		this.modificaMinore = modificaMinore;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	  	
}
