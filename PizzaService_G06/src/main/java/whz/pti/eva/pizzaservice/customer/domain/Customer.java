package whz.pti.eva.pizzaservice.customer.domain;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import whz.pti.eva.pizzaservice.config.BaseEntity;

@Entity
public class Customer extends BaseEntity<Long> {

	// THIS IS USED BY ACCOUNT SYSTEM TO FIND THIS CUSTOMER FOR THE USER
	private String email = "";

	private String firstName = "Default Name";

	private String lastName = "Default Name";

	@OneToMany(cascade = CascadeType.ALL)
	List<DeliveryAdress> deliveryAddresses = new ArrayList<DeliveryAdress>();

	public void addAdress(DeliveryAdress adress) {
		deliveryAddresses.add(adress);
	}

	public Optional<DeliveryAdress> getAdressById(Long id) {
		return deliveryAddresses.stream().filter(adress -> adress.getId().equals(id)).findFirst();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the deliveryAddresses
	 */
	public List<DeliveryAdress> getDeliveryAddresses() {
		return deliveryAddresses;
	}
	
	public boolean removeAdress(DeliveryAdress adress)
	{
		return deliveryAddresses.remove(adress);
	}
	
	public Optional<DeliveryAdress> updateAdress(DeliveryAdressForm adress, Long ID)
	{
		for(DeliveryAdress a:deliveryAddresses)
		{
			if(a.getId() == ID)
			{
				a.setPostalCode(adress.getPostalCode());
				a.setFamilyName(adress.getFamilyName());
				a.setHouseNumber(adress.getHouseNumber());
				a.setName(adress.getName());
				a.setStreet(adress.getStreet());
				a.setTown(adress.getTown());
				return Optional.ofNullable(a);
			}
		}
		return Optional.ofNullable(null);
	}
}
