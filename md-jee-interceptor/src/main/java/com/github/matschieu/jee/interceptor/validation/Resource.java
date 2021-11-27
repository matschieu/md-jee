package com.github.matschieu.jee.interceptor.validation;

public class Resource {

	@NotNullElement
	private String name;

	@NotNullElement
	private String type;

	private String description;

	public Resource() {}

	public Resource(final String name, final String type, final String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuilder strb = new StringBuilder();
		strb.append("Resource[");
		strb.append("name = ").append(this.name);
		strb.append(", type = ").append(this.type);
		strb.append(", description = ").append(this.description);
		strb.append("]");
		return strb.toString();
	}

}
