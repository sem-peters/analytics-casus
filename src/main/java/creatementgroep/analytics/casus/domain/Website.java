package creatementgroep.analytics.casus.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
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

    @NotBlank
    @Column(name="websitenaam", unique = true)
    private String name;


    @Column(name="trackingId")
    private UUID trackingId;

    @ManyToMany
    @JoinTable
    @JsonIgnore
    private List<User> users;

    @Column
    private String url;

    @Column
    private String status;

    @Column
    private LocalDateTime lastChecked;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "page")
    private List<PageVisit> pageVisits = List.of();

    public Website(String name, UUID trackingId, String url, User user) {
        this.name = name;
        this.trackingId = trackingId;
        this.url = url;
        this.users = List.of(user);
    }
}
