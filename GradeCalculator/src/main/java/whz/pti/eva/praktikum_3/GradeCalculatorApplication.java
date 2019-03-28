package whz.pti.eva.praktikum_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GradeCalculatorApplication {

	private static final Logger logger = LoggerFactory.getLogger(GradeCalculatorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GradeCalculatorApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() 
    {
    	//System.out.println(helloService.setMyMessage("peter"));
    	
    	logger.trace("A TRACE Message");
    	logger.debug("A DEBUG Message");
    	logger.info("An INFO Message");
    	logger.warn("A WARN Message");
    	logger.error("An ERROR Message");
    	logger.info("an info log with {}, {} and {} arguments", 1, "2",
    			3.0);
    	
        return (evt) ->
        {
        	System.out.println("Hallo Welt");
        	
        };
    }
}
