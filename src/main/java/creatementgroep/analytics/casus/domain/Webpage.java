package creatementgroep.analytics.casus.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Website")
public class Webpage {

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @GeneratedValue
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="websitenaam")
    private String name;


    @Column(name="trackingId")
    private UUID trackingId;

    @OneToMany(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "trackingId", referencedColumnName = "webpage")
    private List<PageVisit> pageVists;

    public Webpage() {
    }

    public Webpage(String name, UUID trackingId) {
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


}
