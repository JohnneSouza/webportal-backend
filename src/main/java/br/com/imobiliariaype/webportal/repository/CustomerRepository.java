package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    List<Customer> findByName(String name);

    Customer findByAddress_Street(String address);

    List<Billing> findByCurrentBilling(Date from, Date to);

}
