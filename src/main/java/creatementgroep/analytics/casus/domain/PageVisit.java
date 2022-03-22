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

	public PageVisit(LocalDateTime timestamp, Website page) {
		this.timestamp = timestamp;
		this.page = page;
	}

	public PageVisit() {
	}

	public LocalDateTime getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "PageVisit{" +
				"id=" + id +
				", stamp=" + timestamp +
				", webpage='" + '\'' +
				'}';
	}
}
