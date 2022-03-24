package creatementgroep.analytics.casus.domain;

import lombok.*;

import javax.persistence.Column;
import java.util.UUID;



@NoArgsConstructor
public class NewWebsiteData {

	@Getter
	@Setter
	private String name;

	public NewWebsiteData(String name) {
		this.name = name;
	}
//
//
//	public NewWebsiteData() {
//	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
