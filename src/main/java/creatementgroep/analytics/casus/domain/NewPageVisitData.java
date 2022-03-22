package creatementgroep.analytics.casus.domain;

import java.time.LocalDateTime;
import java.util.UUID;


public class NewPageVisitData {

    public LocalDateTime getTimestamp( ) {
        return timestamp;
    }

    public void setTimestamp( LocalDateTime timestamp ) {
        this.timestamp = timestamp;
    }

    private LocalDateTime timestamp;


    public UUID getTrackingId( ) {
        return trackingId;
    }

    public void setTrackingId( UUID trackingId ) {
        this.trackingId = trackingId;
    }

    private UUID trackingId;


    public NewPageVisitData( LocalDateTime timestamp, UUID trackingId ) {
        this.timestamp = timestamp;
        this.trackingId = trackingId;
    }

    public NewPageVisitData() {

    }
}
