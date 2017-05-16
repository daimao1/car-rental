package carrental.customer.service;

import carrental.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List <Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer loadCustomerByFullName(String fullName);
}
