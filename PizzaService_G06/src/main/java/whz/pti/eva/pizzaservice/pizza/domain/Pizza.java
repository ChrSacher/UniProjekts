package whz.pti.eva.pizzaservice.pizza.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import whz.pti.eva.pizzaservice.config.BaseEntity;

@Entity
public class Pizza extends BaseEntity<Long>
{

    private String name = "Default Name";

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Map<PizzaSize, PizzaSizePrice> sizePricesMap= new HashMap<>();;
    
    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    /**
     * @return the sizePricesMap
     */
    public Map<PizzaSize, PizzaSizePrice> getSizePricesMap()
    {
	return sizePricesMap;
    }

    public Pizza()
    {
	this("Default");
    }

    public Pizza(String name)
    {
	super();
	this.name = name;
    }
   
    /**
     * @param sizePricesMap
     *            the sizePricesMap to set
     */
    public void setSizePricesMap(Map<PizzaSize, PizzaSizePrice> sizePricesMap)
    {
	this.sizePricesMap = sizePricesMap;
    }

    public void addSize(PizzaSize size, double price)
    {
	addSize(size, new Double(price));
    }

    public void addSize(PizzaSize size, Double price)
    {
	if (price.doubleValue() <= 0)
	    return;
	sizePricesMap.put(size, new PizzaSizePrice(size, price));
    }

	public double getPrice(PizzaSize size)
	{
		PizzaSizePrice price = sizePricesMap.get(size);
		if(price == null) return 0;
		return price.getPrice();
	}

}
