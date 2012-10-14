package jb.hw.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public final class LogFormatter extends Formatter {
	private final static SimpleDateFormat date_format = new SimpleDateFormat(
			"MMM dd,yyyy HH:mm");

	public String format(LogRecord record) {
		return date_format.format(new Date()) + " " + record.getLevel() + " "
				+ record.getMessage() + "\r\n";
	}
}
