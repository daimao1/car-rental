package carrental.rentalOrder.repository;

import carrental.rentalOrder.model.RentalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalOrderRepository extends JpaRepository<RentalOrder, Long> {
}
