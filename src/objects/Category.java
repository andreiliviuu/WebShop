package objects;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 6489472512341807202L;
	
	private long id;
	private String name;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int hashCode() {
		return Long.hashCode(this.id);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Category) {
			return ((Category)obj).id == this.id;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description
				+ "]";
	}
}
