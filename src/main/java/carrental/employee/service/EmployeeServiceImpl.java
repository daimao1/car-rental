package carrental.employee.service;

import carrental.employee.model.Employee;
import carrental.employee.repository.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employeeId = employeeRepository.findOne(id);
        return employeeId;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee foundEmployee = employeeRepository.findOne(employee.getId());
        if (foundEmployee == null) {
            throw new NoResultException("Cannot update Customer. Object not found.");
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee foundEmployee = employeeRepository.findOne(id);
        if (foundEmployee == null) {
            throw new NoResultException("Cannot delete Customer. Object not found.");
        }
        employeeRepository.delete(id);
    }

}
