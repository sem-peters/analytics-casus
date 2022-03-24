package creatementgroep.analytics.casus.services;

import creatementgroep.analytics.casus.domain.AnalyticsRepository;
import creatementgroep.analytics.casus.domain.PageVisit;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.Parser;
import ua_parser.UserAgent;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class AnalyticsPageService {


	private AnalyticsRepository ar;

	public AnalyticsPageService(AnalyticsRepository ar) {
		this.ar = ar;
	}

	public void savePageVisit(PageVisit pageVisit, String userAgent, String ipAddress) {
		Parser uaParser = new Parser();
		Client c = uaParser.parse(userAgent);
		pageVisit.setBrowserName(c.userAgent.family);
		pageVisit.setDeviceName(c.device.family);
		pageVisit.setOperatingSystem(c.os.family);

		pageVisit.setInternetProtocol(ipAddress);

		ar.save(pageVisit);
	}

	public List<PageVisit> findAll() {
		return ar.findAll();
	}

	public void writePageVisitsToCSV(Writer writer) {
		List<PageVisit> pageVisits = findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

			csvPrinter.printRecord("Websitenaam" , "Website TrackingID", "Pagevisit Timestamp");
			for (PageVisit pageVisit : pageVisits) {
				csvPrinter.printRecord(pageVisit.getPage().getName(), pageVisit.getPage().getTrackingId(), pageVisit.getTimestamp());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
