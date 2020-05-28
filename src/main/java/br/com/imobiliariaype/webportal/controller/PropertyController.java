package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Property;
import br.com.imobiliariaype.webportal.service.PropertyService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/property")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        HttpHeaders header = HeadersUtils.pageAmountTotalCount(propertyService.findAll(pageable).getTotalPages());

        return ResponseEntity.ok()
                .headers(header)
                .body(propertyService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public Property findById(@PathVariable String id){
        return propertyService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Property property){
        HttpHeaders header = HeadersUtils.CORS_RESPONSE();

        return ResponseEntity.ok()
        .headers(header)
        .body(propertyService.save(property.getCustomer_id(), property));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        propertyService.sellProperty(id);
    }

    @DeleteMapping("/sell/{id}")
    public void sellProperty(@PathVariable String id) {
        propertyService.sellProperty(id);
    }
}
