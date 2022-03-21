package creatementgroep.analytics.casus.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PageVisit {

	@Id
	@GeneratedValue
	Long id;
	LocalDateTime stamp;
	Webpage page;


	public Webpage getPage() {
		return page;
	}


	public PageVisit() {
	}

	public PageVisit(LocalDateTime stamp, Webpage page) {
		this.stamp = stamp;
		this.page = page;
	}

	public LocalDateTime getStamp() {
		return stamp;
	}

	public void setStamp(LocalDateTime stamp) {
		this.stamp = stamp;
	}

	public Webpage getWebpage() {
		return page;
	}

	public void setUrl(Webpage page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageVisit{" +
				"id=" + id +
				", stamp=" + stamp +
				", webpage='" + page + '\'' +
				'}';
	}
}
