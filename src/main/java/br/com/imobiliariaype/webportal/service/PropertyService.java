package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Customer;
import br.com.imobiliariaype.webportal.model.Property;

import java.util.ArrayList;

public class PropertyService {

    public static Customer addProperty(Customer foundCustomer, Property property) {
        if (foundCustomer.getOwnedProperty() == null){
            foundCustomer.setOwnedProperty(new ArrayList<>());
        }
        foundCustomer.getOwnedProperty().add(property);
        return foundCustomer;
    }

    public static Customer sellProperty(Customer foundCustomer, int index) {
        if (foundCustomer.getSoldProperty() == null){
            foundCustomer.setSoldProperty(new ArrayList<>());
        }
        if (!foundCustomer.getOwnedProperty().isEmpty()){
            foundCustomer.getSoldProperty().add(foundCustomer.getOwnedProperty().get(index-1));
            foundCustomer.getOwnedProperty().remove(index-1);
        }
        return foundCustomer;
    }
}
