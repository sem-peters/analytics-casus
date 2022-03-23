package creatementgroep.analytics.casus.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface WebpageRepository extends JpaRepository<Website, Long> {

	Website findByTrackingId(UUID trackingId);

	Website findByName(String name);



}
