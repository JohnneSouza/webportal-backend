package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.Customer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    @Query("{ 'name' : { $regex: ?0 } }")
    Customer findByName(String name);

    @Query("{ 'address' : {'street' : { $regex: ?0 } }}")
    Customer findByAddress(String address);

    @Query("{'dueDate' : { $gte: ?0, $lte: ?1 } }")
    List<Billing> getCurrentBillingByDate(Date from, Date to);

}
