package creatementgroep.analytics.casus.domain;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewWebsiteData {


	private String name;
	@URL
	private String url;

	@Override
	public String toString() {
		return "NewWebsiteData{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
