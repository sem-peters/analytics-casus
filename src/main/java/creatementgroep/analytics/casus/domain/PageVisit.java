package creatementgroep.analytics.casus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PageVisit {

	@Id
	@GeneratedValue
	Long id;
	LocalDateTime stamp;
	String url;

	public PageVisit() {
	}

	public PageVisit(LocalDateTime stamp, String url) {
		this.stamp = stamp;
		this.url = url;
	}

	public LocalDateTime getStamp() {
		return stamp;
	}

	public void setStamp(LocalDateTime stamp) {
		this.stamp = stamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PageVisit{" +
				"id=" + id +
				", stamp=" + stamp +
				", url='" + url + '\'' +
				'}';
	}
}
