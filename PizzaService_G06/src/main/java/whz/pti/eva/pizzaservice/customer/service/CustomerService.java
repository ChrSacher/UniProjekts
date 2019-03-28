
package whz.pti.eva.pizzaservice.customer.service;

import java.util.List;
import java.util.Optional;

import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdressForm;
import whz.pti.eva.pizzaservice.pizza.boundary.UserCustomerNotFoundException;
import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;

public interface CustomerService
{
    public List<Customer> listAllCustomers();
    public void createCustomer(UserCreateForm form);
    public Optional<Customer> findCustomerByEmail(String Email);
    Optional<Customer> getCurrentCustomer() throws UserCustomerNotFoundException;
    public void addAdressToCustomer(Customer cus,DeliveryAdress adress);
    public Optional<Customer> findCustomerbyID(Long ID);
    public void removeAdressFromCustomerByID(Customer cus, Long ID);
    public void updateAdressFromCustomerByID(Customer cus, DeliveryAdressForm adress, Long ID);
}