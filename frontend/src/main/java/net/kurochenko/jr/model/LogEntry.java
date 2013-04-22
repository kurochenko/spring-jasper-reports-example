package net.kurochenko.jr.model;

import java.util.Date;

/**
 * @author kurocenko
 */
public class LogEntry {

	private String logType;
	private String name;
	private String ip;
	private Date date;

	public String getLogType() {
		return logType;
	}

	public void setLogType(final String logType) {
		this.logType = logType;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(final String ip) {
		this.ip = ip;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final LogEntry logEntry = (LogEntry) o;

		if (date != null ? !date.equals(logEntry.date) : logEntry.date != null) return false;
		if (ip != null ? !ip.equals(logEntry.ip) : logEntry.ip != null) return false;
		if (logType != null ? !logType.equals(logEntry.logType) : logEntry.logType != null) return false;
		if (name != null ? !name.equals(logEntry.name) : logEntry.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = logType != null ? logType.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (ip != null ? ip.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "LogEntry{" +
				"logType='" + logType + '\'' +
				", name='" + name + '\'' +
				", ip='" + ip + '\'' +
				", date='" + date + '\'' +
				"} " + super.toString();
	}
}
