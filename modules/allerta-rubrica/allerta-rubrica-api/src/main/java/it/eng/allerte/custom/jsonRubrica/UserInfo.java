package it.eng.allerte.custom.jsonRubrica;


//@JsonPropertyOrder({"id", "firstName", "lastName"})
public class UserInfo {

	private Long id;
	private String lastName;
	private String firstName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
	
	
	
}
