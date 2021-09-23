package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author zyx
 */
public class MyDate {
    public static void main(String[] args) throws ParseException {
        System.out.println(LocalDate.MAX);
        System.out.println((LocalDate.parse("2001-01-01")));
        System.out.println(LocalDate.now());
        System.out.println(System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2001-01-01").getTime());
        System.out.println(LocalDate.of(2001,1,1));
        System.out.println(LocalDate.EPOCH);
        System.out.println(LocalDate.MIN);
    }
}
