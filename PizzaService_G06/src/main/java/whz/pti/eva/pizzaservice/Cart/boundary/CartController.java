package whz.pti.eva.pizzaservice.Cart.boundary;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.pizzaservice.Cart.domain.Ordered;
import whz.pti.eva.pizzaservice.Cart.service.OrderService;
import whz.pti.eva.pizzaservice.Cart.service.ShoppingCartService;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressForm;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressFormValidator;
import whz.pti.eva.pizzaservice.customer.service.CustomerService;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaservice.pizza.service.PizzaService;
import whz.pti.eva.pizzaservice.security.domain.CurrentUser;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;
import whz.pti.eva.pizzaservice.security.service.user.UserService;
import whz.pti.eva.pizzaservice.security.service.validator.UserCreateFormValidator;

@Controller
public class CartController
{

    private CustomerService customerService;

    private OrderService orderService;

    private ShoppingCartService shoppingService;

    private PizzaService pizzaService;

    private DeliveryAdressFormValidator adressValidator;

    @InitBinder("DeliveryAdressForm")
    public void initBinder(WebDataBinder binder)
    {
	binder.addValidators(adressValidator);
    }

    /**
     * @param customerService
     * @param orderService
     * @param shoppingService
     * @param pizzaService
     * @param adressValidator
     */
    @Autowired
    public CartController(CustomerService customerService, OrderService orderService,
	    ShoppingCartService shoppingService, PizzaService pizzaService, DeliveryAdressFormValidator adressValidator)
    {
	super();
	this.customerService = customerService;
	this.orderService = orderService;
	this.shoppingService = shoppingService;
	this.pizzaService = pizzaService;
	this.adressValidator = adressValidator;
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addPizzaToCart(@RequestParam int amount, @RequestParam Long pizzaId, @RequestParam String size)
    {

	shoppingService.addPizza(pizzaService.getById(pizzaId).get(), PizzaSize.fromValue(size), amount);
	return "redirect:/buyPizzas";
    }

    @RequestMapping(value = "/cart", method = { RequestMethod.GET, RequestMethod.POST })
    public String toCart(Model model)
    {

	model.addAttribute("Items", shoppingService.getAllItemsDTO());
	model.addAttribute("Total", shoppingService.getTotal());
	return "cart";
    }

    @RequestMapping(value = "/removeFromCart", method = RequestMethod.POST)
    public String removeFromCart(Model model, @RequestParam Long itemID)
    {

	shoppingService.removeItem(itemID);
	return "redirect:/cart";
    }

    @RequestMapping(value = "/orderCart", method = RequestMethod.POST)
    public String orderFromCart(Model model)
    {

	model.addAttribute("Items", shoppingService.getAllItemsDTO());
	model.addAttribute("Total", shoppingService.getTotal());
	model.addAttribute("DeliveryAdressForm", new DeliveryAdressForm());
	return "OrderSelectAdress";

    }

    @RequestMapping(value = "/finshOrderingWithAdress", method = RequestMethod.POST)
    public String finishOrder(Model model, Authentication authentication,
	    @Valid @ModelAttribute("DeliveryAdressForm") DeliveryAdressForm form, BindingResult bindingResult)
	    throws UserCustomerNotFoundException
    {

	if (bindingResult.hasErrors())
	{
	    model.addAttribute("LastForm", form);
	    model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
	    return "redirect:/orderFromCart";
	}
	DeliveryAdress adress = form.toAdress();
	Optional<Customer> cus = customerService.getCurrentCustomer();
	if (cus.isPresent())
	{
	    customerService.addAdressToCustomer(cus.get(), adress);
	    shoppingService.setDestination(adress);
	    model.addAttribute("Items", shoppingService.getAllItemsDTO());
	    model.addAttribute("Total", shoppingService.getTotal());
	    model.addAttribute("Adress", adress);
	    return "OrderConfirmFinal";
	}

	return "redirect:/buyPizzas";

    }

    @RequestMapping(value = "/finshOrdering", method = RequestMethod.POST)
    public String finishOrder(Model model, Authentication authentication, @RequestParam Long deliveryAdressID) throws UserCustomerNotFoundException
    {
	// User should be logged in by Websecurity
	Optional<Customer> cus = customerService.getCurrentCustomer();
	if (cus.isPresent())
	{
	    Optional<DeliveryAdress> adress = cus.get().getAdressById(deliveryAdressID);
	    if (adress.isPresent())
	    {
		shoppingService.setDestination(adress.get());
		model.addAttribute("Items", shoppingService.getAllItemsDTO());
		model.addAttribute("Total", shoppingService.getTotal());
		model.addAttribute("Adress", adress.get());
		return "OrderConfirmFinal";
	    } else
	    {
		// No Adress was selected

	    }
	}

	return "redirect:/buyPizzas";

    }

    @RequestMapping(value = "/OrderPayment", method = RequestMethod.POST)
    public String payForOrder(Model model, Authentication authentication) throws UserCustomerNotFoundException
    {
	model.addAttribute("Items", shoppingService.getAllItemsDTO());
	model.addAttribute("Total", shoppingService.getTotal());
	model.addAttribute("Adress", shoppingService.getDestination());
	return "OrderPay";

    }

    @RequestMapping(value = "/OrderConfirmed", method = RequestMethod.POST)
    public String thanksForOrdering(Model model, Authentication authentication) throws UserCustomerNotFoundException
    {
	orderService.createOrder(shoppingService.getAllItems(), shoppingService.getDestination(),
	customerService.getCurrentCustomer().get());
	List<Ordered> x = orderService.findOrdersByCustomer(customerService.getCurrentCustomer().get());
	if(x.size() == 0)
	{
	    System.out.println("No actuall orders made");
	}
	model.addAttribute("Items", shoppingService.getAllItemsDTO());
	model.addAttribute("Total", shoppingService.getTotal());
	model.addAttribute("Adress", shoppingService.getDestination());
	return "OrderConfirmed";

    }

    @RequestMapping(value = "/clearCart", method = RequestMethod.POST)
    public String clearCart(Model model)
    {

	shoppingService.removeAll();
	return "redirect:/cart";
    }
}
