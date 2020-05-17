package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Document("customers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    private String id;
    @NotNull(message = "name must not be null")
    private String name;
    private String document;
    @NotNull(message = "phone must not be null")
    private String phone;
    private String email;
    private List<Property> ownedProperty;
    private List<Property> soldProperty;
    private List<Billing> currentBilling;
    private List<Billing> paidBilling;
    private Address address;
    private String annotations;

}
