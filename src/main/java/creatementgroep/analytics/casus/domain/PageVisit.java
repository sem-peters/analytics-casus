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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Website getPage() {
		return page;
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
