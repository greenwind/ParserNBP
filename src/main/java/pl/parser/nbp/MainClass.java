package pl.parser.nbp;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.parser.nbp.schema.TabelaKursowType;
import pl.parser.nbp.utils.DateUtils;

/**
 * @author Piotr Janik
 */
public class MainClass {

    public static void main(String[] args) {
        /*if (args.length != 3) {
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
        try{
            dateStart = DateUtils.parseDate(args[1]);
            dateStop = DateUtils.parseDate(args[2]);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid date format. Required: yyyy-MM-dd");
            return;
        }*/

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RestService restService = context.getBean(RestService.class);
        List<String> fileList = restService.getFileNames(DateTime.now().minusDays(10), DateTime.now());
        List<TabelaKursowType> tabelaKursowList = restService.getTabelaKursowList(fileList);

        System.err.println(tabelaKursowList.size());

    }

}
