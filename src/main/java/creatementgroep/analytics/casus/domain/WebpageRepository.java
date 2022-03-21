package creatementgroep.analytics.casus.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebpageRepository extends JpaRepository<Webpage, Long> {
	List<Webpage> findAll();

}
