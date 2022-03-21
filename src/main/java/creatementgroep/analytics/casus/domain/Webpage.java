package creatementgroep.analytics.casus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Webpage {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private UUID trackingId = UUID.randomUUID();

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
