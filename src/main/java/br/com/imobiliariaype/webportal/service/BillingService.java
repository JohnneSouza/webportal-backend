package br.com.imobiliariaype.webportal.service;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillingService {

    private BillingService() {
    }

    public static Customer addBilling(Double value, Customer customer, String description, String dueDate){
        Billing billing = populateBilling(value, description, dueDate);
        if(customer.getCurrentBilling() == null){
            customer.setCurrentBilling(new ArrayList<>());
        }
        customer.getCurrentBilling().add(billing);
        return customer;
    }

    public static Customer payBilling(Customer customer, int index){
        if(customer.getPaidBilling() == null){
            customer.setPaidBilling(new ArrayList<>());
        }
        if(!customer.getCurrentBilling().isEmpty()){
            customer.getPaidBilling().add(customer.getCurrentBilling().get(index-1));
            customer.getPaidBilling().get(index-1).setPaymentDate(new Date().toString());
            customer.getCurrentBilling().remove(index-1);
        }

        return customer;
    }

    public static Double getCurrentBillsSum(List<Billing> currentBilling){
        return !currentBilling.isEmpty() ?
                currentBilling.stream().mapToDouble(Billing::getValue).sum() : null;
    }

    public static Double getPaidCurrentBilling(List<Billing> paidBilling){
        return !paidBilling.isEmpty() ?
                paidBilling.stream().mapToDouble(Billing::getValue).sum() : null;
    }

    private static Billing populateBilling(Double value, String description, String dueDate){
        Billing billing = new Billing();
        billing.setRegisterDate(new Date().toString());
        billing.setDescription(description);
        billing.setValue(value);
        billing.setDueDate(dueDate);
        return billing;
    }

}
