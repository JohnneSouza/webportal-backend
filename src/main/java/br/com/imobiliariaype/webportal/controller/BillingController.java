package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.service.BillingService;
import br.com.imobiliariaype.webportal.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/billing")
public class BillingController {

    private CustomerService customerService;

    public BillingController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Customer> addBilling(@PathVariable String id, @RequestParam("value") Double value,
                                     @RequestParam("dueDate") String dueDate,
                                     @RequestParam("description") String description){

        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customerService.save(BillingService.addBilling(value, foundCustomer, description, dueDate));
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity payBilling(@PathVariable String id, @RequestParam("index") int index){
        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customerService.save(BillingService.payBilling(foundCustomer, index));
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
