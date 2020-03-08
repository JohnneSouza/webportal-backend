package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    private String street;
    private String number;
    private String zip;
    private String neighborhood;
    private String state;
    private String city;

}
