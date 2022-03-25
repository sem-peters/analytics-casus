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

    @ManyToMany
    @JoinTable
    private List<User> users;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "page")
    private List<PageVisit> pageVisits = List.of();


    public Website(String name, UUID trackingId, User user) {
        this.name = name;
        this.trackingId = trackingId;
        this.users = List.of(user);
    }

}
