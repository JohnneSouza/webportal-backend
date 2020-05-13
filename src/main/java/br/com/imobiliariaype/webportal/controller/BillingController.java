package br.com.imobiliariaype.webportal.controller;

import br.com.imobiliariaype.webportal.service.BillingService;
import br.com.imobiliariaype.webportal.utils.HeadersUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
