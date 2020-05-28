package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.PaidBilling;
import br.com.imobiliariaype.webportal.service.PaidBillingService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/paidBilling")
public class PaidBillingController {

    private PaidBillingService paidBillingService;

    public PaidBillingController(PaidBillingService paidBillingService) {
        this.paidBillingService = paidBillingService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        HttpHeaders header = HeadersUtils.pageAmountTotalCount(paidBillingService.findAll(pageable).getTotalPages());

        return ResponseEntity.ok()
                .headers(header)
                .body(paidBillingService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public PaidBilling findById(@PathVariable String id){
        return paidBillingService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable String id){
        paidBillingService.deleteById(id);
    }
}
