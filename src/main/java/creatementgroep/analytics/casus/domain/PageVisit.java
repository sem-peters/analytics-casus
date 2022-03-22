package creatementgroep.analytics.casus.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Analytics")
public class PageVisit {


	@Column(name="id")
	@GeneratedValue
	Long id;
	LocalDateTime stamp;
	@Id
	private UUID trackingId;

	@ManyToOne()
	@JoinColumn(name = "webpage")
	private Webpage page;


	public UUID getTrackingId( ) {
		return trackingId;
	}

	public void setTrackingId( UUID trackingId ) {
		this.trackingId = trackingId;
	}
	public PageVisit() {
	}

	public PageVisit(LocalDateTime stamp, UUID trackingId) {
		this.stamp = stamp;
		this.trackingId = trackingId;
	}

	public LocalDateTime getStamp() {
		return stamp;
	}

	public void setStamp(LocalDateTime stamp) {
		this.stamp = stamp;
	}


	@Override
	public String toString() {
		return "PageVisit{" +
				"id=" + id +
				", stamp=" + stamp +
				", webpage='" + trackingId + '\'' +
				'}';
	}
}
