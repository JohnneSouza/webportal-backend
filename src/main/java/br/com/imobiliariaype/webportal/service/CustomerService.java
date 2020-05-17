package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class CustomerService {

    private static final String CUSTOMER_NOT_FOUND = "[] CUSTOMER NOT FOUND";

    private static Logger logger = LogManager.getLogger(CustomerService.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Customer findById(String id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isPresent()) {
            return foundCustomer.get();
        }

        logger.info(CUSTOMER_NOT_FOUND, id);
        return null;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer deleteById(String id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return new Customer();
        }

        logger.info(CUSTOMER_NOT_FOUND, id);
        return null;
    }

    public Customer update(String id, Customer updatedCustomer) {
        Customer currentCustomer = findById(id);
        if (currentCustomer != null) {
            currentCustomer.setName(updatedCustomer.getName());
            currentCustomer.setDocument(updatedCustomer.getDocument());
            currentCustomer.setPhone(updatedCustomer.getPhone());
            currentCustomer.setEmail(updatedCustomer.getEmail());
            currentCustomer.setAddress(updatedCustomer.getAddress());
            currentCustomer.setAnnotations(updatedCustomer.getAnnotations());

            return customerRepository.save(currentCustomer);
        }

        return null;
    }
}
