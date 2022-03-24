package creatementgroep.analytics.casus.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewPageVisitData {

    private LocalDateTime timestamp;
    private UUID trackingId;

}
