package pl.parser.nbp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.parser.nbp.schema.TabelaKursowType;
import pl.parser.nbp.utils.DateUtils;

/**
 * @author Piotr Janik
 */
@Service
public class RestService {

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
    public String getFileList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.nbp.pl/kursy/xml/dir.txt", String.class);

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
        ArrayList<String> response = new ArrayList<String>();
        // remove BOM
        String fileList = getFileList().substring(3);
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

        return response;
    }

}
