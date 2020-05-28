package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.PaidBilling;
import br.com.imobiliariaype.webportal.repository.BillingRepository;
import br.com.imobiliariaype.webportal.repository.PaidBillingRepository;
import br.com.imobiliariaype.webportal.translator.BillingTranslator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingService {

    private BillingRepository billingRepository;
    private PaidBillingRepository paidBillingRepository;

    public BillingService(BillingRepository billingRepository, PaidBillingRepository paidBillingRepository) {
        this.billingRepository = billingRepository;
        this.paidBillingRepository = paidBillingRepository;
    }

    public Page<Billing> findAll(Pageable pageable){
        return billingRepository.findAll(pageable);
    }


    public Billing createNew(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing findById(String id) {
        Optional<Billing> foundBilling = billingRepository.findById(id);
        return foundBilling.orElse(null);
    }

    public Billing deleteById(String id){
        Optional<Billing> foundBilling = billingRepository.findById(id);
        billingRepository.deleteById(id);
        return foundBilling.orElse(null);
    }

    public void payBilling(String id) {
        Billing found = findById(id);
        PaidBilling paid = BillingTranslator.translateToPaidBilling(found);

        billingRepository.deleteById(id);
        paidBillingRepository.save(paid);
    }
}
