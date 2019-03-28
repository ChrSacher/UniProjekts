package whz.pti.eva.pizzaservice.pizza.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends JpaRepository<Pizza, Long>
{
    public List<Pizza> findAll();

    @Query("SELECT new whz.pti.eva.pizzaservice.pizza.domain.PizzaDTO(p) FROM Pizza p ")
    List<PizzaDTO> findAllAsDTO();

    public Optional<Pizza> findById(long id);

    public <S extends Pizza> S save(Pizza pizza);

}
