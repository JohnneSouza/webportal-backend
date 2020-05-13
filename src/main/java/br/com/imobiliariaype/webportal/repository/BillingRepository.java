package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Billing;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillingRepository extends PagingAndSortingRepository<Billing, String> {
}
