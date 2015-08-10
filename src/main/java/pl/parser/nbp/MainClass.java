package pl.parser.nbp;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.parser.nbp.schema.Currency;
import pl.parser.nbp.schema.TabelaKursowType;
import pl.parser.nbp.service.RestService;
import pl.parser.nbp.service.StatisticsService;
import pl.parser.nbp.utils.DateUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Piotr Janik
 */
public class MainClass {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments. Required: 3");
            return;
        }

        Currency currency = null;
        DateTime dateStart = null;
        DateTime dateStop = null;

        try {
            currency = Currency.valueOf(args[0]);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid currency. Required: USD, EUR, CHF, GBP");
            return;
        }
        try {
            dateStart = DateUtils.parseDate(args[1]);
            dateStop = DateUtils.parseDate(args[2]);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid date format. Required: yyyy-MM-dd");
            return;
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        RestService restService = context.getBean(RestService.class);
        StatisticsService statisticsService = context.getBean(StatisticsService.class);

        List<String> fileList = restService.getFileNames(dateStart, dateStop);
        List<TabelaKursowType> tabelaKursowList = restService.getTabelaKursowList(fileList);

        BigDecimal average = statisticsService.calculateAverageValue(tabelaKursowList, currency);
        double deviation = statisticsService.calculateStandardDeviation(tabelaKursowList, currency);

        System.out.println("Average: " + average);
        System.out.println("Standard deviation: " + deviation);

    }

}
