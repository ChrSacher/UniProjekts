package whz.pti.eva.pizzaservice.Cart.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import whz.pti.eva.pizzaservice.customer.domain.Customer;

public interface OrderedRepository extends JpaRepository<Ordered, Long>
{
    public <S extends Ordered> S save(Ordered ordered);
    public List<Ordered> findAllByCustomer(Customer customer);
}
