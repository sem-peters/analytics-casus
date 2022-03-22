package creatementgroep.analytics.casus.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AnalyticsRepository  extends JpaRepository<PageVisit, Long> {


}
