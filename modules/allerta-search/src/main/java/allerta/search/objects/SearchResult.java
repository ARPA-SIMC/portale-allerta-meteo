package allerta.search.objects;

import java.util.Date;
import java.util.Map;

public class SearchResult {
	
	String title;
	String subtitle;
	String link;
	String classes;
	String date;
	String dateForArchival; //data inizio validita
	String pdf;
	Map<String, Object> metadata;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateForArchival() {
		return dateForArchival;
	}
	public void setDateForArchival(String dateForArchival) {
		this.dateForArchival = dateForArchival;
	}
	public Map<String, Object> getMetadata() {
		return metadata;
	}
	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	
}
