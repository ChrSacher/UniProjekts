package whz.pti.eva.pizzaservice.customer.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAdress, Long>
{
    public List<DeliveryAdress> findAll();
    public <S extends DeliveryAdress> S save(DeliveryAdress address);
}
