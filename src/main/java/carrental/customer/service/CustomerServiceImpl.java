package carrental.customer.service;

import java.util.List;

import javax.persistence.NoResultException;


import carrental.customer.model.Customer;
import carrental.customer.repository.CustomerRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAllCustomers() {
        List <Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customerId = customerRepository.findOne(id);
        return customerId;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer foundCustomer = customerRepository.findOne(customer.getId());
        if (foundCustomer == null) {
            throw new NoResultException("Cannot update Customer. Object not found.");
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer foundCustomer = customerRepository.findOne(id);
        if (foundCustomer == null) {
            throw new NoResultException("Cannot delete Customer. Object not found.");
        }
        customerRepository.delete(id);
    }

}