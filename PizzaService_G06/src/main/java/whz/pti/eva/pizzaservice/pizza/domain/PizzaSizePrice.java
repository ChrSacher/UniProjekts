package whz.pti.eva.pizzaservice.pizza.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import whz.pti.eva.pizzaservice.config.BaseEntity;

@Entity
public class PizzaSizePrice extends BaseEntity<Long> 
{    
    @Enumerated(EnumType.STRING)
    private PizzaSize size = PizzaSize.Small;
    
    private Double price = 1.0;
    
    public PizzaSizePrice()
    {
	
    }
    
    public PizzaSizePrice(PizzaSize size, Double price)
    {
	super();
	this.size = size;
	this.price = price;
    }
    /**
     * @return the size
     */
    public PizzaSize getSize()
    {
        return size;
    }
    /**
     * @return the price
     */
    public Double getPrice()
    {
        return price;
    }
    
}
