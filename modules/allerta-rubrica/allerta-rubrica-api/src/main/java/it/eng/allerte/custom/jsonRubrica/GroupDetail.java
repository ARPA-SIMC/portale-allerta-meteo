package it.eng.allerte.custom.jsonRubrica;

import java.util.ArrayList;
import java.util.List;


//@JsonPropertyOrder({"id", "name", "owner", "lastEdit", "lastEditUser", "subgroups", "nominatives", "subgroupsCount", "nominativeCount"})
public class GroupDetail {
	
	private Long id;
    private String name;
    private Owner owner;
    private Long lastEdit;
    private UserInfo lastEditUser;
    private List<GroupDetail> subgroups = new ArrayList<>();// lista di elementi di tipo GroupDetail
    private List<Nominative> nominatives = new ArrayList<>(); // lista di elementi di tipo Nominative
    private Long subgroupsCount; // numero di sottogruppi associati
    private Long nominativeCount; // numero di contatti associati
    
    
    //attributi per la costruzione della lista
    private Long parentId;

    private GroupDetail parent;
    
    private List<GroupDetail> supergroups = new ArrayList<>();
    private Long supergroupsCount;
    
    public GroupDetail() {
        super();
        this.subgroups = new ArrayList<>();
    }
    
    public GroupDetail(Long childId, Long parentId) {
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
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Long getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Long lastEdit) {
		this.lastEdit = lastEdit;
	}

	public UserInfo getLastEditUser() {
		return lastEditUser;
	}

	public void setLastEditUser(UserInfo lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public List<GroupDetail> getSubgroups() {
		return subgroups;
	}
	public void setSubgroups(List<GroupDetail> subgroups) {
		this.subgroups = subgroups;
	}
	
	public List<Nominative> getNominatives() {
		return nominatives;
	}

	public void setNominatives(List<Nominative> nominatives) {
		this.nominatives = nominatives;
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
			
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public GroupDetail getParent() {
		return parent;
	}

	public void setParent(GroupDetail parent) {
		this.parent = parent;
	}

	public void addSubGroup(GroupDetail child) {
	       if (!this.subgroups.contains(child) && child != null)
	           this.subgroups.add(child);
	 }

	public List<GroupDetail> getSupergroups() {
		return supergroups;
	}

	public void setSupergroups(List<GroupDetail> supergroups) {
		this.supergroups = supergroups;
	}

	public Long getSupergroupsCount() {
		return supergroupsCount;
	}

	public void setSupergroupsCount(Long supergroupsCount) {
		this.supergroupsCount = supergroupsCount;
	}
    
}
