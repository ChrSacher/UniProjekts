package whz.pti.eva.pizzaservice.pizza.service;

import java.util.List;
import java.util.Optional;

import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaDTO;

public interface PizzaService
{
	public List<Pizza> listAllPizzas();
	public Optional<Pizza> getById(Long id);
	public List<PizzaDTO> findAllAsDTO();
}
