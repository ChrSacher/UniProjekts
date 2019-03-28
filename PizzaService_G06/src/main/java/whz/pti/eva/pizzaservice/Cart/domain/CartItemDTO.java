package whz.pti.eva.pizzaservice.Cart.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import whz.pti.eva.pizzaservice.pizza.domain.PizzaDTO;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;

public class CartItemDTO implements java.io.Serializable
{	
	/**
     * 
     */
    private static final long serialVersionUID = 3357196195749598341L;

    	private Long id;
    	
	private int quantity;	
	
	private PizzaSize size;
	
	private PizzaDTO pizza;
	
	private double price;
	
	public CartItemDTO(Item item,double price)
	{
	    id = item.getId();
	    quantity = item.getQuantity();
	    size = item.getSize();
	    pizza = new PizzaDTO(item.getPizza());
	    this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
	    return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
	    this.quantity = quantity;
	}

	/**
	 * @return the size
	 */
	public PizzaSize getSize()
	{
	    return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(PizzaSize size)
	{
	    this.size = size;
	}

	/**
	 * @return the pizza
	 */
	public PizzaDTO getPizza()
	{
	    return pizza;
	}

	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(PizzaDTO pizza)
	{
	    this.pizza = pizza;
	}

	/**
	 * @return the price
	 */
	public double getPrice()
	{
	    return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
	    this.price = price;
	}
	/**
	 * @return the id
	 */
	public Long getId()
	{
	    return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
	    this.id = id;
	}
}
