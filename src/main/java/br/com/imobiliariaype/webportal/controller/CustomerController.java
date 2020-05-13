package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.service.CustomerService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        HttpHeaders header = HeadersUtils.pageAmountTotalCount(customerService.findAll(pageable).getTotalPages());

        return ResponseEntity.ok()
        .headers(header)
        .body(customerService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id){
        return customerService.findById(id);
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
