package it.eng.allerte.custom.jsonRubrica;


//@JsonPropertyOrder({"id", "name"})
public class Owner {
	 
	private Long id;
	
	//@JsonInclude(Include.NON_NULL)
    private String name = "";
	
	   
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
    
}
