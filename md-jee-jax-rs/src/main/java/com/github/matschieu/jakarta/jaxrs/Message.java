package com.github.matschieu.jakarta.jaxrs;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement()
@XmlType
@SuppressWarnings("serial")
public class Message implements Serializable {

	private String content;

	public Message() {
		// Needed for JSon/XML binding
	}

	public Message(String content) {
		this.content = content;
	}

	@XmlAttribute
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
