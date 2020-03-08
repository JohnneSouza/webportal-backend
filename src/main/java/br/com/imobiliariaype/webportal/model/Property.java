package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Property {

    private String id;
    private Float sellingPrice;
    private String additionalData;
    private Address address;

    private Date registerDate;
    private Date soldDate;

}
