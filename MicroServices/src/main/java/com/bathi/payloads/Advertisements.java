package com.bathi.payloads;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Advertisements {
 @NotBlank
 private String title;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}
 
}
