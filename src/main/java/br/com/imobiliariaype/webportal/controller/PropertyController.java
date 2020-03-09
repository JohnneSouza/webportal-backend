package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.model.Property;
import br.com.imobiliariaype.webportal.model.PropertyResponse;
import br.com.imobiliariaype.webportal.service.CustomerService;
import br.com.imobiliariaype.webportal.service.PropertyService;
import br.com.imobiliariaype.webportal.utils.HeaderUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/property")
public class PropertyController {

    private CustomerService customerService;

    public PropertyController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        List<PropertyResponse> properties = new ArrayList<>();

        for (Customer c : customerService.findAll(pageable)) {
            if (c.getOwnedProperty() != null) {
                for(Property p : c.getOwnedProperty()){
                    PropertyResponse r = new PropertyResponse();
                    r.setId(String.valueOf(properties.size()+1));
                    r.setOwnerName(c.getName());
                    r.setOwnerId(c.getId());
                    r.setOwnerPhone(c.getPhone());
                    r.setSellingPrice(p.getSellingPrice());
                    properties.add(r);
                }
            }
        }

        return ResponseEntity.ok()
                .headers(HeaderUtils.getTotalCount(customerService.findAll(pageable).getTotalPages()))
                .body(properties);
    }

    @PostMapping("/{id}")
    public ResponseEntity addProperty(@PathVariable String id, @RequestBody Property property){
        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customerService.save(PropertyService.addProperty(foundCustomer, property));
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(property);
        }

        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity sellPorperty(@PathVariable String id, @RequestParam Integer index){
        Customer foundCustomer = customerService.findById(id);
        if (foundCustomer != null) {
            customerService.save(PropertyService.sellProperty(foundCustomer, index));
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);

    }


}
