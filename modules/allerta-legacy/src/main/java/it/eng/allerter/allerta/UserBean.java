package it.eng.allerter.allerta;

public class UserBean {
	
	private String url;
	private String name;
	private String area;
	
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getArea() {
		return area;
	}
	public final void setArea(String area) {
		this.area = area;
	}
	
	public UserBean(String url, String name,String area) {

		this.url = url;
		this.name = name;
		this.area = area;
	}
	
	public UserBean() {
	}

}
