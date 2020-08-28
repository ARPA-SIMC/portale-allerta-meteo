package it.eng.allerte.custom.jsonRubrica;

public class NominativeUpdateRequest {
	
	private String firstName;
    private String lastName;
    private String address;
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
	public boolean isModificaMinore() {
		return modificaMinore;
	}
	public void setModificaMinore(boolean modificaMinore) {
		this.modificaMinore = modificaMinore;
	}
	
    
}
