package com.github.matschieu.jee.interceptor.validation;

public class Resource {

	@NotNullElement
	private String name;

	@NotNullElement
	private String type;

	private String description;

	public Resource() { }

	public Resource(String name, String type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append("Resource[");
		strb.append("name = ").append(name);
		strb.append(", type = ").append(type);
		strb.append(", description = ").append(description);
		strb.append("]");
		return strb.toString();
	}

}
