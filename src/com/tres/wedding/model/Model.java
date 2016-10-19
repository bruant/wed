package com.tres.wedding.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Abstract class of all data transfer object between database access and controller layer.
 * @author Peter_Trestyanszki
 */
public abstract class Model {

	protected String toLog() {
		return ReflectionToStringBuilder.toString(this);
	}

}
