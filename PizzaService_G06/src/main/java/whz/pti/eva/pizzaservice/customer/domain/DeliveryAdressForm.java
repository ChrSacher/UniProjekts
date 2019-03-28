package whz.pti.eva.pizzaservice.customer.domain;

import javax.validation.constraints.NotEmpty;

public class DeliveryAdressForm
{
    @NotEmpty()
    private String name = "";
    @NotEmpty()
    private String familyName = "";
    @NotEmpty()
    private String street = "";
    @NotEmpty()
    private String houseNumber = "";
    @NotEmpty()
    private String town = "";
    @NotEmpty()
    private String postalCode = "";
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
     * @return the familyName
     */
    public String getFamilyName()
    {
        return familyName;
    }
    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }
    /**
     * @return the street
     */
    public String getStreet()
    {
        return street;
    }
    /**
     * @param street the street to set
     */
    public void setStreet(String street)
    {
        this.street = street;
    }
    /**
     * @return the houseNumber
     */
    public String getHouseNumber()
    {
        return houseNumber;
    }
    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }
    /**
     * @return the town
     */
    public String getTown()
    {
        return town;
    }
    /**
     * @param town the town to set
     */
    public void setTown(String town)
    {
        this.town = town;
    }
    /**
     * @return the postalCode
     */
    public String getPostalCode()
    {
        return postalCode;
    }
    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }
    
    public DeliveryAdress toAdress()
    {
	return new DeliveryAdress(getName(), getFamilyName(), getStreet(),
		getHouseNumber(), getTown(), getPostalCode());
	
    }
}
