package whz.pti.eva.pizzaservice.customer.boundary;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressFormValidator;
import whz.pti.eva.pizzaservice.customer.service.CustomerService;

import whz.pti.eva.pizzaservice.customer.service.UserCustomerEvaluator;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressForm;
import whz.pti.eva.pizzaservice.pizza.boundary.PizzaController;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserCustomerEvaluator userCustomerEvaluator;

	
	private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);

	private DeliveryAdressFormValidator adressValidator;

	@InitBinder("DeliveryAdressForm")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(adressValidator);
	}

	@RequestMapping(value = "/Customer/login", method = RequestMethod.GET)
	public String buyPizzas(Model model) {

		return "pizza";
	}

	@RequestMapping(value = "/adress", method = RequestMethod.POST)
	public String showAdress(Model model) {
		model.addAttribute("DeliveryAdressForm", new DeliveryAdressForm());
		return "fragments/adress";
	}

	@RequestMapping(value = "/createDeliveryAdress", method = RequestMethod.POST)
	public String handleDeliveryAdressForm(@Valid @ModelAttribute("DeliveryAdressForm") DeliveryAdressForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) throws UserCustomerNotFoundException {
		logger.info("Processing user create form= " + form + " bindingResult= " + bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("LastForm", form);
			model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
			return "OrderSelectAdress";
		}

		Optional<Customer> cus = customerService.getCurrentCustomer();

		if (cus.isPresent()) 
		{
		    	DeliveryAdress adress = form.toAdress();
			customerService.addAdressToCustomer(cus.get(), adress);
			return "redirect:/buyPizzas";
		}
		return "redirect:/buyPizzas";
	}

	@PreAuthorize("@userCustomerEvaluator.isUserCustomer(#customerID, principal.id) or hasAuthority('ADMIN')")
	@RequestMapping(value = "/customer/{customerID}", method = { RequestMethod.GET, RequestMethod.POST })
	public String showCustomerPage(@PathVariable("customerID") Long customerID, Model model)
			throws UserCustomerNotFoundException {
		// fetch order
		Optional<Customer> cus = customerService.findCustomerbyID(customerID);
		if (cus.isPresent()) {
			model.addAttribute("Customer", cus.get());
			model.addAttribute("Adresses", cus.get().getDeliveryAddresses());
			model.addAttribute("DeliveryAdressForm", new DeliveryAdressForm());
			return "UserMainpage";
		}
		return "redirect:/buyPizzas";
	}

//	@PreAuthorize("@userCustomerEvaluator.isUserCustomer(#customerID, principal.id) or hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteAdress", method = RequestMethod.POST)
	public String deleteAdress(@RequestParam Long customerId, @RequestParam Long adressID, Model model)
			throws UserCustomerNotFoundException {
		// fetch order
		Optional<Customer> cus = customerService.findCustomerbyID(customerId);
		if (cus.isPresent()) {
			customerService.removeAdressFromCustomerByID(cus.get(), adressID);
			return "redirect:/customer/" +customerId;
		}
		return "redirect:/buyPizzas";
	}

	// @PreAuthorize("@userCustomerEvaluator.isUserCustomer(#customerID,
	// principal.id) or hasAuthority('ADMIN')")
	@RequestMapping(value = "/changeAdress", method = RequestMethod.POST)
	public String changeAdress(@RequestParam Long customerId, @RequestParam Long adressID,
			@Valid @ModelAttribute("DeliveryAdressForm") DeliveryAdressForm form, BindingResult bindingResult, 
			Model model, HttpServletRequest request) throws UserCustomerNotFoundException {
		logger.info("Processing user create form= " + form + " bindingResult= " + bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("LastForm", form);
			model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
			return "OrderSelectAdress";
		}
		
		Optional<Customer> cus = customerService.findCustomerbyID(customerId);
		if (cus.isPresent()) {
			customerService.updateAdressFromCustomerByID(cus.get(), form, adressID);
			return "redirect:/customer/" +customerId;
		}
		return "redirect:/buyPizzas";
	}

}