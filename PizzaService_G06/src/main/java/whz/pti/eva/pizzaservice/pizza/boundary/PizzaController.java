package whz.pti.eva.pizzaservice.pizza.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.pizzaservice.Cart.service.ShoppingCartService;
import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaservice.pizza.service.PizzaService;

@Controller
public class PizzaController
{
	@Autowired
	private PizzaService pizzaService;

	

	private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);

	@RequestMapping(value = { "/","/buyPizzas"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String buyPizzas(Model model)
	{
		model.addAttribute("Pizzas", pizzaService.findAllAsDTO());
		logger.info("Request for list of pizzas");
		return "pizza";
	}

	
	

}
