package whz.pti.eva.pizzaservice.Cart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import whz.pti.eva.pizzaservice.config.BaseEntity;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;


@Entity
public class Cart  extends BaseEntity<Long> 
{
    	@ManyToOne
    	private DeliveryAdress destination;
	
	@OneToMany
	private List<Item> items;
	
	@OneToOne
	private Customer attachedCustomer;
	
	public Cart()
	{
		this.items = new ArrayList<>();
	}

	public List<Item> getItems()
	{
		return items;
	}

	public void setItems(List<Item> items)
	{
		this.items = items;
	}
	
	public void addItem(Item item)
	{
		if (item != null) {
			this.items.add(item);
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
	    Cart other = (Cart) obj;
	    return getId() != null && getId().equals(other.getId());
	}

	/**
	 * @return the destination
	 */
	public DeliveryAdress getDestination()
	{
	    return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(DeliveryAdress destination)
	{
	    this.destination = destination;
	}

	/**
	 * @return the attachedCustomer
	 */
	public Customer getAttachedCustomer()
	{
	    return attachedCustomer;
	}

	/**
	 * @param attachedCustomer the attachedCustomer to set
	 */
	public void setAttachedCustomer(Customer attachedCustomer)
	{
	    this.attachedCustomer = attachedCustomer;
	}
}
