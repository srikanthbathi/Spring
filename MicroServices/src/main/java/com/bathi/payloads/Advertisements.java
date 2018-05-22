package com.bathi.payloads;

import org.hibernate.validator.constraints.NotBlank;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Add")
public class Advertisements {
 @NotBlank
 private String title;

public String getTitle() {
	return title;
}
@XmlElement
public void setTitle(String title) {
	this.title = title;
}
 
}
