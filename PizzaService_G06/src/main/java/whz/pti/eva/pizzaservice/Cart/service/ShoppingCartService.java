package whz.pti.eva.pizzaservice.Cart.service;

import java.util.List;

import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaservice.Cart.domain.CartItemDTO;
import whz.pti.eva.pizzaservice.Cart.domain.Item;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;

public interface ShoppingCartService
{
	void addItem(Item item);
	void removeItem(Item item);
	void addPizza(Pizza pizza,PizzaSize size,int num);
	void removePizza(Pizza pizza,PizzaSize size,int num);
	double getTotal();
	List<CartItemDTO> getAllItemsDTO();
	List<Item> getAllItems();
	void removeItem(Long id);
	void removeAll();
	public DeliveryAdress getDestination();
	public void setDestination(DeliveryAdress destination);

}
