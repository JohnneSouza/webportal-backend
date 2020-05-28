package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document("billing")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billing {

    @Id
    private String id;
    private String customer_id;
    private String registerDate;
    private Date dueDate;
    private String description;
    private Double value;
    private Date paymentDate;

}
