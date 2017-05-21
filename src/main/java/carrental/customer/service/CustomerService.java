package carrental.customer.service;

import carrental.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List <Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}
