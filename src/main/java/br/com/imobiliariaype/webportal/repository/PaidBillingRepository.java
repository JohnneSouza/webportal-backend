package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.PaidBilling;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaidBillingRepository extends PagingAndSortingRepository<PaidBilling, String> {
}
