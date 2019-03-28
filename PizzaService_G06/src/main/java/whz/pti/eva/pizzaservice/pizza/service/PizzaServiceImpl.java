package whz.pti.eva.pizzaservice.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaDTO;
import whz.pti.eva.pizzaservice.pizza.domain.PizzaRepository;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService
{

	@Autowired
	PizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> listAllPizzas()
	{
		// TODO Auto-generated method stub
		return pizzaRepository.findAll();
	}

	@Override
	public Optional<Pizza> getById(Long id)
	{
	    return pizzaRepository.findById(id);
	}

	@Override
	public List<PizzaDTO> findAllAsDTO()
	{
	    // TODO Auto-generated method stub
	    return pizzaRepository.findAllAsDTO();
	}

}
