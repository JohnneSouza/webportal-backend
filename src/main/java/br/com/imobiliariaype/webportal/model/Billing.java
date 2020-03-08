package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billing {

    private String registerDate;
    private String dueDate;
    private String description;
    private Double value;
    private String paymentDate;

}
