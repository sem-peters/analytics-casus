package creatementgroep.analytics.casus.domain;

import java.util.UUID;

public class NewWebsiteData {

	private String name;

	public NewWebsiteData(String name) {
		this.name = name;
	}

	public NewWebsiteData() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
