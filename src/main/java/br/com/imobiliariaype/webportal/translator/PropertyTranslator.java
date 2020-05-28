package br.com.imobiliariaype.webportal.translator;

import br.com.imobiliariaype.webportal.model.Property;
import br.com.imobiliariaype.webportal.model.SoldProperty;

import java.util.Date;

public class PropertyTranslator {

    private PropertyTranslator() {
    }

    public static SoldProperty translateToProperty(Property property){

        SoldProperty sold = new SoldProperty();

        sold.setCustomer_id(property.getCustomer_id());
        sold.setAdditionalData(property.getAdditionalData());
        sold.setAddress(property.getAddress());
        sold.setId(property.getId());
        sold.setRegisterDate(property.getRegisterDate());
        sold.setSellingPrice(property.getSellingPrice());
        sold.setSoldDate(new Date());

        return sold;
    }
}
