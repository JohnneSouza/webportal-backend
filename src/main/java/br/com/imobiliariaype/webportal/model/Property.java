package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Document("property")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Property {

    @Id
    private String id;
    @NotNull
    private String personId;
    private Float sellingPrice;
    private String additionalData;
    private Address address;

    private Date registerDate;
    private Date soldDate;

}
