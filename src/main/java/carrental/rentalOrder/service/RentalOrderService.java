package carrental.rentalOrder.service;

import carrental.rentalOrder.model.RentalOrder;

import java.util.List;

public interface RentalOrderService {
    List<RentalOrder> getAllRentalOrders();

    RentalOrder getRentalOrderById(Long id);

    RentalOrder addRentalOrder(RentalOrder rentalOrder);

    RentalOrder updateRentalOrder(RentalOrder rentalOrder);

    void deleteRentalOrder(Long id);
}
