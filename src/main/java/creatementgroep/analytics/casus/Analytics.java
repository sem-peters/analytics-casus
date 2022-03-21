package creatementgroep.analytics.casus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Analytics {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "timestamp")
    private LocalDateTime timeStamp;

    @OneToMany(mappedBy = "analytics")
    private Website website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
