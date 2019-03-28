package whz.pti.eva.pizzaservice.customer.service;

import org.springframework.stereotype.Component;

import whz.pti.eva.pizzaservice.Cart.service.ShoppingCartService;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.security.service.dto.UserDTO;
import whz.pti.eva.pizzaservice.security.service.user.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

@Component(value="userCustomerEvaluator")
public class UserCustomerEvaluator {
	
	@Autowired
	private CustomerService cs;
	@Autowired
	private UserService us;
	@Autowired
	private ShoppingCartService ss;
	public Boolean isUserCustomer(Long CustomerID, Long UserID)
	{
		Optional<Customer> c = cs.findCustomerbyID(CustomerID);
		UserDTO u = us.getUserById(UserID);
		
		if (c.isPresent())
		{
			if (c.get().getEmail().equals(u.getEmail()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isCartEmpty()
	{
	    return ss.getAllItems().isEmpty();
	    
	}
}
