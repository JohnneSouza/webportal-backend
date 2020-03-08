package br.com.imobiliariaype.webportal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyResponse {

    private String id;
    private String ownerName;
    private String ownerId;
    private Float sellingPrice;
    private String ownerPhone;

}
