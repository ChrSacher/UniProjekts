package whz.pti.eva.pizzaservice.Cart.domain;

import java.io.Serializable;

import javax.persistence.*;

import whz.pti.eva.pizzaservice.config.BaseEntity;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaSize;

@Entity
public class OrderedItem  extends BaseEntity<Long> 
{
    @ManyToOne
    private Pizza pizza;
    
    private int quantity = 0;

    @ManyToOne
    private Customer customer;
    
    @Enumerated(EnumType.STRING)
    private PizzaSize size;
    
    /**
     * @param pizza
     * @param quantity
     * @param customer
     * @param size
     */
    public OrderedItem(Pizza pizza, int quantity, Customer customer, PizzaSize size)
    {
	super();
	this.pizza = pizza;
	this.quantity = quantity;
	this.customer = customer;
	this.size = size;
    }


    public OrderedItem()
    {

    }


    public int getQuantity()
    {
	return quantity;
    }

    public void setQuantity(int quantity)
    {
	this.quantity = quantity;
    }


    public PizzaSize getSize()
    {
	return size;
    }

    public void setSize(PizzaSize size)
    {
	this.size = size;
    }


    /**
     * @return the pizza
     */
    public Pizza getPizza()
    {
        return pizza;
    }


    /**
     * @param pizza the pizza to set
     */
    public void setPizza(Pizza pizza)
    {
        this.pizza = pizza;
    }


    /**
     * @return the customer
     */
    public Customer getCustomer()
    {
        return customer;
    }


    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }



}
