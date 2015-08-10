package pl.parser.nbp.service;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.parser.nbp.schema.Currency;
import pl.parser.nbp.schema.PozycjaType;
import pl.parser.nbp.schema.TabelaKursowType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Janik
 */
@Service
public class StatisticsService {

    private Logger LOGGER = Logger.getLogger(StatisticsService.class);

    private final static int SCALE = 10;

    public BigDecimal calculateAverageValue(List<TabelaKursowType> list, Currency currency) {
        BigDecimal sum = BigDecimal.ZERO;
        int count = 0;
        for (TabelaKursowType tabela : list) {
            for (PozycjaType pozycja : tabela.getPozycja()) {
                if(!isValidCurrency(pozycja, currency)) {
                    continue;
                }
                LOGGER.debug("Add: " + pozycja.getKursKupna());
                sum = sum.add(BigDecimal.valueOf(Double.valueOf(pozycja.getKursKupna().replace(",", "."))));
                ++count;
            }
        }
        return sum.divide(BigDecimal.valueOf(count), SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public double calculateStandardDeviation(List<TabelaKursowType> list, Currency currency) {
        return new StandardDeviation().evaluate(getKursKupnaArray(list, currency));
    }

    private boolean isValidCurrency(PozycjaType pozycja, Currency currency) {
        return pozycja.getKodWaluty() != null && pozycja.getKodWaluty().equals(currency);
    }

    private double[] getKursKupnaArray(List<TabelaKursowType> list, Currency currency) {
        List<Double> values = new ArrayList<>();
        for (TabelaKursowType tabela : list) {
            for (PozycjaType pozycja : tabela.getPozycja()) {
                if(!isValidCurrency(pozycja, currency)) {
                    continue;
                }
                LOGGER.debug("Add to array: " + pozycja.getKursKupna());
                values.add(Double.valueOf(pozycja.getKursKupna().replace(",", ".")));
            }
        }

        double[] response = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            response[i] = values.get(i);
        }
        return response;
    }
}
