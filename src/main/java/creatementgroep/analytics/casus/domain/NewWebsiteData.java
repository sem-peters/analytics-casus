package creatementgroep.analytics.casus.domain;

import java.util.UUID;

public class NewWebsiteData {

	private String name;
	private UUID trackinId = UUID.randomUUID();

	public NewWebsiteData(String name, UUID trackinId) {
		this.name = name;
		this.trackinId = trackinId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getTrackinId() {
		return trackinId;
	}

	public void setTrackinId(UUID trackinId) {
		this.trackinId = trackinId;
	}
}
