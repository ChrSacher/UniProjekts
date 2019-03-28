package whz.pti.eva.pizzaservice.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.CustomerRepository;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAddressRepository;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressForm;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;
import whz.pti.eva.pizzaservice.security.domain.CurrentUser;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeliveryAddressRepository repo;

    @Override
    public List<Customer> listAllCustomers()
    {
	return customerRepository.findAll();
    }

    @Override
    public void createCustomer(UserCreateForm form)
    {
	Customer x = new Customer();
	x.setEmail(form.getEmail());
	customerRepository.save(x);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email)
    {
	return Optional.ofNullable(customerRepository.findByEmail(email));
    }

    @Override
    public Optional<Customer> getCurrentCustomer() throws UserCustomerNotFoundException
    {
	CurrentUser current = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (current == null)
	{
	    return Optional.ofNullable(null);
	} else
	{
	    Optional<Customer> cus = findCustomerByEmail(current.getEmail());
	    if (cus.isPresent())
	    {
		return cus;
	    } else
	    {
		throw (new UserCustomerNotFoundException("Customer could not be found", current.getEmail(), ""));

	    }

	}
    }

    @Override
    public void addAdressToCustomer(Customer cus, DeliveryAdress adress)
    {
	repo.save(adress);
	cus.addAdress(adress);
	customerRepository.save(cus);
    }

    @Override
    public Optional<Customer> findCustomerbyID(Long ID)
    {
	return customerRepository.findById(ID);
    }

    @Override
    public void removeAdressFromCustomerByID(Customer cus, Long ID)
    {
	Optional<DeliveryAdress> a = cus.getAdressById(ID);
	if (a.isPresent())
	{
	    cus.removeAdress(a.get());
	    repo.delete(a.get());
	    customerRepository.save(cus);
	}

    }

    @Override
    public void updateAdressFromCustomerByID(Customer cus, DeliveryAdressForm adress, Long ID)
    {
	Optional<DeliveryAdress> x = cus.updateAdress(adress, ID);
	if(x.isPresent())
	{
	    repo.save(x.get());
	}
	customerRepository.save(cus);
    }

}
