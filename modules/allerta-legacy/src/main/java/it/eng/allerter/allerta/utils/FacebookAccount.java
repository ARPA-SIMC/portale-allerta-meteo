package it.eng.allerter.allerta.utils;

public class FacebookAccount {
	private String faceId;
	private String facePass;
	private String token;
	
	public FacebookAccount() {
	}
	
	public FacebookAccount(String faceId, String facePass, String token) {
		this.faceId = faceId;
		this.facePass = facePass;
		this.token = token;
	}
	public String getFaceId() {
		return faceId;
	}
	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
	public String getFacePass() {
		return facePass;
	}
	public void setFacePass(String facePass) {
		this.facePass = facePass;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
