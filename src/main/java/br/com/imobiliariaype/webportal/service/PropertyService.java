package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.model.Property;
import br.com.imobiliariaype.webportal.repository.CustomerRepository;
import br.com.imobiliariaype.webportal.repository.PropertyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private CustomerRepository customerRepository;
    private SoldPropertyService soldPropertyService;

    private static Logger logger = LogManager.getLogger(PropertyService.class);

    public PropertyService(PropertyRepository propertyRepository, CustomerRepository customerRepository, SoldPropertyService soldPropertyService) {
        this.propertyRepository = propertyRepository;
        this.customerRepository = customerRepository;
        this.soldPropertyService = soldPropertyService;
    }

    public Page<Property> findAll(Pageable pageable){
        return propertyRepository.findAll(pageable);
    }

    public Property save(String personId, @Valid Property property){
        Optional<Customer> foundCustomer = customerRepository.findById(personId);
        if (foundCustomer.isPresent()){
            property.setCustomer_id(personId);
            return propertyRepository.save(property);
        }

        logger.info("[] PROPERTY NOT FOUND");
        return null;
    }

    public Property findById(String id){
        Optional<Property> foundProperty = propertyRepository.findById(id);
        return foundProperty.orElse(null);
    }

    public void sellProperty(String id){
        Property found = findById(id);

        propertyRepository.deleteById(id);
    }
}