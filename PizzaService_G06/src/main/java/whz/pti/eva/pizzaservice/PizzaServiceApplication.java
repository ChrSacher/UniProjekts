package whz.pti.eva.pizzaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaServiceApplication
{

	private static final Logger logger = LoggerFactory.getLogger(PizzaServiceApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(PizzaServiceApplication.class, args);
	}
	
	@Bean
        CommandLineRunner init() 
        {

        	
            return (evt) ->
            {
        	System.out.println("Hallo Welt");
            	
            };
        }
}
