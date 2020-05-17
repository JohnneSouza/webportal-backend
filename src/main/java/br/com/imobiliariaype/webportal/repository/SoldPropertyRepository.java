package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.Property;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SoldPropertyRepository extends PagingAndSortingRepository<Property, String> {
}
