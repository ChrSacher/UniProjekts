package whz.pti.eva.pizzaservice.security.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jayway.jsonpath.Option;

import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.service.CustomerService;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;

//Sends general information about the person logged in
public class CurrentUserDTO
{

 

    private Customer customer = null;
    private String email = "";
    private boolean isLoggedIn = false;

    /**
     * @param customer
     * @param email
     * @param isLoggedIn
     */
    public CurrentUserDTO(Customer customer, String email, boolean isLoggedIn)
    {
	super();
	this.customer = customer;
	this.email = email;
	this.isLoggedIn = isLoggedIn;
    }


    /**
     * @return the customer
     */
    public Customer getCustomer()
    {
	return customer;
    }

    /**
     * @param customer
     *            the customer to set
     */
    public void setCustomer(Customer customer)
    {
	this.customer = customer;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
	this.email = email;
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isLoggedIn()
    {
	return isLoggedIn;
    }

    /**
     * @param isLoggedIn
     *            the isLoggedIn to set
     */
    public void setLoggedIn(boolean isLoggedIn)
    {
	this.isLoggedIn = isLoggedIn;
    }

}
