package creatementgroep.analytics.casus.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Website {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "website_generator")
    @SequenceGenerator(name="website_generator", sequenceName = "website_seq")
    private Long id;


    @Column(name="websitenaam", unique = true)
    private String name;


    @Column(name="trackingId")
    private UUID trackingId;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "page")
    private List<PageVisit> pageVisits = List.of();

    private List<User> userList;

    public Website(String name, UUID trackingId) {
        this.name = name;
        this.trackingId = trackingId;
    }

}
