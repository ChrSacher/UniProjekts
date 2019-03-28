package whz.pti.eva.pizzaservice.pizza.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PizzaDTO implements java.io.Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String name;
    
    
    private  List<PizzaSizePrice> prices;
    
    public PizzaDTO(Pizza pizza)
    {
	id = pizza.getId();
	name = pizza.getName();
	prices = new ArrayList<>(pizza.getSizePricesMap().values());
	prices.sort(new Comparator<PizzaSizePrice>()
	{
	    @Override
	    public int compare(PizzaSizePrice o1, PizzaSizePrice o2)
	    {
		return o1.getSize().compareTo(o2.getSize());
	    }
	});
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

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the prices
     */
    public List<PizzaSizePrice> getPrices()
    {
        return prices;
    }

    /**
     * @param prices the prices to set
     */
    public void setPrices(List<PizzaSizePrice> prices)
    {
        this.prices = prices;
    }
}
