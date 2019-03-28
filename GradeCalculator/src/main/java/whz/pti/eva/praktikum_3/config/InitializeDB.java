package whz.pti.eva.praktikum_3.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import whz.pti.eva.praktikum_3.grade.domain.Grade;
import whz.pti.eva.praktikum_3.grade.domain.GradeRepository;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);


    @Autowired
    GradeRepository gradeRepository;

    @PostConstruct
    public void init()  {

            log.debug(" >>> Db initialized");


            DateTimeFormatter germanFormatter =
                    ofLocalizedTime(FormatStyle.MEDIUM)
                            .withLocale(Locale.GERMAN);
            String s = LocalTime.now().minusMinutes(10).format(germanFormatter);

           gradeRepository.save(new Grade("TestLecutre","1.0"));
           gradeRepository.save(new Grade("TestLecutre2","5.0"));
           System.out.println(s);

    }
}
