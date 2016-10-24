package com.tres.wedding.web.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

class Model {

	public String toLog() {
		return ReflectionToStringBuilder.toStringExclude(this, "password");
	}

}
