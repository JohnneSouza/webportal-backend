package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static Logger logger = LogManager.getLogger(CustomerService.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer findByAddress(String address) {
        return customerRepository.findByAddress_Street(address);
    }

    public Customer findById(String id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        return foundCustomer.orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer deleteById(String id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return new Customer();
        }
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

    public List<Billing> getCurrentBillingByDate(String initialDate, String finalDate) {
        try {
            return customerRepository.findByCurrentBilling(sdf.parse(initialDate), sdf.parse(finalDate));
        } catch (ParseException e) {
            logger.error("Error Converting Date", e);
            return null;
        }
    }
}
