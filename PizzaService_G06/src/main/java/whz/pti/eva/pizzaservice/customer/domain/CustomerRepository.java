package whz.pti.eva.pizzaservice.customer.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import whz.pti.eva.pizzaservice.pizza.domain.Pizza;



public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	public List<Customer> findAll();
	
	public <S extends Customer> S save(Customer pizza);
	
	public Customer findByEmail(String name);
}
