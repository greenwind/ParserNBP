package pl.parser.nbp;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
import pl.parser.nbp.schema.RestService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Piotr Janik
 */
public class MainClass {

    public static void main(String[] args) {
/*        if (args.length != 3) {
            // TODO komunikat
            return;
        }

        Currency currency = Currency.valueOf(args[0]);
        DateTime dateStart = DateUtils.parseDate(args[1]);
        DateTime dateStop = DateUtils.parseDate(args[2]);*/

        // 'xnnnzrrmmdd.xml'
        // x = c kurs kupna sprzedarzy
        // nnn – trzyznakowy (liczbowy) numer tabeli w roku;
        // z = stała
        // rrmmdd

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RestService restService = context.getBean(RestService.class);
        List<String> fileList = restService.getFileNames(DateTime.now().minusDays(2), DateTime.now());
        System.err.println(fileList);

    }

}
