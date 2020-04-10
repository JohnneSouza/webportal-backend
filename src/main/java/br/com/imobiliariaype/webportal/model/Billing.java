package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("billing")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billing {

    @Id
    private String id;
    private String personId;
    private String registerDate;
    private String dueDate;
    private String description;
    private Double value;
    private String paymentDate;

}
