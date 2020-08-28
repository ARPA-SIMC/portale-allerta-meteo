package it.eng.allerte.custom.jsonRubrica;

import java.util.ArrayList;
import java.util.List;

public class GroupElementRequest {
	
    private Long id;
    private String name;
    private Long subgroupsCount  = null; // numero di sottogruppi associati
    private Long nominativeCount = null; // numero di contatti associati
    private List<GroupElementRequest> subgroups = new ArrayList<>(); // lista di elementi di tipo GroupElement
	
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
	public List<GroupElementRequest> getSubgroups() {
		return subgroups;
	}
	public void setSubgroups(List<GroupElementRequest> subgroups) {
		this.subgroups = subgroups;
	}
	
    
    

}
