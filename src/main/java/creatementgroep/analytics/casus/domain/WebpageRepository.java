package creatementgroep.analytics.casus.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface WebpageRepository extends JpaRepository<Website, Long> {

	Website findByTrackingId(UUID trackingId);
	List<Website> findByUsersContaining(User user);

	@Query("SELECT w FROM Website w WHERE w.url <> '' AND w.url IS NOT NULL")
	List<Website> findAllByUrl();


}

