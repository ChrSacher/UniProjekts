package whz.pti.eva.pizzaservice.Cart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import whz.pti.eva.pizzaservice.config.BaseEntity;
import whz.pti.eva.pizzaservice.customer.domain.Customer;
import whz.pti.eva.pizzaservice.customer.domain.DeliveryAdress;

@Entity
public class Ordered extends BaseEntity<Long>
{
    @ManyToOne
    private Customer customer;

    private int numberOFItems = 0;
    //merge, weil die Adresse ebereits in the Datenbank steht
    @ManyToOne(cascade=CascadeType.MERGE)
    private DeliveryAdress address;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderedItem> items = new ArrayList<>();

    /**
     * @param customer
     * @param numberOFItems
     * @param items
     */
    public Ordered(Customer customer, int numberOFItems,DeliveryAdress address, List<OrderedItem> items)
    {
	super();
	this.customer = customer;
	this.numberOFItems = numberOFItems;
	this.address = address;
	this.items.addAll(items);
    }

    public int getNumberOFItems()
    {
	return numberOFItems;
    }

    public void setNumberOFItems(int numberOFItems)
    {
	this.numberOFItems = numberOFItems;
    }

    public List<OrderedItem> getItems()
    {
	return items;
    }

    public void setItems(List<OrderedItem> items)
    {
	this.items = items;
    }

    /**
     * 
     * @param item
     *            needs an Ordered Item
     */
    public void addItem(OrderedItem item)
    {
	if (item != null)
	{
	    this.items.add(item);
	}
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Ordered other = (Ordered) obj;
	return customer.getId() != null && customer.getId().equals(other.customer.getId());
    }
}
