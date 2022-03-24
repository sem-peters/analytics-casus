package creatementgroep.analytics.casus.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name="analytics")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PageVisit {

	@Id
	@GeneratedValue
	Long id;
	LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "webpage")
	private Website page;

	private String browserName;
	private String deviceName;
	private String operatingSystem;
	private String internetProtocol;

	public PageVisit(LocalDateTime timestamp, Website page) {
		this.timestamp = timestamp;
		this.page = page;
	}


	@Override
	public String toString() {
		return "PageVisit{" +
				"timestamp=" + timestamp +
				", page=" + page +
				", browserName='" + browserName + '\'' +
				", deviceName='" + deviceName + '\'' +
				", operatingSystem='" + operatingSystem + '\'' +
				", internetProtocol='" + internetProtocol + '\'' +
				'}';
	}
}
