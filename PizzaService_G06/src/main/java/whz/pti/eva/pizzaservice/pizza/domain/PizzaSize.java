package whz.pti.eva.pizzaservice.pizza.domain;

import java.util.Arrays;

public enum PizzaSize
{
    Small("Small", 0), Medium("Medium", 1), Large("Large", 2);

    private PizzaSize(String name, int order)
    {
	this.name = name;
	this.order = order;
    }

    private String name;
    private int order;

    public static PizzaSize fromValue(String value)
    {
	for (PizzaSize pizza : values())
	{
	    if (pizza.name.equalsIgnoreCase(value))
	    {
		return pizza;
	    }
	}
	throw new IllegalArgumentException(
		"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

    private void compareTo()
    {
	// TODO Auto-generated method stub

    }

    /**
     * @return the name
     */
    public String getName()
    {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
	this.name = name;
    }

    /**
     * @return the order
     */
    public int getOrder()
    {
	return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(int order)
    {
	this.order = order;
    }
}
