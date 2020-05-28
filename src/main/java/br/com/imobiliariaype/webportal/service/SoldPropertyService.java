package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.SoldProperty;
import br.com.imobiliariaype.webportal.repository.SoldPropertyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoldPropertyService {

    private SoldPropertyRepository soldPropertyRepository;

    public SoldPropertyService(SoldPropertyRepository soldPropertyRepository) {
        this.soldPropertyRepository = soldPropertyRepository;
    }

    public Page<SoldProperty> findAll(Pageable pageable){
        return soldPropertyRepository.findAll(pageable);
    }

    public Optional<SoldProperty> findById(String id){
        return soldPropertyRepository.findById(id);
    }

    public void deleteById(String id){
        soldPropertyRepository.deleteById(id);
    }
}
