package whz.pti.eva.pizzaservice.security.boundary;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.service.CustomerService;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;
import whz.pti.eva.pizzaservice.security.domain.CurrentUser;
import whz.pti.eva.pizzaservice.security.domain.CurrentUserDTO;

@ControllerAdvice
public class CurrentUserControllerAdvice
{
    @Autowired
    private CustomerService customerService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

    @ModelAttribute("CurrentUserInfo")
    public CurrentUserDTO getCurrentUser(Authentication authentication) throws UserCustomerNotFoundException
    {
	CurrentUser user = (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
	if (user != null)
	{
	    Optional<Customer> cus = customerService.getCurrentCustomer();
	    if (cus.isPresent())
	    {
		return new  CurrentUserDTO(cus.get(),cus.get().getEmail(),true);
	    }

	}
	return new  CurrentUserDTO(null,"",false);
	
    }

}
