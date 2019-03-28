package whz.pti.eva.pizzaservice.Cart.service;

import java.util.List;

import whz.pti.eva.pizzaservice.Cart.domain.Item;
import whz.pti.eva.pizzaservice.Cart.domain.Ordered;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;

public interface OrderService
{
    Ordered createOrder(List<Item> items,DeliveryAdress adress,Customer customer);
    List<Ordered> findOrdersByCustomer(Customer customer);
}
