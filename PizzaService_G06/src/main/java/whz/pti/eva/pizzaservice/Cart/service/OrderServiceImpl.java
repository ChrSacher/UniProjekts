package whz.pti.eva.pizzaservice.Cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import whz.pti.eva.pizzaservice.Cart.domain.Item;
import whz.pti.eva.pizzaservice.Cart.domain.Ordered;
import whz.pti.eva.pizzaservice.Cart.domain.OrderedItem;
import whz.pti.eva.pizzaservice.Cart.domain.OrderedRepository;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;

@Service
@Transactional
public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderedRepository orderRepository;
    
    @Override
    public Ordered createOrder(List<Item> items,DeliveryAdress adress,Customer customer)
    {
	List<OrderedItem> orderedItems = new ArrayList<>();
	for(int i = 0; i < items.size();i++)
	{
	    Item item = items.get(i);
	    orderedItems.add(new OrderedItem(item.getPizza(),item.getQuantity(),customer,item.getSize()));
	}
	
	Ordered newOrdered = new Ordered(customer,items.stream().mapToInt(it -> it.getQuantity()).sum(),adress,orderedItems);
	orderRepository.save(newOrdered);
	return newOrdered;
    }

    @Override
    public List<Ordered> findOrdersByCustomer(Customer customer)
    {
	return orderRepository.findAllByCustomer(customer);
    }

}
