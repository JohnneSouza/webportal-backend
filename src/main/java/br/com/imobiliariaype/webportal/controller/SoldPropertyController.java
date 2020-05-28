package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.SoldProperty;
import br.com.imobiliariaype.webportal.service.SoldPropertyService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1/soldProperty")
public class SoldPropertyController {

    private SoldPropertyService soldPropertyService;


    public SoldPropertyController(SoldPropertyService soldPropertyService) {
        this.soldPropertyService = soldPropertyService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        HttpHeaders header = HeadersUtils.pageAmountTotalCount(soldPropertyService.findAll(pageable).getTotalPages());

        return ResponseEntity.ok()
                .headers(header)
                .body(soldPropertyService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public SoldProperty findById(@PathVariable String id){
        Optional<SoldProperty> found = soldPropertyService.findById(id);
        return found.orElse(null);

    }
}
