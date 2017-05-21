package carrental.rentalOrder.controller;

import carrental.rentalOrder.model.RentalOrder;
import carrental.rentalOrder.service.RentalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalorder")
public class RentalOrderController {

    @Autowired
    RentalOrderService rentalOrderService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RentalOrder>> getRentalOrders() {
        List<RentalOrder> rentalOrders = rentalOrderService.getAllRentalOrders();
        return new ResponseEntity<>(rentalOrders, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentalOrder> getRentalOrderById(@PathVariable("id") Long id) {
        RentalOrder rentalOrder = rentalOrderService.getRentalOrderById(id);
        return new ResponseEntity<>(rentalOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentalOrder> addRentalOrder(@RequestBody RentalOrder rentalOrder) {
        RentalOrder createdRentalOrder = rentalOrderService.addRentalOrder(rentalOrder);
        return new ResponseEntity<>(createdRentalOrder, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentalOrder> updateRentalOrder(@RequestBody RentalOrder rentalOrder) {
        RentalOrder updatedRentalOrder = rentalOrderService.updateRentalOrder(rentalOrder);
        return new ResponseEntity<>(updatedRentalOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRentalOrder(@PathVariable("id") Long id) {
        rentalOrderService.deleteRentalOrder(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
