package whz.pti.eva.pizzaservice.Cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.pizzaservice.Cart.domain.Cart;
import whz.pti.eva.pizzaservice.Cart.domain.CartItemDTO;
import whz.pti.eva.pizzaservice.Cart.domain.Item;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;
import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService
{

	@Autowired
	private PizzaRepository pizzaRepository;

	private Cart itemCart = new Cart();

	@Override
	public List<CartItemDTO> getAllItemsDTO()
	{
		List<CartItemDTO> itemDTOs = new ArrayList<>();
		for (Item item : itemCart.getItems())
		{
			Optional<Pizza> pizza = pizzaRepository.findById(item.getPizza().getId());
			if (pizza.isPresent())
			{
				itemDTOs.add(new CartItemDTO(item, pizza.get().getPrice(item.getSize()) * item.getQuantity()));
			}

		}

		return itemDTOs;
	}

	@Override
	public double getTotal()
	{
		double total = 0;
		for (Item item : itemCart.getItems())
		{
			Optional<Pizza> pizza = pizzaRepository.findById(item.getPizza().getId());
			if (pizza.isPresent())
			{
				total += pizza.get().getPrice(item.getSize()) * item.getQuantity();
			}

		}

		return total;
	}

	@Override
	public void addItem(Item item)
	{
		for (Item setItem : itemCart.getItems())
		{
			if (setItem.getPizza().getId() == item.getPizza().getId() && setItem.getSize() == item.getSize())
			{
				setItem.setQuantity(setItem.getQuantity() + item.getQuantity());
				return;
			}

		}
		itemCart.getItems().add(item);

	}
	
	@Override
	public void removeItem(Long id)
	{
		for (Item setItem : itemCart.getItems())
		{
			if (setItem.getId() == id)
			{
			    	itemCart.getItems().remove(setItem);
				return;
			}

		}

	}
	
	@Override
	public void removeItem(Item item)
	{
		for (Item setItem : itemCart.getItems())
		{
			if (setItem.getPizza().getId() == item.getPizza().getId() && setItem.getSize() == item.getSize())
			{
				setItem.setQuantity(setItem.getQuantity() - item.getQuantity());
				if (setItem.getQuantity() <= 0)
				    itemCart.getItems().remove(setItem);
				return;
			}

		}

	}

	@Override
	public void addPizza(Pizza pizza, PizzaSize size, int num)
	{
		for (Item setItem : itemCart.getItems())
		{
			if (setItem.getPizza().getId() == pizza.getId() && setItem.getSize() == size)
			{
				setItem.setQuantity(setItem.getQuantity() + num);
				return;
			}

		}
		itemCart.getItems().add(new Item(num, size, pizza));

	}

	@Override
	public void removePizza(Pizza pizza, PizzaSize size, int num)
	{
		for (Item setItem : itemCart.getItems())
		{
			if (setItem.getPizza().getId() == pizza.getId() && setItem.getSize() == size)
			{
				setItem.setQuantity(setItem.getQuantity() - num);
				if (setItem.getQuantity() <= 0)
				    itemCart.getItems().remove(setItem);
				return;
			}

		}

	}

	@Override
	public void removeAll()
	{
	    itemCart.getItems().clear();
	    
	}

	@Override
	public List<Item> getAllItems()
	{
	   return new ArrayList<Item>(Arrays.asList(itemCart.getItems().toArray(new Item[0])));
	}

	public DeliveryAdress getDestination()
	{
	    return itemCart.getDestination();
	}

	public void setDestination(DeliveryAdress destination)
	{
	    itemCart.setDestination(destination);
	}

}
