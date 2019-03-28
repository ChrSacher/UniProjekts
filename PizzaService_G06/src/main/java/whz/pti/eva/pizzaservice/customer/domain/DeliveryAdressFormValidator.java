package whz.pti.eva.pizzaservice.customer.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import whz.pti.eva.pizzaservice.security.domain.UserCreateForm;
import whz.pti.eva.pizzaservice.security.service.user.UserService;
import whz.pti.eva.pizzaservice.security.service.validator.UserCreateFormValidator;

@Component
public class DeliveryAdressFormValidator implements Validator
{

	private static final Logger log = LoggerFactory.getLogger(UserCreateFormValidator.class);

	@Autowired
	public DeliveryAdressFormValidator()
	{

	}

	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz.equals(DeliveryAdressForm.class);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		log.debug("Validating {}", target);
		DeliveryAdressForm form = (DeliveryAdressForm) target;
		if (form.getName().equals(""))
		{
			errors.reject("Name is empty");
		}
		if (form.getFamilyName().equals(""))
		{
			errors.reject("Familty Name is empty");
		}
		if (form.getHouseNumber().equals(""))
		{
			errors.reject("House Number is empty");
		}
		if (form.getPostalCode().equals(""))
		{
			errors.reject("PLZ is empty");
		}
		if (form.getTown().equals(""))
		{
			errors.reject("Town is empty");
		}
		if (form.getStreet().equals(""))
		{
			errors.reject("Street is empty");
		}
	}

}
