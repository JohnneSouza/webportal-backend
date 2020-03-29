package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.service.CustomerService;
import br.com.imobiliariaype.webportal.utils.HeaderUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        return ResponseEntity.ok()
        .headers(HeaderUtils.getTotalCount(customerService.findAll(pageable).getTotalPages()))
        .body(customerService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id){
        return customerService.findById(id);
    }

    @GetMapping("/searchByName/{name}")
    public List<Customer> findByName(@PathVariable String name){
        return customerService.findByName(name);
    }

    @GetMapping("/searchByAddress")
    public Customer findByAddress(@RequestParam String address){
        return customerService.findByAddress(address);
    }

    @PostMapping("/billing")
    public Stream<Billing> getCurrentBillingByDate(@RequestParam String initialDate,
                                          @RequestParam("finalDate") String finalDate){
        return customerService.getCurrentBillingByDate(initialDate, finalDate).stream();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody @Valid Customer customer){
        return customerService.update(id, customer);
    }

    @PostMapping
    public Customer save(@RequestBody @Valid Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable String id){
        return customerService.deleteById(id);
    }

}
