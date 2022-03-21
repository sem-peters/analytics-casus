package creatementgroep.analytics.casus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "website")
public class Website {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    public Website() {
    }

    public Website(String websiteNaam, Analytics analytics) {
        this.websiteNaam = websiteNaam;
        this.analytics = analytics;
    }

    @Column(name = "websitenaam")
    private String websiteNaam;

    @OneToMany(mappedBy = "website")
    @JoinColumn(name = "analytics_id", referencedColumnName = "id")
    private Analytics analytics;

    public String getWebsiteNaam() {
        return websiteNaam;
    }

    public void setWebsiteNaam(String websiteNaam) {
        this.websiteNaam = websiteNaam;
    }

    public Long getId() {
        return id;
    }

}
