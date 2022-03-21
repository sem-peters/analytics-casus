package creatementgroep.analytics.casus.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsRepository  extends JpaRepository<PageVisit, Long> {

	List<PageVisit> findAll();
	PageVisit save(PageVisit pageVisit);

}
