package whz.pti.eva.pizzaservice.customer.domain;

import javax.persistence.Entity;

import whz.pti.eva.pizzaservice.config.BaseEntity;

@Entity  
public class DeliveryAdress extends BaseEntity<Long>
{
    private String name = "Default name";
    private String familyName = "Default FamilyName";
    private String street = "Default Street";
    private String houseNumber = "Default HouseNumber";
    private String town = "Default Town";
    private String postalCode = "Default PostalCode";
    
    public DeliveryAdress()
    {

    }
    public DeliveryAdress(String name,String familyName,String street, String houseNumber, String town, String postalCode)
    {
	super();
	this.name = name;
	this.familyName = familyName;
	this.street = street;
	this.houseNumber = houseNumber;
	this.town = town;
	this.postalCode = postalCode;
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
}
