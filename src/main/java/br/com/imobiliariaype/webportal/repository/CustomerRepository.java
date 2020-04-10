package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

}
