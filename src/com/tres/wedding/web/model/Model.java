package com.tres.wedding.web.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Model implements Serializable {

	private static final long serialVersionUID = -6859644693030314247L;

	public String toLog() {
		return ReflectionToStringBuilder.toStringExclude(this, "password");
	}

}
