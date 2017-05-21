package carrental.rentalOrder.service;

import carrental.rentalOrder.model.RentalOrder;
import carrental.rentalOrder.repository.RentalOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class RentalOrderServiceImpl implements RentalOrderService {
    @Autowired
    RentalOrderRepository rentalOrderRepository;

    @Override
    public List<RentalOrder> getAllRentalOrders() {
        List<RentalOrder> rentalOrders = rentalOrderRepository.findAll();
        return rentalOrders;
    }

    @Override
    public RentalOrder getRentalOrderById(Long id) {
        RentalOrder rentalOrder = rentalOrderRepository.findOne(id);
        return rentalOrder;
    }

    @Override
    public RentalOrder addRentalOrder(RentalOrder rentalOrder) {
        rentalOrderRepository.save(rentalOrder);
        return rentalOrder;
    }

    @Override
    public RentalOrder updateRentalOrder(RentalOrder rentalOrder) {
        RentalOrder foundRentalOrder = rentalOrderRepository.findOne(rentalOrder.getId());
        if (foundRentalOrder == null) {
            throw new NoResultException("Cannot update RentalOrder. Object not found.");
        }
        rentalOrderRepository.save(rentalOrder);
        return rentalOrder;
    }

    @Override
    public void deleteRentalOrder(Long id) {
        RentalOrder foundRentalOrder = rentalOrderRepository.findOne(id);
        if (foundRentalOrder == null) {
            throw new NoResultException("Cannot update RentalOrder. Object not found.");
        }
        rentalOrderRepository.delete(id);
    }
}
