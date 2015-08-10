package pl.parser.nbp.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author Piotr Janik
 */
public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT);

    public static DateTime parseDate(String dateString) {
        return DATE_TIME_FORMATTER.parseDateTime(dateString);
    }
}
