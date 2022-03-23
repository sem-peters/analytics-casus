package creatementgroep.analytics.casus.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Website {



    @GeneratedValue
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="websitenaam")
    private String name;


    @Column(name="trackingId")
    private UUID trackingId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "page")
    private List<PageVisit> pageVisits;

    public Website() {
    }

    public Website(String name, UUID trackingId) {
        this.name = name;
        this.trackingId = trackingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(UUID trackingId) {
        this.trackingId = trackingId;
    }

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
    public List<PageVisit> getPageVisits() {
        return pageVisits;
    }


    public void setPageVisits(List<PageVisit> pageVisits) {
        this.pageVisits = pageVisits;
    }

}
