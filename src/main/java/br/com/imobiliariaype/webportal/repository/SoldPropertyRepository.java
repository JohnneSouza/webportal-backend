package br.com.imobiliariaype.webportal.repository;

import br.com.imobiliariaype.webportal.model.SoldProperty;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SoldPropertyRepository extends PagingAndSortingRepository<SoldProperty, String> {
}
