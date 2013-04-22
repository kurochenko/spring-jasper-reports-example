package net.kurochenko.jr.web;

import net.kurochenko.jr.model.LogEntry;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author kurocenko
 */
@Controller
@RequestMapping("/")
public class JasperReportsController {

	private static final String JASPER_REPORT_LOGS_KEY = "logsReport";

	@RequestMapping
	public ModelAndView renderPdf() {

		JRDataSource dataSource = new JRBeanCollectionDataSource(prepareEntries());

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", dataSource);
		parameterMap.put("logTable", dataSource);

		return new ModelAndView(JASPER_REPORT_LOGS_KEY, parameterMap);
	}

	private static List<LogEntry> prepareEntries() {
		List<LogEntry> items = new ArrayList<LogEntry>();

		items.add(newLogEntry("TypeA", "NameA", "255.255.255.200", new Date(System.currentTimeMillis())));
		items.add(newLogEntry("TypeB", "NameB", "255.255.255.201", new Date(System.currentTimeMillis())));
		items.add(newLogEntry("TypeC", "NameC", "255.255.255.202", new Date(System.currentTimeMillis())));
		items.add(newLogEntry("TypeD", "NameD", "255.255.255.203", new Date(System.currentTimeMillis())));

		return items;
	}

	private static LogEntry newLogEntry(String logType, String name, String ip, Date date) {
		LogEntry logEntry = new LogEntry();
		logEntry.setLogType(logType);
		logEntry.setName(name);
		logEntry.setIp(ip);
		logEntry.setDate(date);

		return logEntry;
	}

}
