package it.eng.radarMeteo.bean;

public class RecentStazValue {
	private String idstazione;
	private Double value;
	private Long lat;
	private Long lon;
	public String getIdstazione() {
		return idstazione;
	}
	public void setIdstazione(String idstazione) {
		this.idstazione = idstazione;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Long getLat() {
		return lat;
	}
	public void setLat(Long lat) {
		this.lat = lat;
	}
	public Long getLon() {
		return lon;
	}
	public void setLon(Long lon) {
		this.lon = lon;
	}
	
	public static RecentStazValue transformObject(Object[] objects){
		RecentStazValue recent = new RecentStazValue();
		recent.setIdstazione((String)objects[0]);
		recent.setValue((Double)objects[1]);
		recent.setLat((Long)objects[2]);
		recent.setLon((Long)objects[3]);
	return recent;
	}

}
