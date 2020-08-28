package it.eng.allerte.custom.jsonRubrica;

import java.util.ArrayList;
import java.util.List;



public class GroupElement {

    private Long id;
    private String name;
    private Long subgroupsCount  = null; // numero di sottogruppi associati
    private Long nominativeCount = null; // numero di contatti associati
    private List<GroupElement> subgroups = new ArrayList<>(); // lista di elementi di tipo GroupElement
	
    //attributi per la costruzione della lista
    private Long parentId;
    private GroupElement parent;
    
    public GroupElement() {
        super();
        this.subgroups = new ArrayList<>();
    }
    
    public GroupElement(Long childId, Long parentId) {
        this.id = childId;
        this.parentId = parentId;
        this.subgroups = new ArrayList<>();
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSubgroupsCount() {
		return subgroupsCount;
	}
	public void setSubgroupsCount(Long subgroupsCount) {
		this.subgroupsCount = subgroupsCount;
	}
	public Long getNominativeCount() {
		return nominativeCount;
	}
	public void setNominativeCount(Long nominativeCount) {
		this.nominativeCount = nominativeCount;
	}
	public List<GroupElement> getSubgroups() {
		return subgroups;
	}
	public void setSubgroups(List<GroupElement> subgroups) {
		this.subgroups = subgroups;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public GroupElement getParent() {
		return parent;
	}
	public void setParent(GroupElement parent) {
		this.parent = parent;
	}
	
	 public void addSubGroup(GroupElement child) {
	       if (!this.subgroups.contains(child) && child != null)
	           this.subgroups.add(child);
	 }
	 
	
		
}
