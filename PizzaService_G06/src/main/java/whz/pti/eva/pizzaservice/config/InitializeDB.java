package whz.pti.eva.pizzaservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import whz.pti.eva.pizzaservice.customer.domain.CustomerRepository;
import whz.pti.eva.pizzaservice.customer.service.CustomerService;
import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaservice.security.domain.Role;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;
import whz.pti.eva.pizzaservice.security.service.user.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Component
public class InitializeDB
{

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void init()
    {

	log.debug(" >>> Db initialized");

	DateTimeFormatter germanFormatter = ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
	String s = LocalTime.now().minusMinutes(10).format(germanFormatter);

	Pizza marg = new Pizza("margerita");
	marg.addSize(PizzaSize.Small, 1);
	marg.addSize(PizzaSize.Medium, 2);
	marg.addSize(PizzaSize.Large, 3);

	Pizza tr = new Pizza("trage");
	tr.addSize(PizzaSize.Small, 1);
	tr.addSize(PizzaSize.Medium, 2);
	tr.addSize(PizzaSize.Large, 3);

	pizzaRepository.save(marg);
	pizzaRepository.save(tr);

	UserCreateForm form = new UserCreateForm();
	form.setEmail("Admin@gmx.de");
	form.setNickname("Admin");
	form.setPassword("1234");
	form.setPasswordRepeated("1234");
	form.setRole(Role.ADMIN);
	
	userService.create(form);
	customerService.createCustomer(form);
	
	form = new UserCreateForm();
	form.setEmail("User@gmx.de");
	form.setNickname("User");
	form.setPassword("1234");
	form.setPasswordRepeated("1234");
	form.setRole(Role.USER);
	userService.create(form);
	customerService.createCustomer(form);

    }
}
