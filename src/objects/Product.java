package objects;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = -7466514694433955022L;
	
	private long id;
	private long categoryId;
	private String name;
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", description=" + description
				+ "]";
	}
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			return ((Product)obj).id == this.id;
		}
		return false;
	}
	
	
}
