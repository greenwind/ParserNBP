package pl.parser.nbp.service;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.parser.nbp.schema.TabelaKursowType;
import pl.parser.nbp.utils.DateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piotr Janik
 */
@Service
public class RestService {

   private Logger LOGGER = Logger.getLogger(RestService.class);

    // 'xnnnzrrmmdd.xml'
    // x = c kurs kupna sprzedarzy
    // nnn – trzyznakowy (liczbowy) numer tabeli w roku;
    // z = stała
    // rrmmdd
    private static final String GROUP_DATE = "date";
    private static final String FILE_NAME = "c(?<number>[\\d]{3})z(?<date>[\\d]{6})";
    private static final Pattern PATTERN = Pattern.compile(FILE_NAME);

    /**
     * GET file http://www.nbp.pl/kursy/xml/dir.txt as string with BOM
     * @return
     */
    public String getFileList(DateTime dateStart, DateTime dateStop) {
        RestTemplate restTemplate = new RestTemplate();
        DateTime now = DateTime.now();
        if (DateUtils.isSameYearAsNow(dateStart) && DateUtils.isSameYearAsNow(dateStop)) {
            LOGGER.debug("Getting file http://www.nbp.pl/kursy/xml/dir.txt");
            // remove BOM
            return restTemplate.getForObject("http://www.nbp.pl/kursy/xml/dir.txt", String.class).substring(3);
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = dateStart.getYear(); i <= dateStop.getYear(); ++i) {
                String value = null;
                if (DateUtils.isSameYearAsNow(dateStart) || DateUtils.isSameYearAsNow(dateStop)) {
                    LOGGER.debug("Getting file http://www.nbp.pl/kursy/xml/dir.txt");
                    value = restTemplate.getForObject("http://www.nbp.pl/kursy/xml/dir.txt", String.class).substring(3);
                } else {
                    LOGGER.debug("http://www.nbp.pl/kursy/xml/dir" + i + ".txt");
                    value = restTemplate.getForObject("http://www.nbp.pl/kursy/xml/dir" + i + ".txt", String.class).substring(3);
                }
                builder.append(value);
            }
            return builder.toString();
        }
    }

    /**
     * GET file with xml by file
     * @param fileString - file name without xml
     * @return TabelaKursowType
     */
    public TabelaKursowType getTabelaKursow(String fileString) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.nbp.pl/kursy/xml/" + fileString + ".xml", TabelaKursowType.class);
    }

    /**
     * GET files with xml by file list
     * @param fileNames
     * @return
     */
    public List<TabelaKursowType> getTabelaKursowList(List<String> fileNames) {
        List<TabelaKursowType> response = new ArrayList<TabelaKursowType>(fileNames.size());
        for (String fileName : fileNames) {
            response.add(getTabelaKursow(fileName));
        }
        return response;
    }

    /**
     * Get file names between dates
     * @param dateStart
     * @param dateStop
     * @return
     */
    public List<String> getFileNames(DateTime dateStart, DateTime dateStop) {
        // inclusive
        dateStart = dateStart.minusDays(1);
        dateStop = dateStop.plusDays(1);
        ArrayList<String> response = new ArrayList<String>();
        // remove BOM
        String fileList = getFileList(dateStart, dateStop);
        for (String fileName: fileList.split("\\r\\n")) {
            Matcher matcher = PATTERN.matcher(fileName);
            if(!matcher.matches()) {
                continue;
            }

            String group = matcher.group(GROUP_DATE);
            DateTime fileDateTime = DateUtils.parseShortDate(group);
            if (fileDateTime.isAfter(dateStart) && fileDateTime.isBefore(dateStop)) {
                response.add(fileName);
            }
        }
        LOGGER.debug("Selected files:" + Arrays.toString(response.toArray()));
        return response;
    }

}
