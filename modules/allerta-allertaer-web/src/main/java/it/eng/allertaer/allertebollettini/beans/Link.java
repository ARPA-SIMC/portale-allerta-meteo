package it.eng.allertaer.allertebollettini.beans;

import java.io.Serializable;

public class Link implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String url;
	private String name;
	private String date;
	
	
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
	public final String getDate() {
		return date;
	}
	public final void setDate(String date) {
		this.date = date;
	}
	public Link(String url, String name, String date) {
		super();
		this.url = url;
		this.name = name;
		this.date = date;
	}
	
	

}
