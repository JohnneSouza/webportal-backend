package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.model.Property;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, String> {

}
