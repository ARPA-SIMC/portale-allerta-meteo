package it.eng.allerte.custom.jsonRubrica;

public class Log {
   
	private String table;
    private String operation;
    private String objectId;
    private String description; //Stringa con dati versione precedente
    private Long editDate;
    private UserInfo editUser;
    
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getEditDate() {
		return editDate;
	}
	public void setEditDate(Long editDate) {
		this.editDate = editDate;
	}
	public UserInfo getEditUser() {
		return editUser;
	}
	public void setEditUser(UserInfo editUser) {
		this.editUser = editUser;
	}
	
    	
}
