package creatementgroep.analytics.casus.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="analytics")
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

	public PageVisit() {
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Website getPage() {
		return page;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
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
