package it.eng.allerte.custom.jsonRubrica;

public class Contact {
    
	private Long id;
    private Long channelId;
    private String value;
    private boolean warning;
    private Long expiredDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isWarning() {
		return warning;
	}
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	public Long getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Long expiredDate) {
		this.expiredDate = expiredDate;
	}
	    
}
