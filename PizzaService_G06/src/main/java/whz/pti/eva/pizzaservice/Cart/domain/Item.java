package whz.pti.eva.pizzaservice.Cart.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import whz.pti.eva.pizzaservice.config.BaseEntity;
import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;


@Entity
public class Item  extends BaseEntity<Long> 
{
	
	private String itemId = "Default ItemId";
	
	private int quantity = 0;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	@ManyToOne
	private Pizza pizza;
	
	public Item(int quantity, PizzaSize size, Pizza pizza)
	{
	    super();
	    this.quantity = quantity;
	    this.size = size;
	    this.pizza = pizza;
	}

	public Item() 
	{
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PizzaSize getSize() {
		return size;
	}

	public void setSize(PizzaSize size) {
		this.size = size;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getItemId() {
		return itemId;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
	    Item other = (Item) obj;
	    return getItemId() != null && getItemId().equals(other.getItemId());
	}
}
