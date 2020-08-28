package it.eng.allerte.custom.jsonRubrica;

public class ContactRequest {

	private Long nominativeId;
    private Long channelId;
    private String value;
    private boolean warning;
    private Long expiredDate;
    private boolean modificaMinore;
    
	public Long getNominativeId() {
		return nominativeId;
	}
	public void setNominativeId(Long nominativeId) {
		this.nominativeId = nominativeId;
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
	public boolean isModificaMinore() {
		return modificaMinore;
	}
	public void setModificaMinore(boolean modificaMinore) {
		this.modificaMinore = modificaMinore;
	}
		
}
