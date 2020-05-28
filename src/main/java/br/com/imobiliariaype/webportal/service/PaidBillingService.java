package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.PaidBilling;
import br.com.imobiliariaype.webportal.repository.PaidBillingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaidBillingService {

    private PaidBillingRepository paidBillingRepository;

    public PaidBillingService(PaidBillingRepository paidBillingRepository) {
        this.paidBillingRepository = paidBillingRepository;
    }

    public Page<PaidBilling> findAll(Pageable pageable){
        return paidBillingRepository.findAll(pageable);
    }

    public PaidBilling findById(String id){
        Optional<PaidBilling> foundBilling = paidBillingRepository.findById(id);
        return foundBilling.orElse(null);
    }

    public void deleteById(String id) {
        paidBillingRepository.deleteById(id);
    }
}
