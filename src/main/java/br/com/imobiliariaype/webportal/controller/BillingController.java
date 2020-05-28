package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.service.BillingService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/billing")
public class BillingController {

    private BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        HttpHeaders header = HeadersUtils.pageAmountTotalCount(billingService.findAll(pageable).getTotalPages());

        return ResponseEntity.ok()
                .headers(header)
                .body(billingService.findAll(pageable).toList());
    }

    @GetMapping("/{id}")
    public Billing findById(@PathVariable String id){

        return billingService.findById(id);
    }

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing){
        return billingService.createNew(billing);
    }

    @DeleteMapping("/{id}")
    public Billing deleteBilling(@PathVariable String id){
        return billingService.deleteById(id);
    }

    @DeleteMapping("/pay/{id}")
    public void payBill(@PathVariable String id){
        billingService.payBilling(id);
    }
}
