package com.tres.wedding.spring.config;

import org.springframework.beans.factory.annotation.Value;

public class ConfigurationMgr {

	private static final String ON = "on";

	@Value("${localMachine}")
    private String localMachine;

	public boolean runningOnLocalMachine() {
		return ON.equals(localMachine);
	}

}
