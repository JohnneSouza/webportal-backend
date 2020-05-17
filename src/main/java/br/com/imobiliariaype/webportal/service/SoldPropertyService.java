package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Property;
import br.com.imobiliariaype.webportal.repository.SoldPropertyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class SoldPropertyService {

    private SoldPropertyRepository soldPropertyRepository;

    public SoldPropertyService(SoldPropertyRepository soldPropertyRepository) {
        this.soldPropertyRepository = soldPropertyRepository;
    }

    @GetMapping
    public Page<Property> findAll(Pageable pageable){
        return soldPropertyRepository.findAll(pageable);
    }
}
