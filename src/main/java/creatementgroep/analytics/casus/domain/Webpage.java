package creatementgroep.analytics.casus.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class Webpage {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private UUID trackingId = UUID.randomUUID( );

}
