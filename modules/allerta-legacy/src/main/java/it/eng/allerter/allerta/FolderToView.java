package it.eng.allerter.allerta;

public class FolderToView {
	  private String  id;
	  private String title;
	  private String description;
	  private String url;
	  
	
	public FolderToView(String id, String title, String description, String url) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.url = url;
	}

	@Override
	public String toString() {
		return "FolderToView [id=" + id + ", title=" + title + ", description=" + description + ", url=" + url + "]";
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
}
