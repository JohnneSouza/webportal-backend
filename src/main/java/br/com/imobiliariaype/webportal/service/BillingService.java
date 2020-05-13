package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.repository.BillingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    private BillingRepository billingRepository;


    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Page<Billing> findAll(Pageable pageable){
        return billingRepository.findAll(pageable);
    }


}
