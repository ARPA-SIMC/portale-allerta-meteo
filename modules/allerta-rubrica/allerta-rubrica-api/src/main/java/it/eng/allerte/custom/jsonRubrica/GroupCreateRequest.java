package it.eng.allerte.custom.jsonRubrica;

public class GroupCreateRequest {

    private String name;
    private Long ownerId;
    // per il momento non inseriamo le note
    //private String note; 
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
//	public String getNote() {
//		return note;
//	}
//	public void setNote(String note) {
//		this.note = note;
//	}
        	
}
